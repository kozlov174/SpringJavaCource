package com.example.labwork5.service;

import com.example.labwork5.model.Positions;
import org.springframework.stereotype.Service;
import java.time.Year;

@Service
public class AnnualBonusServiceImpl implements AnnualBonusService {
    @Override
    public double calculate(Positions positions, double salary, double bonus, int workDays) {
        int daysInYear = Year.now().isLeap() ? 366 : 365;
        return salary *  bonus * 365 * positions.getPositionCoefficient() / daysInYear;
    }
}
