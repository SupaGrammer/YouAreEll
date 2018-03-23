import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import sun.tools.java.Identifier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * ============JACKSON============ vs ==============GSON==============
 * @JACKSON
 * Consistent multipurpose library for processing JSON formatted data
 * Not as simple as Gson(my baby)
 * Fast and ergonomic
 * Reads and writes JSON as discrete events
 * Provides a mutable internal memory tree interpretation of JSON data
 * Converts JSON to and from POJO's
 * @GSON
 * Does the same as jackson minus the need for replacing java annotations within classes
 * Simple method calls
 * Supports complex objects
 * Long range support of java generics
 * Allows custom representation for objects
 * Allows pre-existing static objects can be converted
 * Its just better bruh
 */

public class SimpleShell {

    public static void prettyPrint(String output) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Object jsonFormat = objectMapper.readValue(output, Object.class);
            String formatted = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonFormat);
            System.out.println(formatted);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(output);
    }

    public static void main(String[] args) throws java.io.IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        YouAreEll url = new YouAreEll();
        String commandLine;
        BufferedReader console = new BufferedReader
                (new InputStreamReader(System.in));

        ProcessBuilder pb = new ProcessBuilder();
        List<String> commandHistory = new ArrayList<String>();
        int index = 0;
        //we break out with <ctrl c>
        while (true) {
            //read what the user enters
            System.out.println("cmd? ");
            commandLine = console.readLine();

            //input parsed into array of strings(command and arguments)
            String[] commandWords = commandLine.split(" ");
            List<String> commandList = new ArrayList<String>();

            //if the user entered a return, just loop again
            if (commandLine.equals(""))
                continue;
            if (commandLine.equals("exit")) {
                System.out.println("bye!");
                break;
            }

            //loop through to see if parsing worked
            for (int i = 0; i < commandWords.length; i++) {
                //System.out.println(commands[i]); //***check to see if parsing/split worked***
                commandList.add(commandWords[i]);
            }
            System.out.print(commandList); //***check to see if list was added correctly***
            commandHistory.addAll(commandList);
            try {
                //display history of shell with index
                if (commandList.get(commandList.size() - 1).equals("history")) {
                    for (String s : commandHistory)
                        System.out.println((index++) + " " + s);
                    continue;
                }
                //Specific commands

                // ids
                if (commandList.contains("ids")) {
                    String results = url.get_ids();
                    SimpleShell.prettyPrint(results);
                    continue;
                }

                // messages
                if (commandList.contains("messages")) {
                    String results = url.get_messages();
                    SimpleShell.prettyPrint(results);
                    continue;
                }
                // you need to add a bunch more.

                //!! command returns the last command in history
                if (commandList.get(commandList.size() - 1).equals("!!")) {
                    pb.command(commandHistory.get(commandHistory.size() - 2));

                }//!<integer value i> command
                else if (commandList.get(commandList.size() - 1).charAt(0) == '!') {
                    int b = Character.getNumericValue(commandList.get(commandList.size() - 1).charAt(1));
                    if (b <= commandHistory.size())//check if integer entered isn't bigger than history size
                        pb.command(commandHistory.get(b));
                } else {
                    pb.command(commandList);
                }

                // wait, wait, what curiousness is this?
                Process process = pb.start();

                //obtain the input stream
                InputStream is = process.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);

                //read output of the process
                String line;
                while ((line = br.readLine()) != null)
                    System.out.println(line);
                br.close();
            }

            //catch ioexception, output appropriate message, resume waiting for input
            catch (IOException e) {
                System.out.println("Input Error, Please try again!");
            }
            // So what, do you suppose, is the meaning of this comment?
            /**@TODO
             * The steps are:
             * 1. parse the input to obtain the command and any parameters
             * 2. create a ProcessBuilder object
             * 3. start the process
             * 4. obtain the output stream
             * 5. output the contents returned by the command
             */

        }
    }
}