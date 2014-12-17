package controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;

import ejbs.AbstractEjb;
import entities.Relatable;
import entities.entries.files.EntryFile;
import entities.entries.files.images.Image;


/**
 * @author hamadalmarri
 * 
 * @Pages
 *        - addEntryFile.xhtml
 *        - editEntryFile.xhtml
 *        - listEntryFiles.xhtml
 *        - viewEntryFile.xhtml
 * 
 * @Relative_Objects
 *                   - Relatable that this entry file uploaded for
 * 
 */
@ManagedBean(name = "controllerEntryFile")
@ViewScoped
public class ControllerEntryFile implements Serializable {

	private static final long serialVersionUID = -1093413444855839377L;

	// EJB for EntryFile object
	@EJB
	private AbstractEjb<EntryFile> ejbEntryFile;

	// // EJB for Relatable object
	@EJB
	private AbstractEjb<Relatable> ejbRelatable;

	// the id of a EntryFile object
	private String id;

	// path of upload folder
	private String path = "upload";

	// the EntryFile object
	private EntryFile entryFile = null;

	// to indicate if the operation is to add
	// new EntryFile or not
	private boolean newEntity = false;

	// list of EntryFile objects
	private List<EntryFile> entryFilesList = null;

	// id of an entry file to add it to a relatable
	private String mergeEntryFileId;



	/**
	 * will be called automatically right after the class is constructed since
	 * it has the PostConstruct annotation
	 */
	@PostConstruct
	public void init() {
		// at the beginning, set the entitiy name to be EntryFile
		this.ejbEntryFile.setEntityName("EntryFile");
	}



	/**
	 * to submit changes on the EntryFile object
	 * 
	 * @return "success" which is used for navigation engine to redirect to the
	 *         proper page
	 */
	public String submit() {

		// if new object it will add the object to DB,
		// otherwise, it will just update it in DB
		if (isNewEntity())
			ejbEntryFile.add(this.entryFile);
		else
			ejbEntryFile.save(this.entryFile);

		// return "success" for navigation engine
		return "success";
	}



	/**
	 * @return int random number in this range (100000000 to 999999999)
	 */
	private int getRandom() {
		return (int) (new Random(System.currentTimeMillis()).nextDouble() * 100000000);
	}



	/**
	 * should be synchronized since PrimeFaces creates multiple threads when
	 * upload multiple files
	 * 
	 * @param event
	 *            is passed by PrimeFaces, which contains the file data and
	 *            details.
	 * 
	 */
	public synchronized void handleFileUpload(FileUploadEvent event) {

		try {

			// file name must starts with random number then "_" then the file
			// name
			String randomFileName = getRandom() + "_" + event.getFile().getFileName();

			// special chars [~#@*+%{}<>\|"^' ] must be replaced with "_"
			randomFileName = randomFileName.replaceAll("[~#@*+%{}<>\\[\\]|\"\\^' ]", "_");

			// hold the absolute path in the disk
			String absoluteDiskPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");

			// a File object for the file will be placed in the full path
			// absoluteDiskPath + this
			File targetFolder = new File(absoluteDiskPath + this.path);

			// hold the file data in inputstream
			InputStream inputStream = event.getFile().getInputstream();

			// file output stream
			OutputStream out = new FileOutputStream(new File(targetFolder, randomFileName));

			// check if the file is an image
			if (isImage(randomFileName))
				this.entryFile = new Image();
			else
				this.entryFile = new EntryFile();

			// set absolute link in EntryFile object
			this.entryFile.setAbsoluteLink(absoluteDiskPath + this.path + "/" + randomFileName);

			// to count how many bytes read in buffer
			int read = 0;

			// byte buffer of size 1024
			byte[] bytes = new byte[1024];

			// read and write
			while ((read = inputStream.read(bytes)) != -1)
				out.write(bytes, 0, read);

			// clean up
			inputStream.close();
			out.flush();
			out.close();

			// add the entry file object to DB
			ejbEntryFile.add(this.entryFile);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	/**
	 * @param filename
	 *            through the file name extension, the function will decide
	 *            whether the file is an image or not
	 * @return true if it is an image, false otherwise
	 */
	private boolean isImage(String filename) {
		// pattern for these types jpg|png|gif|bmp
		Pattern p = Pattern.compile("([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)");
		Matcher m = p.matcher(filename);
		return m.matches();
	}



	/**
	 * to initiate new object of EntryFile. This function will be called from
	 * addEntryFile.xhtml page at preRenderView phase
	 */
	public void createNewEntryFile() {
		this.setNewEntity(true);
	}



	/**
	 * it will load the object from DB if it is not loaded yet otherwise, it
	 * will return the entryFile object
	 * 
	 * @return the entryFile object
	 */
	public EntryFile getEntryFile() {

		// if the object was loaded already, just return it
		if (this.entryFile != null)
			return this.entryFile;

		// if the id is null do not try to load it from DB, just return null
		if (this.id == null)
			return null;

		// at this point object must be null but id is not,
		// so load it from DB
		this.entryFile = ejbEntryFile.getEntity(Long.parseLong(this.id));

		return entryFile;
	}



	/**
	 * @param relatableID
	 *            which is needed to attach this file to this relatable
	 */
	public void addEntryFileToRelatable(Long relatableID) {
		Relatable r = this.ejbRelatable.getEntity(relatableID, "Relatable");
		EntryFile ef = this.ejbEntryFile.getEntity(Long.parseLong(this.mergeEntryFileId));

		ef.setRelatable(r);
		r.addEntryFile(ef);

		this.ejbEntryFile.save(ef);
	}



	/**
	 * 
	 * will check first if this file is attached to relatable or not
	 * 
	 * @param entryFileId
	 *            the id of the entry file need to be removed from DB
	 */
	public void removeEntryFile(Long entryFileId) {
		EntryFile ef = this.ejbEntryFile.getEntity(entryFileId);

		if (ef.getRelatable() == null)
			this.ejbEntryFile.remove(entryFileId);
		else
			removeEntryFile(entryFileId, ef.getRelatable().getId());
	}



	/**
	 * will remove entry file from relatable entryfiles list and will remove the
	 * entry file from DB
	 * 
	 * @param entryFileId
	 *            the id of the entry file need to be removed from DB
	 * 
	 * @param relatableID
	 *            the id of the relatable that file entry if attached to it
	 */
	private void removeEntryFile(Long entryFileId, Long relatableID) {
		Relatable r = this.ejbRelatable.getEntity(relatableID, "Relatable");
		r.removeEntryFile(entryFileId);

		this.ejbEntryFile.remove(entryFileId);
		this.ejbRelatable.save(r);
	}



	public void setEntryFile(EntryFile entryFile) {
		this.entryFile = entryFile;
	}



	public boolean isNewEntity() {
		return newEntity;
	}



	public void setNewEntity(boolean newEntity) {
		this.newEntity = newEntity;
	}



	public List<EntryFile> getEntryFilesList() {
		if (this.entryFilesList == null)
			this.entryFilesList = ejbEntryFile.getList();

		return entryFilesList;
	}



	public void setEntryFilesList(List<EntryFile> entryFilesList) {
		this.entryFilesList = entryFilesList;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getMergeEntryFileId() {
		return mergeEntryFileId;
	}



	public void setMergeEntryFileId(String mergeEntryFileId) {
		this.mergeEntryFileId = mergeEntryFileId;
	}

}
