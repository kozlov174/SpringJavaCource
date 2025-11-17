package com.example.labwork5.service;

import com.example.labwork5.model.Positions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class QuarterBonusServiceImplTest {

    @Test
    void calculate() {
        Positions position = Positions.TPM;
        double bonus = 2.0;

        double result = new QuarterBonusServiceImpl().calculate(position, bonus);

        double expected = 96000;
        assertThat(result).isEqualTo(expected);
    }
}