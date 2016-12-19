public class Commit extends ListFiles {
  public Commit(VCS vcs){
      super(vcs);
  }
  public void execute(){
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
      Util.copyFile(Util.appendFileOrDirname(vcs.getRootDir(), file),
        Util.appendFileOrDirname(vcs.getBackupDir(), file)));
    }
    System.out.println("Comitted the following files:");
    super.execute();
  }
}
