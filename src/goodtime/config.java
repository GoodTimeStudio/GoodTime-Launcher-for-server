package goodtime;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;

public class config
{
  static ArrayList lvalue;
  static ArrayList rvalue;
  static File CfgFile;
  static Properties p = new Properties();
  
  
  public static String assVersion = "";
  public static String GameDir = "";
  public static String tpf = "";
  public static String JavaPath = "";
  public static ArrayList unzipAbledLibs;
  public static ArrayList NotFoundedLibs;
  public static String UserName = "";
  public static String memory = "";
  public static String Rundir = "";
  public static String token = "";
  public static String downUrl = "";
  public static boolean Downok = false;
  public static String twitchToken = "";
  public static String uuid = "";
  
  
  public static void Load(File ConfigFile)
    throws FileNotFoundException, IOException
  {
    lvalue = new ArrayList();
    rvalue = new ArrayList();
    



    CfgFile = ConfigFile;
    



    p.load(new FileReader(ConfigFile));
    System.out.println(ConfigFile);
    Object[] o = p.stringPropertyNames().toArray();
    for (Object o1 : o) {
      lvalue.add(o1.toString());
    }
    for (int i = 0; i < p.size(); i++) {
      rvalue.add(p.get(lvalue.get(i)));
    }
  }
  
  public static String getConfig(String key)
  {
    if ((!lvalue.contains(key)) && 
      (key.equals("GameDir"))) {
      setConfig(key,GameDir);
    }
    return rvalue.get(lvalue.indexOf(key)).toString();
  }
  
  public static void setConfig(String key, String value)
  {
    if (!lvalue.contains(key))
    {
      rvalue.add(value);
      lvalue.add(key);
      p.setProperty(key, value);
    }
    else
    {
      rvalue.set(lvalue.indexOf(key), value);
      p.setProperty(key, value);
    }
  }
  
  public static void Save()
  {
    try
    {
      p.store(new FileWriter(CfgFile), "//GoodTime Launcher Config\r\n//GoodTimeÆô¶¯Æ÷ÅäÖÃÎÄ¼þ");
    }
    catch (IOException ie) {}
  }
}
