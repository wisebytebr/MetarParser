package io.github.mivek.command.remark;

import io.github.mivek.internationalization.Messages;
import io.github.mivek.utils.Regex;

import java.util.regex.Pattern;

/**
 * @author mivek
 */
public final class SnowPelletsCommand implements Command {
    /** Snow pellets intensity. */
    private static final Pattern SNOW_PELLETS_INTENSITY = Pattern.compile("^GS (LGT|MOD|HVY)");

    /** The message instance. */
    private final Messages messages;

    /**
     * Default constructor.
     */
    SnowPelletsCommand() {
        messages = Messages.getInstance();
    }

    @Override
    public String execute(final String pRemark, final StringBuilder pStringBuilder) {
        String[] intensityParts = Regex.pregMatch(SNOW_PELLETS_INTENSITY, pRemark);
        pStringBuilder.append(messages.getString("Remark.Snow.Pellets", messages.getString("Remark." + intensityParts[1]))).append(" ");
        return pRemark.replaceFirst(SNOW_PELLETS_INTENSITY.pattern(), "").trim();
    }

    @Override
    public boolean canParse(final String pInput) {
        return Regex.find(SNOW_PELLETS_INTENSITY, pInput);
    }
}
