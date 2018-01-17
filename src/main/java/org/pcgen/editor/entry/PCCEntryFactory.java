package org.pcgen.editor.entry;

import java.io.File;
import java.io.IOException;

/**
 * Created by Thor_2 on 8/19/2017.
 */
public class PCCEntryFactory {

    private final File currentDir;
    private final File dataFolder;

    public PCCEntryFactory(File currentDir, File dataFolder){
        this.currentDir = currentDir;
        this.dataFolder = dataFolder;
    }

    public Entry create(String line) throws IOException {
        //Check for empty lines
        if (null == line || line.isEmpty()) {
            return new Empty();
        }
        //Check for comments
        if (line.charAt(0) == '#') {
            return new Comment(line);
        }


        String[] tokens = line.split(":");
        switch (tokens[0]) {
            case "PCC":
                return new FileEntry(line, currentDir, dataFolder);
                //return FileEntry.create(line, dataFolder, currentFile);
            case "ABILITY":
            case "ABILITYCATEGORY":
            case "ARMORPROF":
            case "CLASS":
            case "COMPANION MODIFIER":
            case "DEITY":
            case "DOMAIN":
            case "EQUIPMENT":
            case "EQUIPMENT MODIFIER":
            case "FEAT":
            case "KIT":
            case "LANGUAGE":
            case "RACE":
            case "SHIELDPROF":
            case "SKILL":
            case "SPELL":
            case "TEMPLATE":
            case "DATACONTROL":
            case "ALIGNMENT":
            case "SAVE":
            case "STAT":
            case "EQUIPMOD":
            case "WEAPONPROF":
            case "COMPANIONMOD":
                return new Unknown(line);
            case "CAMPAIGN":
                return new ShortStringEntry(line, "Short DESC", "Name of Campaign Displayed in data load window.");
            case "GAMEMODE":
                return new ShortStringEntry(line, "Short DESC", "Designates the Game Mode.");
            case "COPYRIGHT":
                return new ShortStringEntry(line, "Short DESC", "Copyright Terms.");
            case "INFOTEXT":
                return new Unknown(line);
            case "COVER":
                return new FileEntry(line, currentDir, dataFolder);
            case "LOGO":
                return new Unknown(line);
            case "DESC":
                return new Unknown(line);
            case "KEY":
                return new ShortStringEntry(line, "Short DESC", "MISSING");
            case "TYPE":
                return new ShortStringEntry(line, "Short DESC", "Type will be used for sorting.");
            case "RANK":
            case "STATUS":
                return new ShortStringEntry(line, "Short DESC", "MISSING");
            case "GENRE":
                return new ShortStringEntry(line, "Short DESC", "This tells PCGen what genre this is, used to filter sources.");
            case "BOOKTYPE":
                return new ShortStringEntry(line, "Short DESC", "Identifies the source book type for use in prerequisites for loading other source book.");
            case "SETTING":
                return new ShortStringEntry(line, "Short DESC", "Identifies the setting of which this source is part.");
            case "PUBNAMELONG":
                return new ShortStringEntry(line, "Short DESC", "The Full Name of the Source < - Long name for the publisher of the material (used in some displays).");
            case "PUBNAMESHORT":
                return new ShortStringEntry(line, "Short DESC", "Short name for the publisher of the material (used in some displays).");
            case "PUBNAMEWEB":
                return new ShortStringEntry(line, "Short DESC", "Website for the publisher's site.");
            case "SOURCELONG":
                return new ShortStringEntry(line, "Short DESC", "Long title (used in some displays).");
            case "SOURCESHORT":
                return new ShortStringEntry(line, "Short DESC", "Short title (used in some displays).");
            case "SOURCEWEB":
                return new ShortStringEntry(line, "Short DESC", "Website for the source (typically the publisher's general site).");
            case "SOURCEDATE":
                return new ShortStringEntry(line, "Short DESC", "MISSINGv");
            case "URL":
                return new Unknown(line);
            case "ISOGL":
                return new EnumEntry(line, YES_NO.values(), "ShortDesc", "Long Desc");
            case "SHOWINMENU":
                return new EnumEntry(line, YES_NO.values(), "ShortDesc", "Long Desc");
            case "!PRECAMPAIGN":
            case "PRECAMPAIGN":
                return new Unknown(line);
            default:
                return new Unknown(line);
        }
    }
}
