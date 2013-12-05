package com.example.jsfdemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jsfdemo.domain.Sandwich;
import com.example.jsfdemo.service.SandwichManager;

@SessionScoped
@Named("sandwichBean")
public class SandwichFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Sandwich sandwich = new Sandwich();

	private ListDataModel<Sandwich> sandwiches = new ListDataModel<Sandwich>();

	@Inject
	private SandwichManager sm;

	public Sandwich getSandwich() {
		return sandwich;
	}

	public void setSandwich(Sandwich sandwich) {
		this.sandwich = sandwich;
	}

	public ListDataModel<Sandwich> getAllSandwiches() {
		sandwiches.setWrappedData(sm.getAllSandwiches());
		return sandwiches;
	}

	public String addSandwich() {
		sm.addSandwich(sandwich);
		return "showSandwiches";
	}

	public String deleteSandwich() {
		Sandwich sandwichToDelete = sandwiches.getRowData();
		sm.deleteSandwich(sandwichToDelete);
		return null;
	}
	
	public void uniqueId(FacesContext context, UIComponent component, Object value) {

     String id = (String) value;

     for (Sandwich sandwich : sm.getAllSandwiches()) 
     {
       if (sandwich.getId().equalsIgnoreCase(id)) 
       {
          FacesMessage message = new FacesMessage(
               "Sandwich with this ID already exists in database");
          message.setSeverity(FacesMessage.SEVERITY_ERROR);
          throw new ValidatorException(message);
       }
     }
    }
}
