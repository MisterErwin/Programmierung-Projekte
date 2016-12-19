/**
* Command class, parent class of all commands, differentiates between given commands by the user an reacts as supposed to
*/
public class Command {
    protected VCS vcs;
    /**
     *  Constructor for a Command
     *  @param vcs expects an instance of a version control system to be given to operate on
     */
    public Command(VCS vcs){
      this.vcs = vcs;
    }
    public void execute() {
        // override me!
    }
    /**
     * Returns the current version control to make it available to the subclasses
     * @return the current Version Control System Object bound to this command instance
     */
    public VCS getVCS(){
        return this.vcs;
    }
    /**
     * Parses the entered command and returns an instance of the given command type to execute more specific operations
     * @param cmdName String containing the commmand to be executed
     * @param vcs version control system to be operated on
     * @return an instance of a specific command, or, in case of unknown command, null
     */
    public static Command parse(String cmdName, VCS vcs) {
        switch(cmdName){
          case "exit" : return new Exit(vcs);
          case "listFiles" : return new ListFiles(vcs);
          case "commit" : return new Commit(vcs);
          default : System.out.println("Command not recognised. Please try again!"); return null;
        }
    }
}
