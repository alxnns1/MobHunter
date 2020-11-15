package com.alxnns1.mobhunter.init

enum class SharpnessLevel(val colour: Int, val multiplier: Double) {
	RED(0xff0000, 0.5),
	ORANGE(0xff8000, 0.75),
	YELLOW(0xffff00, 1.0),
	GREEN(0x00ff00, 1.05),
	BLUE(0x0000ff, 1.2),
	WHITE(0xffffff, 1.32),
	PURPLE(0xff00ff, 1.39)
}