package goodtime;

import java.io.IOException;



public class Launcher {
	public static void main(String[] args)
	{
		ConfigJson.load();
		Info.getverPath();
		Info.getLib();
		Info.ReadJson();
		//String jpath = "\""+Config.java+"\"";
		//String z = Config.java.substring(0, Config.java.indexOf(" ")-1);
		//String x = z+"\"";
		//System.out.println(x);
		//String jk = "C:\\Program\" \"Files\\Java\\jre1.8.0_25\\bin\\java.exe";
		String lb = Info.verp+"Natives";
		String classpath = Info.verp+Info.version+".jar";
		System.out.println("l="+Info.lib);
		String one = Info.mA.replace("${auth_player_name}", ConfigJson.username);
		String two = one.replace("${version_name}", Info.version);
		String three = two.replace("${game_directory}", ".\\.minecraft");
		String four = three.replace("${assets_root}", ".\\.minecraft/assets");
		String five = four.replace("${assets_index_name}", Info.ass);
		String six = five.replace("${auth_uuid}", "auth_uuid");
		String seven = six.replace("${auth_access_token}", "auth_access_token"); 
		String eight = seven.replace("${user_properties}", "{}");
		String ma = eight.replace("${user_type}", "legacy");
		String cmd = "java -Xmx"+ConfigJson.memory+"M "+"-Djava.library.path="+lb+" -classpath "+Info.libp+"\""+classpath+"\""+" "+Info.main+" "+ma ;
		System.out.println(cmd);
		System.out.println("java="+"");
		try {
				Runtime.getRuntime().exec(cmd);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
}


