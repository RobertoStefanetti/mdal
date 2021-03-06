package de.joneug.mdal.ide.server;

import org.eclipse.xtext.ide.server.LaunchArgs;
import org.eclipse.xtext.ide.server.ServerLauncher;
import org.eclipse.xtext.ide.server.ServerModule;

import com.google.inject.Guice;

import de.joneug.mdal.generator.GeneratorManagement;

public class MdalLanguageServerLauncher extends ServerLauncher {

	public static void main(String[] args) {
		launch(ServerLauncher.class.getName(), args, new ServerModule());
	}

	public static void launch(String prefix, String[] args, com.google.inject.Module... modules) {
		// Read symbol references
		(new Thread() {
			public void run() {
				GeneratorManagement.getInstance().readSymbolReferences();
			}
		}).start();
		
		// Launch server
		LaunchArgs launchArgs = createLaunchArgs(prefix, args);
		ServerLauncher launcher = Guice.createInjector(modules).<ServerLauncher>getInstance(ServerLauncher.class);
		launcher.start(launchArgs);
	}

	public static LaunchArgs createLaunchArgs(String prefix, String[] args) {
		LaunchArgs launchArgs = new LaunchArgs();
		launchArgs.setIn(System.in);
		launchArgs.setOut(System.out);
		redirectStandardStreams(prefix, args);
		launchArgs.setTrace(getTrace(args));
		launchArgs.setValidate(shouldValidate(args));
		return launchArgs;
	}

	public static void redirectStandardStreams(String prefix, String[] args) {
		if (shouldLogStandardStreams(args)) {
			// Redirect to standard error to show logging in VS Code Output
			redirectStandardStreams(System.err);
		} else {
			silentStandardStreams();
		}
	}

}
