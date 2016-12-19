public class ListFiles extends Command {
  public ListFiles(VCS vcs){
      super(vcs);
  }
  public void execute(){
    String[] files = Util.listFiles(super.getVCS().getRootDir());
    for(String file : files){
        System.out.println(file);
    }
  }
}
