/**
* Commit Command class, which basically creates a new version to be worked on while backing up all existing data to a backup directory
*/
public class Commit extends ListFiles {
  /**
    * Creates a new Commit Command
    @param vcs current version control system, sets to be the vcs of the parent class
    */
  public Commit(VCS vcs){
      super(vcs);
  }
  /**
   *  Performs the 'commit' command as described in the task. Backs up all existing data
   */
  public void execute(){
    System.out.println("Comitted the following files:");
    super.execute();
    
    VCS vcs = super.getVCS();
    String backup_dir = vcs.getBackupDir();

    backup_dir = Util.appendFileOrDirname(backup_dir, Util.getTimestamp());

    Util.mkdir(backup_dir);

    String[] filesInBackupDir = Util.listFiles(vcs.getBackupDir());

    for(String file : filesInBackupDir){
      Util.moveFile(Util.appendFileOrDirname(vcs.getBackupDir(), file),
        Util.appendFileOrDirname(backup_dir, file));
    }

    String[] filesInRootDir = Util.listFiles(vcs.getRootDir());

    for(String file : filesInRootDir){
      Util.copyFile(Util.appendFileOrDirname(vcs.getRootDir(), file), Util.appendFileOrDirname(vcs.getBackupDir(), file));
    }

  }
}
