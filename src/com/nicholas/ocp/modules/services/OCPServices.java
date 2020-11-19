package com.nicholas.ocp.modules.services;

import java.util.ServiceLoader;

public class OCPServices {

	interface ServiceProviderInterface {
		/*
		 * Service provider interface,pois fornece o comportamento que nosso servico
		 * tera.
		 * 
		 * module-info.java
		 * 
		 * exports ....ServiceProviderInterface
		 */

		String take();
	}

	static class ServiceLocator {
		/*
		 * Esta classe, nos permite pesquisar todas as classes que implementam nossa
		 * service provider interface.
		 * 
		 * O java nos ajuda com isso, fornecendo o load() da classe ServiceLoader.
		 * 
		 * requires module.serviceproviderinterface
		 * 
		 * uses module.service.provider.serviceproviderinterface.service
		 */

		public ServiceProviderInterface lookUp() {
			ServiceLoader<ServiceProviderInterface> all = ServiceLoader.load(ServiceProviderInterface.class);
			for (ServiceProviderInterface s : all) {
				return s;
			}
			return null;
		}
	}

	static class Consumer {
		/*
		 * Classe consumer ou client, refere-se a um modulo que obtem e usa um servico.
		 * 
		 * module-info.java
		 * 
		 * requires transitive module.service.locator
		 * 
		 * 
		 */

		ServiceProviderInterface find() {
			ServiceLocator sl = new ServiceLocator();
			return sl.lookUp();
		}
	}

	static class ServiceProvider implements ServiceProviderInterface {

		@Override
		public String take() {
			// TODO Auto-generated method stub
			return null;
		}
		/*
		 * Service provider, fornece uma implementacao para o serivce provider
		 * interface.
		 * 
		 * Podendo haver um service provider por service provider interface.
		 * 
		 * no module-info.java, usamos provides interfaceName with className.
		 * 
		 * Isto diz que estamos fornecendo um service provider para um service provider
		 * interface, ou seja, estamos fornecendo implementacao de uma interface numa
		 * classe especifica
		 */
	}

	public static void main(String[] args) {
	
	}

}
