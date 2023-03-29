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