package com.alxnns1.mobhunter

import com.alxnns1.mobhunter.entity.MHEntity
import net.minecraft.entity.MobEntity

fun <T> T.getMHScale(): Float where T : MHEntity, T : MobEntity = this.dataManager[this.getScaleKey()]
