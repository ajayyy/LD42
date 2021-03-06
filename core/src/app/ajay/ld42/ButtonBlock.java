package app.ajay.ld42;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Color;

public class ButtonBlock extends Block{

	public ButtonBlock(int x, int y) {
		super(x, y);
		
		color = Color.YELLOW;
		
		type = 2;
		
		open = true;
	}
	
	public void update(Level level, Main main) {
		super.update(level, main);
		
		if (level.getBlock(level.player.x, level.player.y) == this) {
			for (Block block : new ArrayList<Block>(level.blocks)) {
				if (block.type == 4) {
					Block newBlock = new OpenBlock(block.x, block.y);
					
					level.blocks.remove(block);
					level.blocks.add(newBlock);
				}
			}
			
			Block newBlock = new OpenBlock(x, y);
			
			int direction = 0;
			if (level.player.turnQueueDirection == 0) {
				direction = 1;
			} else if (level.player.turnQueueDirection == 1) {
				direction = 0;
			} else if (level.player.turnQueueDirection == 2) {
				direction = 3;
			} else if (level.player.turnQueueDirection == 3) {
				direction = 2;
			}
			
			destroy(level, main, direction);
			
			level.blocks.add(0, newBlock);
		}
	}
}
