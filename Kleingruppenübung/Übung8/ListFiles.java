/**
* ListFiles Command Class, listing all the current files in the working directory to the users console
*/
public class ListFiles extends Command {
  /**
  * Creates a new ListFiles Command
  * @param vcs current version control system, sets to be the vcs of the parent class
  */
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
