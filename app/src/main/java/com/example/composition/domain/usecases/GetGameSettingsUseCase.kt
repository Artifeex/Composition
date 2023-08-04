package com.example.composition.domain.usecases

import com.example.composition.domain.entity.GameSettings
import com.example.composition.domain.repository.GameRepository
import com.example.composition.domain.entity.Level

class GetGameSettingsUseCase(
    val repository: GameRepository
) {

    operator fun invoke(level: Level): GameSettings {
        return repository.getGameSettings(level)
    }
}