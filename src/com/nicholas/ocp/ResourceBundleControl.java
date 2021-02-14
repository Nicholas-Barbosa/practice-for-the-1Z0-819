package com.nicholas.ocp;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.ResourceBundle.Control;
import java.util.concurrent.CopyOnWriteArrayList;

public class ResourceBundleControl extends Control {

	public static void main(String[] args) {

		ResourceBundle resource = ResourceBundle.getBundle("Zoo", Locale.ITALY, new ResourceBundleControl());
		System.out.println(resource.getString("hello"));
	}

	@Override
	public List<Locale> getCandidateLocales(String baseName, Locale locale) {
		// TODO Auto-generated method stub
		System.out.println(locale);
		List<Locale> locales = super.getCandidateLocales(baseName, locale).parallelStream().filter(l -> {
			System.out.println("candidates " + l);
			return l.getDisplayLanguage().equals(locale.getDisplayLanguage()) || l.getDisplayLanguage().isBlank();
		}).collect(CopyOnWriteArrayList::new, List::add, List::addAll);
		return locales;
	}

}
