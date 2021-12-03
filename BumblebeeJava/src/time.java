import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

import com.ibm.icu.util.Calendar;

public class time extends commandClass implements commandInterface {
	ArrayList<String> commandPhrases = new ArrayList<String>();
	
	public time() {
    	commandPhrases.add("time");
    }
		
    public boolean match(String word){
        return commandPhrases.contains(word);
    }
    
    public String run(String[] input) {
        DateFormat df = new SimpleDateFormat("hh:mm a");
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        
        for(int i=0; i<input.length; i++){
            if(input[i].equals("greenwich")){
                if (input[i+1].equals("mean")) {
                    df.setTimeZone(TimeZone.getTimeZone("GMT"));
                    String zone = df.format(today);
                    return ("the " + input[i] + " " + input[i+1] + " " + "time is " + zone);
                }
            }
            if(input[i].equals("universal")){
                if (input[i+1].equals("coordinated")) {
                    df.setTimeZone(TimeZone.getTimeZone("UTC"));
                    String zone = df.format(today);
                    return ("the " + input[i] + " " + input[i+1] + " " + "time is " + zone);
                }
            }
            if(input[i].equals("european")){
                if (input[i+1].equals("central")) {
                    df.setTimeZone(TimeZone.getTimeZone("ECT"));
                    String zone = df.format(today);
                    return ("the " + input[i] + " " + input[i+1] + " " + "time is " + zone);
                }
            }
            if(input[i].equals("eastern")){
                if (input[i+1].equals("european")) {
                    df.setTimeZone(TimeZone.getTimeZone("EET"));
                    String zone = df.format(today);
                    return ("the " + input[i] + " " + input[i+1] + " " + "time is " + zone);
                }
                else if (input[i+1].equals("african")) {
                    df.setTimeZone(TimeZone.getTimeZone("EAT"));
                    String zone = df.format(today);
                    return ("the " + input[i] + " " + input[i+1] + " " + "time is " + zone);
                }
                else if (input[i+1].equals("standard")) {
                    df.setTimeZone(TimeZone.getTimeZone("EST"));
                    String zone = df.format(today);
                    return ("the " + input[i] + " " + input[i+1] + " " + "time is " + zone);
                }
            }
            if(input[i].equals("egypt")){
                if (input[i+1].equals("standard")) {
                    df.setTimeZone(TimeZone.getTimeZone("ART"));
                    String zone = df.format(today);
                    return ("the " + input[i] + " " + input[i+1] + " " + "time is " + zone);
                }
            }
            if(input[i].equals("middle")){
                if (input[i+1].equals("east")) {
                    df.setTimeZone(TimeZone.getTimeZone("MET"));
                    String zone = df.format(today);
                    return ("the " + input[i] + " " + input[i+1] + " " + "time is " + zone);
                }
            }
            if(input[i].equals("near")){
                if (input[i+1].equals("east")) {
                    df.setTimeZone(TimeZone.getTimeZone("NET"));
                    String zone = df.format(today);
                    return ("the " + input[i] + " " + input[i+1] + " " + "time is " + zone);
                }
            }
            if(input[i].equals("pakistan")){
                if (input[i+1].equals("lahore")) {
                    df.setTimeZone(TimeZone.getTimeZone("PLT"));
                    String zone = df.format(today);
                    return ("the " + input[i] + " " + input[i+1] + " " + "time is " + zone);
                }
            }
            if(input[i].equals("india")){
                if (input[i+1].equals("standard")) {
                    df.setTimeZone(TimeZone.getTimeZone("IST"));
                    String zone = df.format(today);
                    return ("the " + input[i] + " " + input[i+1] + " " + "time is " + zone);
                }
            }
            if(input[i].equals("bangladesh")){
                if (input[i+1].equals("standard")) {
                    df.setTimeZone(TimeZone.getTimeZone("BST"));
                    String zone = df.format(today);
                    return ("the " + input[i] + " " + input[i+1] + " " + "time is " + zone);
                }
            }
            if(input[i].equals("vietnam")){
                if (input[i+1].equals("standard")) {
                    df.setTimeZone(TimeZone.getTimeZone("VST"));
                    String zone = df.format(today);
                    return ("the " + input[i] + " " + input[i+1] + " " + "time is " + zone);
                }
            }
            if(input[i].equals("china")){
                if (input[i+1].equals("taiwan")) {
                    df.setTimeZone(TimeZone.getTimeZone("CTT"));
                    String zone = df.format(today);
                    return ("the " + input[i] + " " + input[i+1] + " " + "time is " + zone);
                }
            }
            if(input[i].equals("japan")){
                if (input[i+1].equals("standard")) {
                    df.setTimeZone(TimeZone.getTimeZone("JST"));
                    String zone = df.format(today);
                    return ("the " + input[i] + " " + input[i+1] + " " + "time is " + zone);
                }
            }
            if(input[i].equals("australia")){
                if (input[i+1].equals("central")) {
                    df.setTimeZone(TimeZone.getTimeZone("ACT"));
                    String zone = df.format(today);
                    return ("the " + input[i] + " " + input[i+1] + " " + "time is " + zone);
                }
                else if (input[i+1].equals("eastern")) {
                    df.setTimeZone(TimeZone.getTimeZone("AET"));
                    String zone = df.format(today);
                    return ("the " + input[i] + " " + input[i+1] + " " + "time is " + zone);
                }
            }
            if(input[i].equals("solomon")){
                if (input[i+1].equals("standard")) {
                    df.setTimeZone(TimeZone.getTimeZone("SST"));
                    String zone = df.format(today);
                    return ("the " + input[i] + " " + input[i+1] + " " + "time is " + zone);
                }
            }
            if(input[i].equals("new")){
                if (input[i+1].equals("zealand")) {
                    if(input[i+2].equals("standard")){
                        df.setTimeZone(TimeZone.getTimeZone("NST"));
                        String zone = df.format(today);
                        return ("the " + input[i] + " " + input[i+1] + " " + input[i+3] + " " + "time is " + zone);
                    }
                }
            }
            if(input[i].equals("midway")){
                if (input[i+1].equals("islands")) {
                    df.setTimeZone(TimeZone.getTimeZone("MIT"));
                    String zone = df.format(today);
                    return ("the " + input[i] + " " + input[i+1] + " " + "time is " + zone);
                }
            }
            if(input[i].equals("hawaii")){
                if (input[i+1].equals("standard")) {
                    df.setTimeZone(TimeZone.getTimeZone("HST"));
                    String zone = df.format(today);
                    return ("the " + input[i] + " " + input[i+1] + " " + "time is " + zone);
                }
            }
            if(input[i].equals("alaska")){
                if (input[i+1].equals("standard")) {
                    df.setTimeZone(TimeZone.getTimeZone("AST"));
                    String zone = df.format(today);
                    return ("the " + input[i] + " " + input[i+1] + " " + "time is " + zone);
                }
            }
            if(input[i].equals("pacific")){
                if (input[i+1].equals("standard")) {
                    df.setTimeZone(TimeZone.getTimeZone("PST"));
                    String zone = df.format(today);
                    return ("the " + input[i] + " " + input[i+1] + " " + "time is " + zone);
                }
            }
            if(input[i].equals("phoenix")){
                if (input[i+1].equals("standard")) {
                    df.setTimeZone(TimeZone.getTimeZone("PNT"));
                    String zone = df.format(today);
                    return ("the " + input[i] + " " + input[i+1] + " " + "time is " + zone);
                }
            }
            if(input[i].equals("mountain")){
                if (input[i+1].equals("standard")) {
                    df.setTimeZone(TimeZone.getTimeZone("MST"));
                    String zone = df.format(today);
                    return ("the " + input[i] + " " + input[i+1] + " " + "time is " + zone);
                }
            }
            if(input[i].equals("central")){
                if (input[i+1].equals("standard")) {
                    df.setTimeZone(TimeZone.getTimeZone("CST"));
                    String zone = df.format(today);
                    return ("the " + input[i] + " " + input[i+1] + " " + "time is " + zone);
                }
                else if (input[i+1].equals("african")) {
                    df.setTimeZone(TimeZone.getTimeZone("CAT"));
                    String zone = df.format(today);
                    return ("the " + input[i] + " " + input[i+1] + " " + "time is " + zone);
                }
            }
            if(input[i].equals("indiana")){
                if (input[i+1].equals("eastern")) {
                    if(input[i+2].equals("standard")){
                        df.setTimeZone(TimeZone.getTimeZone("IET"));
                        String zone = df.format(today);
                        return ("the " + input[i] + " " + input[i+1] + " " + input[i+3] + " " + "time is " + zone);
                    }
                }
            }
            if(input[i].equals("puerto") || input[i].equals("virgin")){
                if (input[i+1].equals("rico") || input[i+1].equals("islands")) {
                    df.setTimeZone(TimeZone.getTimeZone("PRT"));
                    String zone = df.format(today);
                    return ("the " + input[i] + " " + input[i+1] + " " + "time is " + zone);
                }
            }
            if(input[i].equals("canada")){
                if (input[i+1].equals("newfoundland")) {
                    df.setTimeZone(TimeZone.getTimeZone("CNT"));
                    String zone = df.format(today);
                    return ("the " + input[i] + " " + input[i+1] + " " + "time is " + zone);
                }
            }
            if(input[i].equals("argentina")){
                if (input[i+1].equals("standard")) {
                    df.setTimeZone(TimeZone.getTimeZone("AGT"));
                    String zone = df.format(today);
                    return ("the " + input[i] + " " + input[i+1] + " " + "time is " + zone);
                }
            }
            if(input[i].equals("brazil")){
                if (input[i+1].equals("eastern")) {
                    df.setTimeZone(TimeZone.getTimeZone("BET"));
                    String zone = df.format(today);
                    return ("the " + input[i] + " " + input[i+1] + " " + "time is " + zone);
                }
            }
            if(input[i].equals("minutes") || input[i].equals("minute")){
                StringToMath.clear();
                String t, minOffset;
                int start = 0;
                for(int k = 0; k < input.length; k++){
                    if(input[k].equals("in")) {
                        start = k;
                        break;
                    }
                }
                minOffset = StringToMath.convert(String.join(" ", Arrays.copyOfRange(input, ++start, input.length-1)));
                int minutes = Integer.parseInt(minOffset);
                cal.add(Calendar.MINUTE, minutes);
                String newTime = df.format(cal.getTime());
                StringToMath.clear();
                return ("the time in " + minOffset + " hours will be " + newTime);
            }
            if(input[i].equals("hours") || input[i].equals("hour")){
                StringToMath.clear();
                String t, hourOffset;
                int start = 0;
                for(int k = 0; k < input.length; k++){
                    if(input[k].equals("in")) {
                        start = k;
                        break;
                    }
                }
                hourOffset = StringToMath.convert(String.join(" ", Arrays.copyOfRange(input, ++start, input.length-1)));
                int hours = Integer.parseInt(hourOffset);
                cal.add(Calendar.HOUR, hours);
                String newTime = df.format(cal.getTime());
                StringToMath.clear();
                return ("the time in " + hourOffset + " hours will be " + newTime);
            }


        }

        return ("it is currently " + df.format(today));
    }
}
