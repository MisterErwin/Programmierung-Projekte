/**
* Exit Command class, which kills the currently running vcs
*/
public class Exit extends Command {
  /**
    * Creates a new Commit Command
    @param vcs current version control system, sets to be the vcs of the parent class
    */
  public Exit(VCS vcs){
      super(vcs);
  }
  public void execute(){
    Util.exit();
  }
}
