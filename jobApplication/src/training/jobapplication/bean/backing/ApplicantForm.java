package training.jobapplication.bean.backing;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpSession;

import training.jobapplication.bean.model.Applicant;
import training.jobapplication.bean.support.ProvinceSupport;

public class ApplicantForm {
	private Applicant applicant;
	private ProvinceSupport provinceSupport;
	private boolean resumeRendered = false;
	private String lastName;
	private String userName = "test...";
	private HttpSession httpSession;
	private String chartJson;
	
	public ApplicantForm(){
		httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		chartJson = (String) httpSession.getAttribute("chartJson");
		System.out.println("chartJson:  " + chartJson);
	}

	/**
	 * Receives an instance of the Applicant model bean via dependency injection
	 */
	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}
	
	public ProvinceSupport getProvinceSupport() {
		return provinceSupport;
	}

	public void setProvinceSupport(ProvinceSupport provinceSupport) {
		this.provinceSupport = provinceSupport;
	}

	public boolean isResumeRendered() {
		return resumeRendered;
	}

	public void setResumeRendered(boolean resumeRendered) {
		this.resumeRendered = resumeRendered;
	}
	
	public void toggleResume(ActionEvent actionEvent) {
		this.resumeRendered = !this.resumeRendered;
	}
	
	public void lastNameChange(ValueChangeEvent e){
		System.out.println("211111111111111");
//		this.lastName = "Tian";
	}

	public String submit() {
		if (this.applicant.getFirstName().equals("John")) {
			if (this.applicant.getLastName().equals("Doe")) {
				String msg = "John Doe already works for us";
				FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
				FacesContext facesContext = FacesContext.getCurrentInstance();
				String clientId = null; // this is a global message
				facesContext.addMessage(clientId, facesMessage);
				return "retry";
			}
			
			return "success";
		}
		else {
			return "failure";
		}
	}

	public Applicant getApplicant() {
		return applicant;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
