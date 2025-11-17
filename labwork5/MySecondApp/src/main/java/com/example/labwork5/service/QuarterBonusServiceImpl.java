package com.example.labwork5.service;

import com.example.labwork5.model.Positions;
import org.springframework.stereotype.Service;

@Service
public class QuarterBonusServiceImpl implements QuarterlyBonusService {

    @Override
    public double calculate(Positions position, double bonus) {
        if (!position.isManager()) {
            throw new IllegalArgumentException("Квартальная премия доступна только для управленцев");
        }

        return bonus * 90 * position.getPositionCoefficient() * 10000 / 60;
    }
}
