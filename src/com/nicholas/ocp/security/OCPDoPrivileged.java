package com.nicholas.ocp.security;

import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.Permission;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;

public class OCPDoPrivileged {

	/*
	 * Alguns programas executam em um ambiente onde o usuario nao tem o controle
	 * total sobre o programa. Em outras palavras, o programa executa acoes
	 * privilegiadas em nome do usuario. Para o desenvolvedor a ideia e a seguinte
	 * 
	 * 1->Tenho uma acao privilegiada e preciso executar para um usuario
	 * 
	 * 2->Preciso garantir que o usuario tenha as devidas permissoes antes de
	 * executar a acao.
	 * 
	 * 3->Preciso ter certeza de que o usuario executara as acoes limitadas a ele.
	 * 
	 * 4->Preciso ter certeza de que nao ha nenhum cache ou outra ferramenta para
	 * quebra da verificacao de permissao.
	 * 
	 * para executar acoes privilegiadas, usamos a classe
	 * AccesControl.doPrivileged() encotrada no pacote java.security.
	 * 
	 * Cache, nao ha problemas em cachear as permissoes, mas devemos verifica-las
	 * toda vez que o usuario acessa.
	 */
	private static final String KEY = "secret.option";

	public static void main(String[] args) {
		System.out.println(new OCPDoPrivileged().getSecret());
	}

	private String getSecret() {
		/*
		 * Observe,usamos uma constante que nao pode ser modificada pelo usuario. Usamos
		 * o principio de least privilege, onde concedemos minimos acessos para o
		 * usuario. Nao poderiamos por exemplo, pegar como parametro a key de uma
		 * propriedade ja especifica no sistema e mostrar ao usuario, pois com essa
		 * abordagem o usuario teria acesso a tudo que esta no sistema. Ma pratica fazer
		 * isto.Nao confie em nada que vem do usuario ao lidar com seguranca.
		 * 
		 * Se retornassemos uma list, nao iriamos devolver a list crua mas uma copia
		 * dela ou a mesma list mas imutavel.
		 * 
		 * 
		 */
		return AccessController.doPrivileged(new PrivilegedAction<String>() {
			public String run() {
				return System.getProperty(KEY);
			}
		});
	}

	public void readData(Runnable task, String path) throws Exception {
		/*
		 * Elevacao de permissao, ocorre quando e concedido sem querer permissoes mais
		 * altas do que deveria. Uma forma de previnir isso, e usar checkPermission().
		 */
		// Check permission
		Permission permission = new java.io.FilePermission(path, "read");
		AccessController.checkPermission(permission);

		// Execute task with limited permission
		final var permissions = permission.newPermissionCollection();
		permissions.add(permission);
		AccessController.doPrivileged(new PrivilegedAction<Void>() {
			public Void run() {
				task.run();
				return null;
			}
		},
				// Using a limited context prevents privilege elevation
				new AccessControlContext(new ProtectionDomain[] { new ProtectionDomain(null, permissions) }));
	}

}
