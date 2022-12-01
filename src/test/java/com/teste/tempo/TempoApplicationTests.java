package com.teste.tempo;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.format.annotation.DateTimeFormat;

@SpringBootTest
class TempoApplicationTests {


	@Test
	void contextLoads() {
	}

	@Test
	void teste1() {

		LocalDate natal = LocalDate.of(2022, Month.DECEMBER, 25);
		LocalDateTime algumMOmento = LocalDateTime.of(2022, 12, 25, 12, 0);

		System.out.println(algumMOmento.getDayOfMonth()); // dia
		System.out.println(algumMOmento.getYear()); // ano
		System.out.println(algumMOmento.getMonth()); // Nome do mês
		System.out.println(algumMOmento.getHour()); // hora
		System.out.println(algumMOmento.getDayOfWeek()); // nome da semana
		System.out.println(algumMOmento.getMonthValue()); // mês em número

		System.out.println(algumMOmento.get(ChronoField.DAY_OF_WEEK));
		System.out.println(algumMOmento.get(ChronoField.DAY_OF_MONTH));

	}


	@Test
	void teste2() {

		// Modificar uma data
		LocalDate d = LocalDate.of(2022, 1, 1);

		LocalDate d2 = d.withMonth(10).withYear(2021);

		// System.out.println(d);
		// System.out.println(d2);

		//Soma
		LocalDate teste = d.plusDays(30).plusMonths(9).plusYears(1);
		System.out.println(teste);

		//Diminuir
		LocalDate teste1 = d.minusYears(10);
		System.out.println(teste1);

		LocalDate teste2 = d.minus(5, ChronoUnit.YEARS);
		System.out.println(teste2);
	}

	@Test
	void teste3() {
		// Conversões
		LocalDateTime ldt = LocalDateTime.now();

		LocalDate ld = ldt.toLocalDate();
		LocalTime lt = ldt.toLocalTime();

		LocalDateTime ldt2 = ld.atTime(lt);
		LocalDateTime ldt3 = lt.atDate(ld);
	}

	@Test
	void teste4() {

		Date d = new Date();
		Instant i = d.toInstant();
		LocalDateTime ldt = LocalDateTime.ofInstant(i, ZoneId.systemDefault());
		//System.out.println(ldt);

		Calendar c = Calendar.getInstance();
		Instant i2 = c.toInstant();
		LocalDateTime ldt2 = LocalDateTime.ofInstant(i, ZoneId.systemDefault());
		//System.out.println(ldt2);

		// caminho ao contrario
		Instant instant = ldt.toInstant(ZoneOffset.UTC);
		Date d2 = Date.from(instant);
		Calendar c2 = Calendar.getInstance();
		c2.setTime(d2);

		System.out.println(c2.getTime());
	}

	@Test
	void teste5() {
		LocalDateTime ldt = LocalDateTime.now();
		Instant i = Instant.now();
		Duration cemegundos = Duration.ofSeconds(100);
		Instant i2 = i.plus(cemegundos);
		//System.out.println(i);
		//System.out.println(i2);
		//System.out.println(i);
		//System.out.println(ldt);

		Instant teste1 = Instant.EPOCH;
		Instant teste2 = Instant.now();
		long diferencaEmSegundos = Duration.between(teste1, teste2).getSeconds();

		LocalDate aniversario = LocalDate.of(1983, 10, 2);
		LocalDate hoje = LocalDate.now();

		System.out.println(ChronoUnit.YEARS.between(aniversario, hoje));
		System.out.println(ChronoUnit.MONTHS.between(aniversario, hoje));
		System.out.println(ChronoUnit.DAYS.between(aniversario, hoje));

		Period tempoDeVida = Period.between(aniversario, hoje);

		System.out.print("Anos:"+tempoDeVida.getYears());
		System.out.print("-Meses:"+tempoDeVida.getMonths());
		System.out.print("-Dias:"+tempoDeVida.getDays());
	}

	@Test
	void teste6() {
		// data para string
		LocalDateTime agora = LocalDateTime.now();
		DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(formatar.format(agora));
		System.out.println(agora.format(formatar));

		//caminho ao contrario
		LocalDate ldt = LocalDate.parse("02/10/1983", formatar);
		System.out.println(ldt);
	}

	@Test
	void teste() {

		MonthDay day1 = MonthDay.of(1, 1); //01/jan
		MonthDay day2 = MonthDay.of(1, 2); //02/jan

		System.out.println(day1.isAfter(day2)); //false
		System.out.println(day1.isBefore(day2)); //tru
	}
}
