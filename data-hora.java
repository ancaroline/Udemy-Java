// DATA-HORA
/*
Conceitos importantes:
	- Data-[hora] local:
		A hora é opcional e armazenada sem fuso horário.
		ano-mês-dia-[hora]

	- Data-hora global:
		Com fuso horário.
		ano-mês-dia-hora

	- Duração:
		Tempo decorrido entre duas data-horas.

	Quando usar? 
	- Data-[hora] local: Quando o momento exato não interessa a pessoas de outro fuso horário.
	Uso comum: sistemas de região única, Excel.

	- Data-hora global: Quando o momento exato interessa a pessoas de outro fuso horário.
	Uso comum: sistemas multi-região, web.
*/
// TIMEZONE
/*
	- GMT - GREENWICH MEAN TIME
		Horário de Londres
		Horário do padrão UTC - Coordinated Universal Time
		Também chamado de "Z time", ou Zulu time

	- Outros fuso horário são relativo ao GMT/UTC:
		São Paulo: GMT-3
		Manaus: GMT-4
		Portugal: GMT+!

	- Muitas linguagens/tecnologias usam nomes para as timezones:
		"US/Pacific"
		"America/Sao_Paulo"
		etc.
*/
// PADRÃO ISO 8601
/*
	Data-[hora] local:
		2022-07-21
		2022-07-21T14:52
		2022-07-21T14:52:09
		2022-07-21T14:52:09.4073

	Data-hora global:
		2022-07-232T14:52:09Z
		2022-07-232T14:52:09.254935Z
		2022-07-232T14:52:09-03:00
*/
// OPERAÇÕES IMPORTANTES COM DATA-HORA
/*
	- Instanciação:
		- (agora) -> data-hora
		- Texto ISO 8601 -> data-hora  # converter o texto em um objeto data-hora
		- Texto formato custommizado -> data-hora
		- dia, mês, ano, [horário] -> data-hora local

	- Formatação
		- data-hora -> Texto ISO 8601
		- data-hora -> Formato customizado

	- Obter dados de uma data-hora local
		- Data-hora local -> dia, mês, ano, horário

	- Converter data-hora global para local
		- Data-hora global, timezone (sistema local) -> Data-hora local

	- Cálculos com data-hora
		- Data-hora +/- tempo -> Data-hora
		- Data-hora 1, Data-hora 2 -> Duração
*/
// PRINCIPAIS TIPOS JAVA
/*
Data-hora local
	LocalDate
	LocalDateTime

Data-hora global
	Instant

Duração
	Duration

Outros
	Zoneld
	ChronoUnit
*/
// Instanciação
package app;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Program {
	public static void main(String[] args) {

		// formatar datas customizadas
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm");


		// instanciar uma data apartir do agora
		LocalDate d01 = LocalDate.now();
		LocalDateTime d02 = LocalDateTime.now();
		Instant d03 = Instant.now();

		// instanciar uma data apartir do texto ISO
		LocalDate d04 = LocalDate.parse("2023-04-02");
		LocalDateTime d05 = LocalDateTime.parse("2023-04-02T01:30:12");
		Instant d06 = Instant.parse("2023-04-02T01:30:12Z");
		// Como especificar um horário local e converter em zulu
		Instant d07 = Instant.parse("2023-04-02T01:30:12-3:00");

		// Instanciar uma data apartir do texto customizado
		LocalDate d08 = LocalDate.parse("20/07/2023", fmt1);
		// ou
		LocalDate d08 = LocalDate.parse("20/07/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		LocalDateTime d09 = LocalDateTime.parse("20/07/2023 01:30", fmt2);

		// Instanciar dia, mês, ano ...
		LocalDate d10 = LocalDate.of(2023, 7, 20);
		LocalDateTime d11 = LocalDateTime.of(2023, 7, 20, 1, 30);

		System.out.println(d01);
		// 2023-03-29
		System.out.println(d02);
		// 2023-03-29T09:11:50.876987321
		System.out.println(d03);
		// 2023-03-29T12:11:50.876987321Z
		System.out.println(d04);
		// 2023-04-02
		System.out.println(d05);
		// 2023-04-02T01:30:12
		System.out.println(d06);
		// 2023-04-02T01:30:12Z
		System.out.println(d07);
		// 2023-04-02T04:30:12Z
		System.out.println(d08);
		// 2023-07-20
		System.out.println(d09);
		// 2023-07-20T01:30
		System.out.println(d10);
		// 2023-07-20
		System.out.println(d11);
		// 2023-07-20T01:30

	}
}

// Formatação
package app;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Program {
	public static void main(String[] args) {

		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());
		DateTimeFormatter fmt4 = DateTimeFormatter.ISO_DATE_TIME;  // para localDate
		DateTimeFormatter fmt5 = DateTimeFormatter.ISO_INSTANT;  // para instant


		LocalDate d01 = LocalDate.parse("2023-04-02");
		LocalDateTime d02 = LocalDateTime.parse("2023-04-02T01:30:12");
		Instant d03 = Instant.parse("2023-04-02T01:30:12Z");

		System.out.println(d01);
		// 2023-04-02
		System.out.println(d01.format(fmt1));
		// 02/04/2023
		System.out.println(fmt1.format(d01));
		// 02/04/2023


		System.out.println(d02);
		// 2023-04-02T01:30:12
		System.out.println(d02.format(fmt2));
		// 02/04/2023 01:30
		System.out.println(fmt2.format(d02));
		// 02/04/2023 01:30
		System.out.println(fmt4.format(d02));
		// 2023-04-02T01:30:12


		System.out.println(fmt3.format(d03));
		// 01/04/2023 22:30
	}
}

// Convertendo data-hora global para local
// Data hora global, timezone -> data-hora local
/*
ZoneId.getAvailableZoneIds() -> irá retornar uma coleção com os nomes dos fusos horários customizados.
*/
package app;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;

public class Program {
	public static void main(String[] args) {

		LocalDate d01 = LocalDate.parse("2023-04-02");
		LocalDateTime d02 = LocalDateTime.parse("2023-04-02T01:30:12");
		Instant d03 = Instant.parse("2023-04-02T01:30:12Z");

		// para cada string s dentro da coleção, eu irei mostrar
		for (String s : ZoneId.getAvailableZoneIds()) {
			System.out.println(s);
		}

		// converter Instant para LocalDate
		LocalDate r1 = LocalDate.ofInstant(d03, ZoneId.systemDefault());  // considerando o fuso horário do meu pc
		System.out.println("r1 = " + r1);
		// r1 = 2023-04-01
		LocalDate r2 = LocalDate.ofInstant(d03, ZoneId.of("Portugal"));  // considerando o fuso horário de portugal
		
		// converter Instant para LocalDateTime
		LocalDateTime r3 = LocalDateTime.ofInstant(d03, ZoneId.systemDefault());
		System.out.println("r3 = " + r2);
		// r3 = 2023-04-01T22:30:26


		// Como pegar um dia de uma data local
		System.out.println("d01 dia = " + d01.getDayOfMonth());
		System.out.println("d01 mês = " + d01.getMonthValue());
		System.out.println("d01 ano = " + d01.getYear());

		// Como pegar um dia de uma data local time
		System.out.println("d02 hora = " + d02.getHour());
		System.out.println("d02 minuto = " + d02.getMinute());
	}
}

// Cálculos com Data-Hora
package app;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Duration;

public class Program {
	public static void main(String[] args) {

		LocalDate d01 = LocalDate.parse("2023-04-02");
		LocalDateTime d02 = LocalDateTime.parse("2023-04-02T01:30:12");
		Instant d03 = Instant.parse("2023-04-02T01:30:12Z");

		// semana anterior
		LocalDate pastWeekLocalDate = d01.minusDays(7);
		// semana posterior
		LocalDate nextWeekLocalDate = d01.plusDays(7);


		LocalDateTime pastWeekLocalDateTime = d02.minusDays(7);
		LocalDateTime nextWeekLocalDateTime = d02.plusDays(7);

		Instant pastWeekInstant = d03.minus(7, ChronoUnit.DAYS);
		Instant nextWeekInstant = d03.plus(7, ChronoUnit.DAYS);

		// Duração
		Duration t1 = Duration.between(pastWeekLocalDateTime, d02);
		System.out.println("t1 dias = " + t1.toDays());
		// t1 dias = 7

		// Não tem como calcular com LocalDate, é preciso converter em LocalDateTime
		// Tanto o atTime quanto o atStartOfDay convertem para LocalDateTime
		Duration t2 = Duration.between(pastWeekLocalDate.atTime(0, 0), d01.atStartOfDay());
		System.out.println("t2 dias = " + t2.toDays());
		// t2 dias = 7

		Duration t3 = Duration.between(pastWeekInstant, d03);
		System.out.println("t3 dias = " + t3.toDays());
		// t3 dias = 7

		// Se calcular com data maior na frente, o valor ficará negativo.
	}
}
