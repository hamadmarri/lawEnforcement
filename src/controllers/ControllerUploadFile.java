package controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;

import ejbs.AbstractEjb;
import entities.entries.files.EntryFile;


/**
 * 
 * @author hamadalmarri
 */
@ManagedBean(name = "controllerUploadFile")
@SessionScoped
public class ControllerUploadFile implements Serializable {

	private static final long serialVersionUID = -1093413444855839377L;

	@EJB
	private AbstractEjb<EntryFile> ejbEntryFile;

	private String path = "upload";
	private EntryFile entryFile = new EntryFile();
	private boolean newEntity = true;



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



	private static int getRandom() {
		return (int) (new Random(System.currentTimeMillis()).nextDouble() * 100000000);
	}



	public void handleFileUpload(FileUploadEvent event) {

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

			submit();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	public EntryFile getEntryFile() {
		return entryFile;
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

}
