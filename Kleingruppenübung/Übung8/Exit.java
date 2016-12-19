public class Exit extends Command {
  public Exit(VCS vcs){
      super(vcs);
  }
  public void execute(){
    Util.exit();
  }
}
