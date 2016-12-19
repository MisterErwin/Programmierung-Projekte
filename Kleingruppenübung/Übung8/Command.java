public class Command {
    private VCS vcs;

    public Command(VCS vcs){
      this.vcs = vcs;
    }
    public void execute() {
        // override me!
    }
    public VCS getVCS(){
        return this.vcs;
    }
    public static Command parse(String cmdName, VCS vcs) {
        switch(cmdName){
          case 'exit' : return new Exit(this.vcs);
          case 'listFiles' : return new ListFiles(this.vcs);
          case 'commit' : return new Commit(this.vcs);
          default : System.out.println("Command not recognised. Please try again!"); return null;
        }
    }
}
