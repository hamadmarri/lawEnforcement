package controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;

import ejbs.AbstractEjb;
import entities.Relatable;
import entities.entries.files.EntryFile;


/**
 * 
 * @author hamadalmarri
 */
@ManagedBean(name = "controllerEntryFile")
@ViewScoped
public class ControllerEntryFile implements Serializable {

	private static final long serialVersionUID = -1093413444855839377L;

	@EJB
	private AbstractEjb<EntryFile> ejbEntryFile;

	@EJB
	private AbstractEjb<Relatable> ejbRelatable;

	private String id;
	private String path = "upload";
	private EntryFile entryFile = null;
	private boolean newEntity = false;
	private List<EntryFile> entryFilesList = null;
	private String mergeEntryFileId;



	@PostConstruct
	public void init() {
		this.ejbEntryFile.setEntityName("EntryFile");
	}



	public String submit() {

		if (isNewEntity())
			ejbEntryFile.add(this.entryFile);
		else
			ejbEntryFile.save(this.entryFile);
		return "success";
	}



	private int getRandom() {
		return (int) (new Random(System.currentTimeMillis()).nextDouble() * 100000000);
	}



	public synchronized void handleFileUpload(FileUploadEvent event) {

		// System.out.println("******* handleFileUpload *********");

		try {
			String randomFileName = getRandom() + "_" + event.getFile().getFileName();
			String absoluteDiskPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
			File targetFolder = new File(absoluteDiskPath + this.path);
			InputStream inputStream = event.getFile().getInputstream();
			OutputStream out = new FileOutputStream(new File(targetFolder, randomFileName));
			this.entryFile.setAbsoluteLink(absoluteDiskPath + this.path + "/" + randomFileName);

			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = inputStream.read(bytes)) != -1)
				out.write(bytes, 0, read);

			inputStream.close();
			out.flush();
			out.close();

			ejbEntryFile.add(this.entryFile);
			// System.out.println("******* added *********");
			this.entryFile = new EntryFile();
			// System.out.println("******* new *********");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	public void createNewEntryFile() {
		this.entryFile = new EntryFile();
		this.setNewEntity(true);
	}



	public EntryFile getEntryFile() {

		if (this.entryFile != null)
			return this.entryFile;

		if (this.id == null)
			return null;

		this.entryFile = ejbEntryFile.getEntity(Long.parseLong(this.id));

		return entryFile;
	}



	public void addEntryFileToRelatable(Long relatableID) {
		Relatable r = this.ejbRelatable.getEntity(relatableID, "Relatable");
		EntryFile ef = this.ejbEntryFile.getEntity(Long.parseLong(this.mergeEntryFileId));

		ef.setRelatable(r);
		r.addEntryFile(ef);

		this.ejbEntryFile.save(ef);
	}



	public void removeEntryFile(Long entryFileId) {
		this.ejbEntryFile.remove(entryFileId);
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
