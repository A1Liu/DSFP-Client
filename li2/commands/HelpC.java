package commands;

import java.util.Arrays;
import java.util.List;

/**
 * This class represents a command that outputs a guide to a command tree.
 * @author aliu
 *
 */
final class HelpC implements Command {
	
	private CommandList commands;
	private ComTreeNode root;
	private String output;
	private List<ComTreeNode> subCommands;
	
	HelpC ( CommandList commands, ComTreeNode root ) {
		this.root = root;
		this.commands = commands;
	}
	
	@Override
	public Object execute(String...elist) {
		output = "";
		subCommands = null;
		execute((Object[]) elist);
		return output;
	}
	
	@Override
	public void execute(Object... elist) {//Need to account for null... Maybe by having the constructor add in the help commands after the fact? Yes. Adding to all the null branches as well, with prepended null entries.
		
		String[] path = (String[]) elist;
		getInformation(getNode(path));
	}
	
	private ComTreeNode getNode(String[] in) {
		return getNode(root, in);
	}
	
	private ComTreeNode getNode(ComTreeNode root, String[] in) {
		ComTreeNode current = root;
		for (int x = 0; x < in.length; x++) {
			String element = in[x];
			if (current.containsChild(element)) {//go to the next child
				current = current.getChild(element);
			} else if (element.equals("...")) {
				subCommands = current.getChildren();
				return current;
			} else if (element.endsWith("...") && current.containsChild(element.replace("...", ""))) {
				current = current.getChild(element.replace("...", ""));
				subCommands = current.getChildren();
				return current;
			} else if (current.getID() != null && commands.get(current.getID()) != null && ( commands.get(current.getID()) instanceof SkipC ) ) {
				return getNode( ( (SkipC) commands.get(current.getID()) ).getLocation(), Arrays.copyOfRange(in, x, in.length) );
			} else {
				if (current == this.root) {
					output+=String.format("NOTE: '%s' is not a valid command. For a list of valid commands and their explanations, type 'help'.%n",element);
				} else {
					output+=String.format("NOTE: '%s' is not a valid subcommand of '%s'.%n",element,current.getName());
				}
				
				return current;
			}
		} return current;
	}
	
	private void getInformation(ComTreeNode current) {
		if (current == root) {//If there were no parameters given
			output+="Command List:\n";
			for (ComTreeNode node : current.getChildren()) {
				if (node.getName() != null) {
					String name = node.getName();
					String help = node.getHelp() == null ? "'" + node.getName() + "' command." : node.getHelp();
					output+=String.format("  %8s %s%n",name+":",help);
				}
			}
		} else if (subCommands == null) {//if the parameters were given but the user didn't ask for subcommands.
			String name = current.getName();
			String help = current.getHelp() == null ? "'" + current.getName() + "' command." : current.getHelp();
			output+=String.format("%s %s%n",name+":",help);
			output+=String.format("Type '...' at the end of the last command to get a list of available subcommands, along with help for each.%n");
		} else {//if the parameters were given with a '...' at the end, which means that subcommands should also be outputted
			if (subCommands.size() == 0) {//No subcommands
				output+=String.format("'%s' doesn't have any subcommands.",current.getName());
			}
			
			output+=String.format("Subcommands of'%s': %n",current.getName());
			for (ComTreeNode node : subCommands) {
				String name = node.getName();
				String help = node.getHelp() == null ? "'" + node.getName() + "' command." : node.getHelp();
				output+=String.format("  %8s %s%n",name+":",help);
			}
		}
	}

}
