package javatro.display.screens;

import static javatro.display.UI.*;
import static javatro.display.ansi.DeckArt.*;

import javatro.core.Deck.DeckType;
import javatro.core.JavatroException;
import javatro.manager.options.*;
import javatro.storage.Storage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RunSelectScreen extends Screen {

    private static int runNumber = 1;
    private final Storage storage = Storage.getStorageInstance();

    /**
     * Constructs a screen with specified options menu title.
     *
     * @throws JavatroException if optionsTitle is null or empty
     */
    public RunSelectScreen() throws JavatroException {
        super("Select Run To Load");
        if (storage.getNumberOfRuns() > 0) {
            super.commandMap.add(new StartRunNumberOption());
            super.commandMap.add(new SeeNextRunOption());
            super.commandMap.add(new SeePreviousRun());
            super.commandMap.add(new LoadJumpToRunScreenOption());
        }

        StartGameOption startGameOption = new StartGameOption();
        startGameOption.setDescription("Start A New Run");
        super.commandMap.add(startGameOption);
    }

    @Override
    public void displayScreen() {
        if (storage.getNumberOfRuns() > 0) displayCurrentChosenRun();
        else {
            List<String> contents = new ArrayList<>();

            String[] noSavedRunsArt =
                    new String[] {
                        "\u001B[48;5;242m "
                            + " \u001B[38;5;242;48;5;242m▄▄▄▄\u001B[38;5;242;48;5;60m▄\u001B[38;5;60;48;5;60m▄▄\u001B[38;5;60;48;5;243m▄▄\u001B[38;5;60;48;5;66m▄\u001B[38;5;66;48;5;66m▄▄▄▄\u001B[38;5;243;48;5;66m▄\u001B[38;5;241;48;5;243m▄\u001B[38;5;237;48;5;241m▄\u001B[38;5;237;48;5;237m▄▄▄▄▄▄\u001B[38;5;236;48;5;237m▄\u001B[38;5;235;48;5;235m▄▄\u001B[38;5;234;48;5;235m▄▄\u001B[38;5;235;48;5;235m▄\u001B[38;5;52;48;5;52m▄\u001B[38;5;52;48;5;1m▄\u001B[38;5;1;48;5;1m▄▄▄\u001B[48;5;94m"
                            + " \u001B[38;5;94;48;5;94m▄▄\u001B[48;5;94m  "
                            + " \u001B[38;5;94;48;5;94m▄\u001B[48;5;94m"
                            + " \u001B[38;5;94;48;5;94m▄▄\u001B[38;5;94;48;5;131m▄\u001B[38;5;130;48;5;173m▄\u001B[38;5;130;48;5;130m▄▄▄▄▄▄▄\u001B[38;5;94;48;5;94m▄\u001B[38;5;130;48;5;94m▄\u001B[38;5;94;48;5;131m▄\u001B[38;5;95;48;5;243m▄\u001B[38;5;243;48;5;243m▄\u001B[38;5;243;48;5;66m▄\u001B[38;5;66;48;5;66m▄▄\u001B[38;5;243;48;5;66m▄▄▄\u001B[38;5;243;48;5;243m▄\u001B[38;5;60;48;5;66m▄▄▄\u001B[m",
                        "\u001B[38;5;241;48;5;242m▄\u001B[38;5;242;48;5;242m▄▄▄▄▄▄▄\u001B[38;5;242;48;5;60m▄\u001B[38;5;60;48;5;60m▄▄\u001B[38;5;60;48;5;243m▄\u001B[38;5;243;48;5;243m▄▄\u001B[38;5;242;48;5;243m▄\u001B[38;5;241;48;5;243m▄\u001B[38;5;237;48;5;241m▄\u001B[38;5;237;48;5;236m▄\u001B[38;5;237;48;5;237m▄▄▄▄▄▄▄\u001B[38;5;235;48;5;236m▄\u001B[38;5;235;48;5;235m▄▄\u001B[38;5;234;48;5;234m▄▄▄\u001B[38;5;52;48;5;52m▄▄\u001B[38;5;1;48;5;1m▄▄▄\u001B[38;5;94;48;5;94m▄▄▄▄▄▄\u001B[48;5;94m"
                            + " \u001B[38;5;94;48;5;94m▄▄▄▄\u001B[38;5;94;48;5;130m▄\u001B[38;5;130;48;5;130m▄▄▄▄▄▄▄▄▄▄▄\u001B[38;5;95;48;5;95m▄\u001B[38;5;243;48;5;243m▄\u001B[38;5;66;48;5;66m▄\u001B[38;5;243;48;5;243m▄▄\u001B[38;5;60;48;5;243m▄▄▄\u001B[38;5;60;48;5;60m▄▄▄\u001B[m",
                        "\u001B[38;5;241;48;5;241m▄▄\u001B[38;5;241;48;5;242m▄\u001B[38;5;242;48;5;242m▄▄▄▄▄▄▄▄▄\u001B[38;5;242;48;5;243m▄▄\u001B[38;5;239;48;5;241m▄\u001B[38;5;237;48;5;237m▄▄▄▄▄▄▄▄▄\u001B[38;5;236;48;5;236m▄\u001B[38;5;235;48;5;235m▄\u001B[38;5;234;48;5;234m▄▄▄▄▄\u001B[38;5;52;48;5;52m▄▄\u001B[38;5;52;48;5;1m▄\u001B[38;5;1;48;5;1m▄▄▄\u001B[38;5;1;48;5;94m▄\u001B[38;5;1;48;5;88m▄\u001B[38;5;94;48;5;94m▄▄▄▄▄▄▄▄▄▄\u001B[38;5;130;48;5;130m▄▄▄▄▄▄▄▄▄▄▄\u001B[38;5;95;48;5;95m▄\u001B[38;5;243;48;5;243m▄\u001B[38;5;60;48;5;60m▄\u001B[38;5;243;48;5;60m▄\u001B[38;5;60;48;5;60m▄▄▄▄\u001B[38;5;242;48;5;60m▄\u001B[38;5;242;48;5;242m▄\u001B[m",
                        "\u001B[38;5;241;48;5;241m▄▄\u001B[48;5;241m"
                            + " \u001B[38;5;241;48;5;241m▄▄\u001B[38;5;241;48;5;242m▄▄\u001B[38;5;242;48;5;242m▄\u001B[38;5;241;48;5;242m▄▄\u001B[38;5;242;48;5;242m▄\u001B[38;5;243;48;5;242m▄\u001B[38;5;8;48;5;242m▄\u001B[38;5;243;48;5;241m▄\u001B[38;5;240;48;5;237m▄\u001B[38;5;237;48;5;237m▄▄▄▄\u001B[38;5;237;48;5;236m▄\u001B[38;5;237;48;5;237m▄▄▄▄\u001B[38;5;236;48;5;236m▄\u001B[38;5;235;48;5;235m▄\u001B[38;5;234;48;5;234m▄▄▄▄\u001B[38;5;235;48;5;234m▄\u001B[38;5;237;48;5;235m▄\u001B[38;5;239;48;5;52m▄\u001B[38;5;95;48;5;52m▄▄▄▄\u001B[38;5;95;48;5;1m▄▄▄\u001B[38;5;131;48;5;94m▄\u001B[38;5;94;48;5;94m▄▄▄▄▄▄▄▄\u001B[38;5;95;48;5;94m▄▄\u001B[38;5;241;48;5;94m▄\u001B[38;5;59;48;5;94m▄\u001B[38;5;95;48;5;94m▄\u001B[38;5;239;48;5;94m▄\u001B[38;5;94;48;5;130m▄▄\u001B[38;5;130;48;5;130m▄▄▄\u001B[38;5;94;48;5;95m▄\u001B[38;5;239;48;5;95m▄\u001B[38;5;242;48;5;243m▄\u001B[38;5;60;48;5;60m▄\u001B[38;5;242;48;5;60m▄▄\u001B[38;5;242;48;5;242m▄▄▄\u001B[48;5;242m"
                            + " \u001B[m",
                        "\u001B[38;5;241;48;5;241m▄\u001B[48;5;241m"
                            + " \u001B[38;5;241;48;5;241m▄▄▄▄\u001B[38;5;59;48;5;242m▄\u001B[38;5;131;48;5;95m▄▄▄▄\u001B[38;5;95;48;5;95m▄\u001B[38;5;131;48;5;95m▄\u001B[38;5;131;48;5;131m▄▄\u001B[38;5;95;48;5;239m▄\u001B[38;5;236;48;5;236m▄▄▄▄▄\u001B[38;5;237;48;5;237m▄▄▄\u001B[38;5;235;48;5;236m▄\u001B[38;5;234;48;5;234m▄▄▄\u001B[38;5;236;48;5;234m▄\u001B[38;5;237;48;5;236m▄\u001B[38;5;238;48;5;237m▄\u001B[38;5;59;48;5;240m▄\u001B[38;5;243;48;5;95m▄\u001B[38;5;243;48;5;101m▄\u001B[38;5;243;48;5;95m▄\u001B[38;5;8;48;5;8m▄\u001B[38;5;245;48;5;138m▄\u001B[38;5;246;48;5;138m▄▄\u001B[38;5;138;48;5;138m▄\u001B[38;5;144;48;5;138m▄\u001B[38;5;138;48;5;137m▄\u001B[38;5;138;48;5;131m▄\u001B[38;5;137;48;5;95m▄\u001B[38;5;131;48;5;94m▄\u001B[38;5;1;48;5;94m▄\u001B[38;5;94;48;5;94m▄▄▄\u001B[38;5;240;48;5;95m▄\u001B[38;5;242;48;5;242m▄\u001B[38;5;60;48;5;242m▄\u001B[38;5;242;48;5;242m▄\u001B[38;5;60;48;5;242m▄\u001B[38;5;242;48;5;59m▄\u001B[38;5;241;48;5;239m▄\u001B[38;5;240;48;5;94m▄\u001B[38;5;94;48;5;94m▄\u001B[38;5;94;48;5;130m▄\u001B[38;5;131;48;5;130m▄\u001B[38;5;137;48;5;130m▄\u001B[38;5;138;48;5;95m▄\u001B[38;5;8;48;5;242m▄\u001B[38;5;242;48;5;242m▄▄▄▄▄▄▄\u001B[m",
                        "\u001B[38;5;59;48;5;59m▄▄▄\u001B[38;5;59;48;5;241m▄▄▄\u001B[38;5;59;48;5;59m▄\u001B[38;5;95;48;5;95m▄\u001B[38;5;95;48;5;131m▄\u001B[38;5;95;48;5;137m▄\u001B[38;5;237;48;5;137m▄\u001B[38;5;95;48;5;131m▄\u001B[38;5;131;48;5;131m▄\u001B[38;5;131;48;5;137m▄\u001B[38;5;137;48;5;131m▄\u001B[38;5;95;48;5;95m▄\u001B[38;5;236;48;5;236m▄▄\u001B[38;5;237;48;5;236m▄\u001B[38;5;238;48;5;237m▄\u001B[38;5;240;48;5;237m▄\u001B[38;5;59;48;5;237m▄\u001B[38;5;241;48;5;237m▄\u001B[38;5;241;48;5;238m▄\u001B[38;5;237;48;5;236m▄\u001B[38;5;235;48;5;234m▄\u001B[38;5;237;48;5;235m▄\u001B[38;5;236;48;5;236m▄\u001B[38;5;234;48;5;235m▄\u001B[38;5;235;48;5;235m▄\u001B[38;5;236;48;5;237m▄\u001B[38;5;238;48;5;240m▄\u001B[38;5;242;48;5;242m▄\u001B[38;5;8;48;5;243m▄\u001B[38;5;102;48;5;8m▄\u001B[38;5;245;48;5;102m▄\u001B[38;5;246;48;5;245m▄\u001B[38;5;246;48;5;246m▄▄\u001B[38;5;247;48;5;247m▄\u001B[38;5;137;48;5;144m▄\u001B[38;5;130;48;5;138m▄\u001B[38;5;130;48;5;136m▄\u001B[38;5;130;48;5;130m▄\u001B[38;5;130;48;5;137m▄\u001B[38;5;137;48;5;131m▄\u001B[38;5;95;48;5;94m▄\u001B[38;5;94;48;5;94m▄\u001B[38;5;238;48;5;237m▄\u001B[38;5;59;48;5;59m▄\u001B[38;5;242;48;5;242m▄▄▄▄▄\u001B[38;5;242;48;5;241m▄\u001B[38;5;60;48;5;241m▄\u001B[38;5;242;48;5;59m▄\u001B[38;5;243;48;5;239m▄\u001B[38;5;102;48;5;101m▄\u001B[38;5;246;48;5;246m▄\u001B[38;5;248;48;5;247m▄\u001B[38;5;249;48;5;145m▄\u001B[38;5;247;48;5;245m▄\u001B[38;5;243;48;5;242m▄\u001B[38;5;242;48;5;242m▄▄▄\u001B[38;5;241;48;5;242m▄\u001B[38;5;241;48;5;241m▄\u001B[m",
                        "\u001B[38;5;59;48;5;59m▄▄▄▄▄▄\u001B[38;5;240;48;5;240m▄\u001B[38;5;238;48;5;239m▄\u001B[38;5;237;48;5;239m▄\u001B[38;5;235;48;5;236m▄\u001B[38;5;235;48;5;235m▄\u001B[38;5;236;48;5;240m▄\u001B[38;5;95;48;5;131m▄▄\u001B[38;5;131;48;5;131m▄\u001B[38;5;95;48;5;131m▄\u001B[38;5;236;48;5;237m▄\u001B[38;5;238;48;5;237m▄\u001B[38;5;241;48;5;239m▄\u001B[38;5;241;48;5;59m▄\u001B[38;5;241;48;5;241m▄\u001B[38;5;241;48;5;242m▄▄\u001B[38;5;241;48;5;241m▄\u001B[38;5;237;48;5;237m▄\u001B[38;5;235;48;5;234m▄\u001B[38;5;237;48;5;237m▄\u001B[38;5;235;48;5;235m▄\u001B[38;5;234;48;5;234m▄\u001B[38;5;235;48;5;235m▄\u001B[38;5;236;48;5;52m▄\u001B[38;5;58;48;5;58m▄\u001B[38;5;58;48;5;239m▄\u001B[38;5;95;48;5;8m▄\u001B[38;5;102;48;5;245m▄\u001B[38;5;246;48;5;245m▄▄\u001B[38;5;8;48;5;246m▄\u001B[38;5;95;48;5;246m▄\u001B[38;5;94;48;5;137m▄\u001B[38;5;94;48;5;130m▄▄\u001B[38;5;130;48;5;130m▄▄▄\u001B[38;5;137;48;5;137m▄\u001B[38;5;101;48;5;95m▄\u001B[38;5;238;48;5;236m▄\u001B[38;5;237;48;5;237m▄\u001B[38;5;59;48;5;240m▄\u001B[38;5;242;48;5;242m▄▄▄▄▄▄▄▄\u001B[38;5;246;48;5;102m▄\u001B[38;5;245;48;5;8m▄\u001B[38;5;247;48;5;247m▄\u001B[38;5;145;48;5;248m▄\u001B[38;5;145;48;5;249m▄\u001B[38;5;246;48;5;250m▄\u001B[38;5;60;48;5;245m▄\u001B[38;5;241;48;5;241m▄▄▄▄▄\u001B[m",
                        "\u001B[38;5;240;48;5;240m▄\u001B[38;5;59;48;5;59m▄▄▄▄▄\u001B[38;5;239;48;5;239m▄\u001B[38;5;238;48;5;238m▄\u001B[38;5;238;48;5;237m▄\u001B[38;5;236;48;5;236m▄\u001B[38;5;235;48;5;235m▄\u001B[38;5;238;48;5;238m▄\u001B[38;5;240;48;5;95m▄\u001B[38;5;131;48;5;137m▄\u001B[38;5;131;48;5;131m▄\u001B[38;5;95;48;5;95m▄\u001B[38;5;238;48;5;237m▄\u001B[38;5;59;48;5;240m▄\u001B[38;5;59;48;5;241m▄\u001B[38;5;241;48;5;241m▄▄▄▄\u001B[38;5;240;48;5;59m▄\u001B[38;5;237;48;5;237m▄\u001B[38;5;235;48;5;235m▄\u001B[38;5;237;48;5;237m▄\u001B[38;5;235;48;5;235m▄\u001B[38;5;234;48;5;234m▄\u001B[38;5;236;48;5;234m▄\u001B[38;5;238;48;5;235m▄\u001B[38;5;237;48;5;234m▄\u001B[38;5;234;48;5;235m▄\u001B[38;5;234;48;5;238m▄\u001B[38;5;237;48;5;242m▄\u001B[38;5;243;48;5;102m▄\u001B[38;5;102;48;5;102m▄\u001B[38;5;95;48;5;242m▄\u001B[38;5;94;48;5;239m▄\u001B[38;5;58;48;5;94m▄▄\u001B[38;5;95;48;5;94m▄▄\u001B[38;5;94;48;5;94m▄\u001B[38;5;130;48;5;94m▄\u001B[38;5;95;48;5;131m▄\u001B[38;5;102;48;5;8m▄\u001B[38;5;101;48;5;95m▄\u001B[38;5;8;48;5;101m▄\u001B[38;5;242;48;5;8m▄\u001B[38;5;241;48;5;242m▄▄\u001B[38;5;241;48;5;241m▄▄▄▄\u001B[38;5;241;48;5;242m▄\u001B[38;5;241;48;5;243m▄\u001B[38;5;241;48;5;245m▄\u001B[38;5;60;48;5;66m▄\u001B[38;5;66;48;5;246m▄\u001B[38;5;66;48;5;247m▄\u001B[38;5;242;48;5;103m▄\u001B[38;5;241;48;5;66m▄\u001B[38;5;241;48;5;241m▄▄▄▄\u001B[48;5;241m"
                            + " \u001B[38;5;241;48;5;241m▄\u001B[m",
                        "\u001B[38;5;240;48;5;240m▄▄▄▄\u001B[48;5;59m "
                            + " \u001B[38;5;239;48;5;239m▄\u001B[38;5;238;48;5;238m▄▄\u001B[38;5;236;48;5;236m▄\u001B[38;5;235;48;5;235m▄\u001B[38;5;237;48;5;238m▄\u001B[38;5;236;48;5;237m▄\u001B[38;5;131;48;5;131m▄\u001B[38;5;95;48;5;95m▄▄\u001B[38;5;8;48;5;240m▄\u001B[38;5;241;48;5;59m▄\u001B[38;5;59;48;5;59m▄▄\u001B[38;5;241;48;5;59m▄\u001B[38;5;59;48;5;59m▄\u001B[38;5;59;48;5;241m▄\u001B[38;5;59;48;5;59m▄\u001B[38;5;238;48;5;237m▄\u001B[38;5;236;48;5;236m▄\u001B[38;5;237;48;5;237m▄\u001B[38;5;237;48;5;236m▄\u001B[38;5;235;48;5;234m▄\u001B[38;5;235;48;5;236m▄▄\u001B[38;5;236;48;5;234m▄\u001B[38;5;237;48;5;235m▄\u001B[38;5;235;48;5;234m▄\u001B[38;5;234;48;5;234m▄\u001B[38;5;239;48;5;240m▄\u001B[38;5;245;48;5;245m▄\u001B[38;5;137;48;5;137m▄\u001B[38;5;131;48;5;130m▄\u001B[38;5;94;48;5;94m▄\u001B[38;5;94;48;5;235m▄\u001B[38;5;94;48;5;238m▄\u001B[38;5;95;48;5;95m▄\u001B[38;5;101;48;5;95m▄\u001B[38;5;138;48;5;137m▄\u001B[38;5;247;48;5;138m▄\u001B[38;5;246;48;5;245m▄\u001B[38;5;137;48;5;101m▄\u001B[38;5;243;48;5;8m▄\u001B[38;5;241;48;5;241m▄▄▄▄▄▄▄▄▄▄▄\u001B[48;5;241m"
                            + " \u001B[38;5;241;48;5;241m▄▄▄▄▄▄\u001B[38;5;59;48;5;241m▄▄▄\u001B[m",
                        "\u001B[38;5;240;48;5;240m▄▄▄▄▄▄\u001B[38;5;240;48;5;239m▄\u001B[38;5;238;48;5;237m▄\u001B[38;5;237;48;5;237m▄\u001B[38;5;235;48;5;235m▄\u001B[38;5;235;48;5;234m▄\u001B[38;5;238;48;5;239m▄\u001B[38;5;236;48;5;236m▄\u001B[38;5;95;48;5;95m▄\u001B[38;5;239;48;5;95m▄\u001B[38;5;238;48;5;95m▄\u001B[38;5;235;48;5;8m▄\u001B[38;5;235;48;5;238m▄▄\u001B[38;5;236;48;5;238m▄\u001B[38;5;239;48;5;240m▄\u001B[38;5;59;48;5;59m▄▄\u001B[38;5;240;48;5;240m▄\u001B[38;5;240;48;5;239m▄\u001B[38;5;236;48;5;236m▄\u001B[38;5;236;48;5;237m▄\u001B[38;5;237;48;5;237m▄\u001B[38;5;238;48;5;237m▄\u001B[38;5;239;48;5;236m▄\u001B[38;5;240;48;5;236m▄\u001B[38;5;241;48;5;239m▄\u001B[38;5;240;48;5;239m▄\u001B[38;5;238;48;5;237m▄\u001B[38;5;236;48;5;236m▄\u001B[38;5;238;48;5;239m▄\u001B[38;5;8;48;5;102m▄\u001B[38;5;247;48;5;247m▄\u001B[38;5;247;48;5;138m▄\u001B[38;5;144;48;5;137m▄\u001B[38;5;138;48;5;137m▄▄\u001B[38;5;247;48;5;138m▄\u001B[38;5;247;48;5;144m▄\u001B[38;5;248;48;5;247m▄\u001B[38;5;247;48;5;247m▄\u001B[38;5;246;48;5;246m▄\u001B[38;5;138;48;5;138m▄\u001B[38;5;243;48;5;243m▄\u001B[38;5;241;48;5;241m▄▄▄▄▄▄▄\u001B[38;5;59;48;5;241m▄▄\u001B[38;5;59;48;5;59m▄▄▄▄▄▄▄▄▄▄▄▄\u001B[m",
                        "\u001B[38;5;240;48;5;240m▄▄▄▄▄▄▄\u001B[38;5;239;48;5;238m▄\u001B[38;5;236;48;5;236m▄\u001B[38;5;234;48;5;235m▄▄\u001B[38;5;235;48;5;235m▄▄\u001B[38;5;235;48;5;237m▄\u001B[38;5;235;48;5;235m▄▄▄▄\u001B[38;5;236;48;5;235m▄\u001B[38;5;237;48;5;237m▄\u001B[38;5;59;48;5;240m▄\u001B[38;5;240;48;5;59m▄\u001B[38;5;240;48;5;240m▄▄▄\u001B[38;5;237;48;5;236m▄\u001B[38;5;236;48;5;235m▄\u001B[38;5;236;48;5;237m▄\u001B[38;5;237;48;5;238m▄\u001B[38;5;238;48;5;240m▄\u001B[38;5;239;48;5;240m▄\u001B[38;5;240;48;5;240m▄\u001B[38;5;239;48;5;240m▄\u001B[38;5;236;48;5;238m▄\u001B[38;5;235;48;5;236m▄\u001B[38;5;240;48;5;239m▄\u001B[38;5;245;48;5;102m▄\u001B[38;5;247;48;5;247m▄▄\u001B[38;5;246;48;5;138m▄\u001B[38;5;138;48;5;138m▄\u001B[38;5;247;48;5;247m▄▄▄\u001B[48;5;247m"
                            + " \u001B[38;5;246;48;5;246m▄\u001B[38;5;138;48;5;138m▄\u001B[38;5;8;48;5;102m▄\u001B[38;5;59;48;5;242m▄\u001B[38;5;59;48;5;59m▄▄\u001B[38;5;59;48;5;241m▄\u001B[38;5;59;48;5;59m▄▄▄▄▄▄\u001B[48;5;59m"
                            + "  \u001B[38;5;59;48;5;59m▄▄▄▄▄▄\u001B[38;5;240;48;5;59m▄\u001B[38;5;59;48;5;59m▄▄▄\u001B[m",
                        "\u001B[38;5;240;48;5;240m▄▄▄▄▄▄▄▄\u001B[38;5;236;48;5;236m▄\u001B[38;5;234;48;5;234m▄▄▄▄▄\u001B[38;5;235;48;5;235m▄▄\u001B[38;5;234;48;5;236m▄\u001B[38;5;235;48;5;236m▄\u001B[38;5;235;48;5;235m▄\u001B[38;5;236;48;5;236m▄\u001B[38;5;238;48;5;239m▄\u001B[38;5;239;48;5;240m▄\u001B[38;5;240;48;5;240m▄▄▄\u001B[38;5;239;48;5;238m▄\u001B[38;5;238;48;5;236m▄\u001B[38;5;236;48;5;236m▄\u001B[38;5;235;48;5;237m▄\u001B[38;5;236;48;5;237m▄\u001B[38;5;237;48;5;238m▄\u001B[38;5;238;48;5;239m▄\u001B[38;5;236;48;5;236m▄\u001B[38;5;235;48;5;235m▄\u001B[38;5;234;48;5;235m▄\u001B[38;5;234;48;5;237m▄\u001B[38;5;238;48;5;242m▄\u001B[38;5;242;48;5;245m▄\u001B[38;5;8;48;5;243m▄\u001B[38;5;246;48;5;138m▄\u001B[38;5;247;48;5;245m▄\u001B[38;5;138;48;5;138m▄\u001B[38;5;246;48;5;247m▄\u001B[38;5;138;48;5;247m▄▄\u001B[38;5;95;48;5;245m▄\u001B[38;5;242;48;5;243m▄\u001B[38;5;59;48;5;241m▄\u001B[38;5;240;48;5;59m▄\u001B[38;5;59;48;5;59m▄▄▄▄\u001B[38;5;240;48;5;59m▄\u001B[38;5;59;48;5;59m▄▄▄▄\u001B[38;5;240;48;5;59m▄▄\u001B[38;5;240;48;5;240m▄▄▄▄▄▄▄▄▄▄\u001B[m",
                        "\u001B[48;5;239m   "
                            + " \u001B[38;5;239;48;5;240m▄\u001B[38;5;239;48;5;239m▄\u001B[38;5;239;48;5;240m▄\u001B[38;5;238;48;5;239m▄\u001B[38;5;235;48;5;236m▄\u001B[38;5;234;48;5;234m▄\u001B[38;5;234;48;5;233m▄\u001B[38;5;234;48;5;234m▄▄\u001B[38;5;236;48;5;234m▄\u001B[38;5;239;48;5;236m▄\u001B[38;5;239;48;5;238m▄\u001B[38;5;238;48;5;238m▄\u001B[38;5;234;48;5;234m▄\u001B[38;5;235;48;5;234m▄\u001B[38;5;236;48;5;235m▄\u001B[38;5;238;48;5;238m▄\u001B[38;5;240;48;5;240m▄▄\u001B[38;5;239;48;5;240m▄\u001B[38;5;239;48;5;239m▄\u001B[38;5;239;48;5;240m▄\u001B[38;5;239;48;5;239m▄\u001B[38;5;235;48;5;236m▄\u001B[38;5;235;48;5;235m▄\u001B[38;5;234;48;5;234m▄\u001B[38;5;233;48;5;236m▄\u001B[38;5;233;48;5;238m▄\u001B[38;5;233;48;5;237m▄\u001B[38;5;233;48;5;236m▄\u001B[38;5;52;48;5;237m▄\u001B[38;5;94;48;5;238m▄\u001B[38;5;94;48;5;239m▄\u001B[38;5;94;48;5;95m▄▄\u001B[38;5;94;48;5;138m▄▄▄▄\u001B[38;5;94;48;5;131m▄▄\u001B[38;5;243;48;5;95m▄\u001B[38;5;241;48;5;242m▄\u001B[38;5;240;48;5;240m▄\u001B[38;5;59;48;5;240m▄\u001B[38;5;240;48;5;59m▄▄▄\u001B[38;5;240;48;5;240m▄▄▄▄\u001B[48;5;240m"
                            + "  \u001B[38;5;240;48;5;240m▄▄▄▄▄▄▄▄▄▄▄▄\u001B[m",
                        "\u001B[38;5;239;48;5;239m▄▄\u001B[48;5;239m"
                            + " \u001B[38;5;239;48;5;239m▄▄▄▄\u001B[38;5;236;48;5;237m▄\u001B[38;5;233;48;5;234m▄\u001B[38;5;234;48;5;234m▄\u001B[38;5;235;48;5;234m▄\u001B[48;5;234m"
                            + " \u001B[38;5;242;48;5;234m▄\u001B[38;5;235;48;5;236m▄\u001B[38;5;236;48;5;239m▄\u001B[38;5;238;48;5;239m▄\u001B[38;5;234;48;5;236m▄\u001B[48;5;234m"
                            + " \u001B[38;5;235;48;5;235m▄\u001B[38;5;236;48;5;236m▄\u001B[38;5;237;48;5;238m▄\u001B[38;5;240;48;5;240m▄\u001B[38;5;239;48;5;240m▄\u001B[48;5;239m"
                            + "   \u001B[38;5;239;48;5;239m▄\u001B[38;5;236;48;5;235m▄\u001B[38;5;235;48;5;235m▄\u001B[38;5;234;48;5;234m▄\u001B[38;5;234;48;5;233m▄\u001B[38;5;234;48;5;232m▄▄\u001B[38;5;234;48;5;233m▄\u001B[38;5;234;48;5;52m▄\u001B[38;5;52;48;5;52m▄\u001B[38;5;58;48;5;52m▄\u001B[38;5;236;48;5;1m▄\u001B[38;5;94;48;5;94m▄\u001B[38;5;1;48;5;94m▄\u001B[38;5;94;48;5;94m▄\u001B[38;5;1;48;5;1m▄\u001B[38;5;58;48;5;94m▄\u001B[38;5;95;48;5;94m▄\u001B[38;5;8;48;5;101m▄\u001B[38;5;242;48;5;243m▄\u001B[38;5;59;48;5;59m▄\u001B[38;5;240;48;5;240m▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄\u001B[38;5;239;48;5;240m▄\u001B[38;5;240;48;5;240m▄▄▄\u001B[m",
                        "\u001B[38;5;239;48;5;239m▄▄▄▄▄▄\u001B[38;5;238;48;5;239m▄\u001B[38;5;235;48;5;236m▄\u001B[38;5;233;48;5;233m▄\u001B[38;5;235;48;5;234m▄\u001B[38;5;238;48;5;236m▄\u001B[38;5;235;48;5;236m▄\u001B[38;5;235;48;5;235m▄▄▄\u001B[38;5;234;48;5;237m▄\u001B[38;5;234;48;5;234m▄\u001B[48;5;234m"
                            + " \u001B[38;5;235;48;5;235m▄\u001B[38;5;237;48;5;235m▄\u001B[38;5;238;48;5;237m▄\u001B[38;5;239;48;5;239m▄▄▄▄▄▄\u001B[38;5;239;48;5;240m▄\u001B[38;5;234;48;5;234m▄▄\u001B[38;5;234;48;5;235m▄\u001B[38;5;235;48;5;235m▄\u001B[38;5;233;48;5;234m▄▄\u001B[38;5;52;48;5;52m▄\u001B[38;5;52;48;5;94m▄\u001B[38;5;1;48;5;94m▄\u001B[38;5;94;48;5;94m▄▄\u001B[38;5;94;48;5;130m▄\u001B[38;5;94;48;5;94m▄\u001B[38;5;95;48;5;237m▄\u001B[38;5;243;48;5;95m▄\u001B[38;5;242;48;5;242m▄\u001B[38;5;242;48;5;243m▄\u001B[38;5;245;48;5;243m▄\u001B[38;5;109;48;5;66m▄\u001B[38;5;109;48;5;242m▄\u001B[38;5;73;48;5;241m▄\u001B[38;5;66;48;5;59m▄\u001B[38;5;241;48;5;240m▄▄\u001B[38;5;60;48;5;240m▄\u001B[38;5;67;48;5;59m▄\u001B[38;5;24;48;5;240m▄\u001B[38;5;23;48;5;240m▄\u001B[38;5;24;48;5;240m▄▄▄▄▄\u001B[38;5;60;48;5;240m▄\u001B[38;5;60;48;5;239m▄\u001B[38;5;240;48;5;239m▄\u001B[38;5;239;48;5;239m▄▄▄▄▄▄\u001B[m",
                        "\u001B[38;5;239;48;5;239m▄▄▄▄▄\u001B[38;5;238;48;5;239m▄\u001B[38;5;237;48;5;237m▄\u001B[38;5;234;48;5;234m▄\u001B[38;5;233;48;5;234m▄\u001B[38;5;234;48;5;235m▄\u001B[38;5;237;48;5;236m▄\u001B[38;5;237;48;5;235m▄\u001B[38;5;235;48;5;235m▄▄▄▄\u001B[38;5;235;48;5;234m▄▄\u001B[38;5;236;48;5;235m▄\u001B[38;5;236;48;5;236m▄\u001B[38;5;239;48;5;239m▄▄▄▄▄\u001B[38;5;60;48;5;241m▄\u001B[38;5;152;48;5;66m▄\u001B[38;5;23;48;5;238m▄\u001B[38;5;236;48;5;235m▄\u001B[38;5;234;48;5;234m▄\u001B[38;5;233;48;5;233m▄\u001B[38;5;234;48;5;234m▄\u001B[38;5;236;48;5;234m▄\u001B[38;5;237;48;5;234m▄\u001B[38;5;238;48;5;233m▄\u001B[38;5;238;48;5;234m▄\u001B[38;5;238;48;5;52m▄▄\u001B[38;5;95;48;5;1m▄\u001B[38;5;101;48;5;94m▄\u001B[38;5;8;48;5;95m▄\u001B[38;5;242;48;5;243m▄\u001B[38;5;241;48;5;242m▄\u001B[38;5;242;48;5;241m▄\u001B[38;5;243;48;5;242m▄\u001B[38;5;66;48;5;66m▄\u001B[38;5;73;48;5;73m▄\u001B[38;5;73;48;5;74m▄\u001B[38;5;67;48;5;110m▄\u001B[38;5;73;48;5;109m▄\u001B[38;5;73;48;5;73m▄\u001B[38;5;73;48;5;6m▄\u001B[38;5;31;48;5;6m▄\u001B[38;5;6;48;5;31m▄\u001B[38;5;31;48;5;6m▄▄\u001B[38;5;6;48;5;6m▄\u001B[38;5;6;48;5;31m▄\u001B[38;5;6;48;5;37m▄\u001B[38;5;6;48;5;38m▄\u001B[38;5;24;48;5;38m▄\u001B[38;5;23;48;5;74m▄\u001B[38;5;23;48;5;31m▄\u001B[38;5;23;48;5;24m▄\u001B[38;5;59;48;5;60m▄\u001B[38;5;240;48;5;59m▄\u001B[38;5;238;48;5;240m▄\u001B[38;5;239;48;5;239m▄▄▄\u001B[m",
                        "\u001B[38;5;239;48;5;239m▄▄▄▄▄▄\u001B[38;5;236;48;5;236m▄\u001B[38;5;233;48;5;233m▄▄\u001B[38;5;234;48;5;234m▄\u001B[38;5;237;48;5;238m▄\u001B[38;5;59;48;5;240m▄\u001B[38;5;238;48;5;237m▄\u001B[38;5;235;48;5;235m▄\u001B[38;5;234;48;5;235m▄\u001B[38;5;235;48;5;236m▄\u001B[38;5;237;48;5;236m▄\u001B[38;5;239;48;5;237m▄\u001B[38;5;236;48;5;236m▄\u001B[38;5;240;48;5;238m▄\u001B[38;5;73;48;5;60m▄\u001B[38;5;73;48;5;24m▄\u001B[38;5;73;48;5;6m▄\u001B[38;5;73;48;5;60m▄\u001B[38;5;67;48;5;67m▄\u001B[38;5;74;48;5;67m▄\u001B[38;5;73;48;5;73m▄\u001B[38;5;23;48;5;23m▄▄\u001B[38;5;236;48;5;235m▄\u001B[38;5;234;48;5;234m▄\u001B[38;5;233;48;5;233m▄\u001B[38;5;233;48;5;235m▄\u001B[38;5;235;48;5;237m▄\u001B[38;5;237;48;5;239m▄\u001B[38;5;240;48;5;241m▄\u001B[38;5;241;48;5;242m▄\u001B[38;5;242;48;5;243m▄\u001B[38;5;243;48;5;8m▄\u001B[38;5;242;48;5;8m▄\u001B[38;5;59;48;5;243m▄\u001B[38;5;241;48;5;241m▄\u001B[38;5;60;48;5;241m▄\u001B[38;5;66;48;5;66m▄\u001B[38;5;67;48;5;66m▄\u001B[38;5;67;48;5;67m▄▄\u001B[38;5;73;48;5;67m▄\u001B[38;5;73;48;5;73m▄▄▄▄\u001B[38;5;109;48;5;67m▄\u001B[38;5;152;48;5;73m▄\u001B[38;5;7;48;5;74m▄\u001B[38;5;109;48;5;74m▄\u001B[38;5;240;48;5;60m▄\u001B[38;5;235;48;5;236m▄\u001B[38;5;234;48;5;235m▄▄\u001B[38;5;234;48;5;234m▄\u001B[38;5;234;48;5;235m▄\u001B[38;5;235;48;5;235m▄▄\u001B[38;5;235;48;5;236m▄\u001B[38;5;237;48;5;237m▄\u001B[38;5;238;48;5;236m▄\u001B[38;5;236;48;5;237m▄\u001B[38;5;236;48;5;238m▄\u001B[38;5;239;48;5;239m▄\u001B[m",
                        "\u001B[38;5;238;48;5;238m▄▄▄▄▄\u001B[38;5;236;48;5;238m▄\u001B[38;5;233;48;5;235m▄\u001B[38;5;232;48;5;233m▄\u001B[38;5;233;48;5;233m▄\u001B[38;5;233;48;5;234m▄\u001B[38;5;236;48;5;237m▄\u001B[38;5;59;48;5;240m▄\u001B[38;5;236;48;5;236m▄\u001B[38;5;234;48;5;234m▄▄▄\u001B[38;5;234;48;5;236m▄\u001B[38;5;236;48;5;239m▄\u001B[38;5;234;48;5;235m▄\u001B[38;5;234;48;5;236m▄\u001B[38;5;234;48;5;240m▄\u001B[38;5;235;48;5;66m▄\u001B[38;5;238;48;5;109m▄\u001B[38;5;239;48;5;152m▄\u001B[38;5;238;48;5;66m▄\u001B[38;5;237;48;5;66m▄\u001B[38;5;235;48;5;60m▄\u001B[38;5;238;48;5;23m▄\u001B[38;5;23;48;5;23m▄▄\u001B[38;5;235;48;5;235m▄\u001B[38;5;235;48;5;234m▄\u001B[38;5;234;48;5;233m▄\u001B[38;5;235;48;5;233m▄\u001B[38;5;236;48;5;234m▄\u001B[38;5;238;48;5;236m▄\u001B[38;5;239;48;5;237m▄\u001B[38;5;59;48;5;238m▄\u001B[38;5;60;48;5;239m▄\u001B[38;5;66;48;5;239m▄\u001B[38;5;66;48;5;59m▄\u001B[38;5;6;48;5;66m▄\u001B[38;5;31;48;5;66m▄\u001B[38;5;31;48;5;31m▄\u001B[38;5;67;48;5;31m▄\u001B[38;5;73;48;5;67m▄\u001B[38;5;73;48;5;73m▄\u001B[38;5;67;48;5;109m▄\u001B[38;5;60;48;5;109m▄\u001B[38;5;66;48;5;109m▄\u001B[38;5;6;48;5;109m▄\u001B[38;5;24;48;5;247m▄\u001B[38;5;23;48;5;66m▄▄\u001B[38;5;235;48;5;240m▄\u001B[38;5;235;48;5;238m▄\u001B[38;5;235;48;5;236m▄\u001B[38;5;235;48;5;235m▄▄\u001B[38;5;235;48;5;234m▄\u001B[38;5;234;48;5;234m▄▄▄\u001B[38;5;234;48;5;235m▄▄\u001B[38;5;235;48;5;236m▄\u001B[38;5;238;48;5;238m▄▄\u001B[38;5;238;48;5;237m▄\u001B[38;5;237;48;5;237m▄\u001B[m",
                        "\u001B[38;5;238;48;5;238m▄▄▄▄▄\u001B[38;5;236;48;5;236m▄\u001B[38;5;233;48;5;232m▄\u001B[38;5;232;48;5;232m▄\u001B[38;5;232;48;5;233m▄\u001B[38;5;233;48;5;233m▄\u001B[38;5;234;48;5;235m▄\u001B[38;5;240;48;5;239m▄\u001B[38;5;240;48;5;238m▄\u001B[38;5;235;48;5;234m▄\u001B[38;5;234;48;5;234m▄\u001B[48;5;234m"
                            + "  \u001B[38;5;234;48;5;234m▄▄▄\u001B[38;5;233;48;5;233m▄▄▄▄\u001B[38;5;232;48;5;233m▄\u001B[38;5;233;48;5;234m▄\u001B[38;5;237;48;5;234m▄\u001B[38;5;241;48;5;240m▄\u001B[38;5;23;48;5;23m▄▄\u001B[38;5;23;48;5;236m▄\u001B[38;5;235;48;5;235m▄\u001B[38;5;238;48;5;235m▄\u001B[38;5;239;48;5;236m▄\u001B[38;5;23;48;5;237m▄\u001B[38;5;23;48;5;23m▄▄\u001B[38;5;24;48;5;23m▄\u001B[38;5;24;48;5;6m▄\u001B[38;5;6;48;5;6m▄\u001B[38;5;66;48;5;31m▄\u001B[38;5;73;48;5;30m▄\u001B[38;5;73;48;5;31m▄\u001B[38;5;67;48;5;67m▄\u001B[38;5;67;48;5;73m▄\u001B[38;5;31;48;5;67m▄\u001B[38;5;67;48;5;73m▄\u001B[38;5;73;48;5;67m▄\u001B[38;5;66;48;5;24m▄\u001B[38;5;23;48;5;23m▄▄▄▄▄▄\u001B[38;5;23;48;5;236m▄\u001B[38;5;236;48;5;235m▄\u001B[38;5;234;48;5;235m▄\u001B[38;5;235;48;5;235m▄▄\u001B[38;5;235;48;5;234m▄▄\u001B[38;5;234;48;5;234m▄\u001B[38;5;235;48;5;234m▄▄\u001B[38;5;235;48;5;235m▄\u001B[38;5;235;48;5;237m▄\u001B[38;5;238;48;5;238m▄\u001B[38;5;239;48;5;238m▄\u001B[38;5;238;48;5;238m▄\u001B[m"
                    };

            Collections.addAll(contents, noSavedRunsArt);

            contents.add("");
            contents.add(
                    "\u001B[1;38;5;117mHmm... It looks lonely here. No saved runs found.\u001B[0m");
            contents.add("\u001B[38;5;81mMaybe your journey is just waiting to begin.\u001B[0m");
            contents.add(
                    "\u001B[38;5;178mStart a new run and I'll disappear, leaving only your progress"
                            + " behind...\u001B[0m");

            contents.add("\u001B[0m"); // Reset to avoid color bleeding

            printBorderedContent("NO SAVED RUNS", contents);
            System.out.println("\n");
        }
    }

    public int getRunNumber() {
        return runNumber;
    }

    public void setRunNumber(int runNumber) {
        RunSelectScreen.runNumber = runNumber;
    }

    public void displayCurrentChosenRun() {

        List<String> optionLines = new ArrayList<>();

        // Replace this with the actual split ANSI card art
        String[] cardArt;
        String cardDesc = "";
        if (storage.getValue(runNumber - 1, Storage.DECK_INDEX)
                        .charAt(storage.getValue(runNumber - 1, Storage.DECK_INDEX).length() - 1)
                == ']') {
            cardArt =
                    Storage.fromStorageKey(
                                    storage.getValue(runNumber - 1, 8)
                                            .substring(
                                                    0,
                                                    storage.getValue(
                                                                            runNumber - 1,
                                                                            Storage.DECK_INDEX)
                                                                    .length()
                                                            - 1))
                            .getArtLines();
            cardDesc =
                    Storage.fromStorageKey(
                                    storage.getValue(runNumber - 1, Storage.DECK_INDEX)
                                            .substring(
                                                    0,
                                                    storage.getValue(
                                                                            runNumber - 1,
                                                                            Storage.DECK_INDEX)
                                                                    .length()
                                                            - 1))
                            .getDeckName();
        } else {
            cardArt =
                    Storage.fromStorageKey(storage.getValue(runNumber - 1, Storage.DECK_INDEX))
                            .getArtLines();
            cardDesc =
                    Storage.fromStorageKey(storage.getValue(runNumber - 1, Storage.DECK_INDEX))
                            .getDeckName();
        }

        int screenSize = 11;
        String deckLabel = "\u001B[1;4mDECK\u001B[0m"; // Bold + Underlined
        String visibleCardLine = stripAnsi(cardArt[0]);
        int labelPadding = 78 + (visibleCardLine.length() - "DECK".length()) / 2;
        String paddedDeckLabel = String.format("%" + labelPadding + "s", deckLabel);
        optionLines.add(paddedDeckLabel);
        optionLines.add("");

        // Italicized deck name
        int padding = 81;
        if (Storage.DeckFromKey(storage.getValue(runNumber - 1, Storage.DECK_INDEX))
                        == DeckType.ABANDONED
                || Storage.DeckFromKey(storage.getValue(runNumber - 1, Storage.DECK_INDEX))
                        == DeckType.CHECKERED) {
            padding = 90;
        }
        String italicDeckName = "\u001B[3m" + cardDesc + "\u001B[0m";
        visibleCardLine = stripAnsi(cardArt[0]);
        int deckNamePadding = padding + (visibleCardLine.length() - cardDesc.length()) / 2;
        String paddedDeckName = String.format("%" + deckNamePadding + "s", italicDeckName);

        String handValue = storage.getValue(runNumber - 1, Storage.HAND_INDEX);
        String discardValue = storage.getValue(runNumber - 1, Storage.DISCARD_INDEX);

        String handsOutput = handValue.equals("-1") ? "NA" : handValue;
        String discardsOutput = discardValue.equals("-1") ? "NA" : discardValue;

        for (int i = 0; i < screenSize - 1; i++) {
            String leftText = "";
            if (i == 0)
                leftText = "Round: " + storage.getValue(runNumber - 1, Storage.ROUND_NUMBER_INDEX);
            if (i == 1)
                leftText =
                        "Round Score: "
                                + storage.getValue(runNumber - 1, Storage.ROUND_SCORE_INDEX);
            else if (i == 2)
                leftText =
                        "Hands: "
                                + (handValue.equals("-1") ? "NA" : handValue)
                                + " | Discards: "
                                + (discardValue.equals("-1") ? "NA" : discardValue);
            else if (i == 3) leftText = "------------------------";
            else if (i == 4)
                leftText = "Ante: " + storage.getValue(runNumber - 1, Storage.ANTE_NUMBER_INDEX);
            else if (i == 5)
                leftText = "Blind: " + storage.getValue(runNumber - 1, Storage.BLIND_INDEX);
            else if (i == 6) leftText = "------------------------";
            else if (i == 7)
                leftText =
                        "Wins: "
                                + storage.getValue(runNumber - 1, Storage.WINS_INDEX)
                                + " | Losses: "
                                + storage.getValue(runNumber - 1, Storage.LOSSES_INDEX);

            String rightAnsi = (i < cardArt.length) ? cardArt[i] : "";
            // Pad leftText to align with ANSI
            String paddedLeft = String.format("%-70s", leftText);

            optionLines.add(paddedLeft + rightAnsi);
        }

        optionLines.add(paddedDeckName);

        printBorderedContent("RUN #" + runNumber, optionLines);
        System.out.println("\n");
    }

    String stripAnsi(String input) {
        return input.replaceAll("\\u001B\\[[;\\d]*m", "");
    }
}
