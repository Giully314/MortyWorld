package javagame.items;

import javagame.graphics.Assets;

public class TreeItem extends Item
{
    public TreeItem()
    {
        super(Item.DEFAULT_ITEM_WIDTH, Item.DEFAULT_ITEM_HEIGHT, null, Assets.tree, "Tree", 0);
    }
}