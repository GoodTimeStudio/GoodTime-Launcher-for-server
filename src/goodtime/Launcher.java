package goodtime;

import java.io.IOException;



public class Launcher {
	public static void main(String[] args) {
			try {
				Runtime.getRuntime().exec("cmd java.exe .....");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


