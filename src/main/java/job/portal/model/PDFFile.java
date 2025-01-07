package job.portal.model;


import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class PDFFile {
    private CommonsMultipartFile file;

	public CommonsMultipartFile getFile() {
		return file;
	}

	public void setFile(CommonsMultipartFile file) {
		this.file = file;
	}

	public PDFFile() {
		super();
		// TODO Auto-generated constructor stub
	}

	
    
}

