package org.pcgen.editor.builder;

import java.awt.*;

public class GridBagConstraintsBuilder {
    private GridBagConstraints constraints;

    public static GridBagConstraintsBuilder getBuilder(){
        return new GridBagConstraintsBuilder();
    }

    private GridBagConstraintsBuilder(){
        constraints = new GridBagConstraints();
    }

    public GridBagConstraintsBuilder withGridX(final int gridX){
        constraints.gridx = gridX;
        return this;
    }

    public GridBagConstraintsBuilder withGridY(final int gridY){
        constraints.gridy = gridY;
        return this;
    }

    public GridBagConstraintsBuilder withIPadX(final int iPadX){
        constraints.ipadx = iPadX;
        return this;
    }

    public GridBagConstraintsBuilder withIPadY(final int iPadY){
        constraints.ipady = iPadY;
        return this;
    }

    public GridBagConstraintsBuilder withGridWidth(final int gridWidth){
        constraints.gridwidth = gridWidth;
        return this;
    }

    public GridBagConstraintsBuilder withGridHeight(final int gridHeight){
        constraints.gridheight = gridHeight;
        return this;
    }

    public GridBagConstraintsBuilder withWeightX(final double weightX){
        constraints.weightx = weightX;
        return this;
    }

    public GridBagConstraintsBuilder withWeightY(final double weightY){
        constraints.weighty = weightY;
        return this;
    }

    public GridBagConstraintsBuilder withAnchor(final Anchor anchor){
        constraints.anchor = anchor.getValue();
        return this;
    }

    public GridBagConstraintsBuilder withFill(final Fill fill){
        constraints.fill = fill.getValue();
        return this;
    }

    public GridBagConstraintsBuilder withInsets(final Insets insets){
        constraints.insets = insets;
        return this;
    }

    public GridBagConstraints build(){
        return constraints;
    }

    public enum Fill{
        NONE(GridBagConstraints.NONE), HORIZONTAL(GridBagConstraints.HORIZONTAL), VERTICAL(GridBagConstraints.VERTICAL), BOTH(GridBagConstraints.BOTH);

        private final int value;
        Fill(int i) {
            value = i;
        }

        public int getValue() {
            return value;
        }
    }

    public enum Anchor {
        CENTER(GridBagConstraints.CENTER), NORTH(GridBagConstraints.NORTH), NORTHEAST(GridBagConstraints.NORTHEAST),
        EAST(GridBagConstraints.EAST), SOUTHEAST(GridBagConstraints.SOUTHEAST), SOUTH(GridBagConstraints.SOUTH),
        SOUTHWEST(GridBagConstraints.SOUTHWEST), WEST(GridBagConstraints.WEST), NORTHWEST(GridBagConstraints.NORTHWEST),
        PAGE_START(GridBagConstraints.PAGE_START), PAGE_END(GridBagConstraints.PAGE_END),
        LINE_START(GridBagConstraints.LINE_START), LINE_END(GridBagConstraints.LINE_END),
        FIRST_LINE_START(GridBagConstraints.FIRST_LINE_START), FIRST_LINE_END(GridBagConstraints.FIRST_LINE_END),
        LAST_LINE_START(GridBagConstraints.LAST_LINE_START), LAST_LINE_END(GridBagConstraints.LAST_LINE_END),
        BASELINE(GridBagConstraints.BASELINE), BASELINE_LEADING(GridBagConstraints.BASELINE_LEADING),
        BASELINE_TRAILING(GridBagConstraints.BASELINE_TRAILING), ABOVE_BASELINE(GridBagConstraints.ABOVE_BASELINE),
        ABOVE_BASELINE_LEADING(GridBagConstraints.ABOVE_BASELINE_LEADING),
        ABOVE_BASELINE_TRAILING(GridBagConstraints.ABOVE_BASELINE_TRAILING),
        BELOW_BASELINE(GridBagConstraints.BELOW_BASELINE),
        BELOW_BASELINE_LEADING(GridBagConstraints.BELOW_BASELINE_LEADING),
        BELOW_BASELINE_TRAILING(GridBagConstraints.BELOW_BASELINE_TRAILING);

        private final int value;

        Anchor(int i) {
            value = i;
        }

        public int getValue() {
            return value;
        }
    }
}
