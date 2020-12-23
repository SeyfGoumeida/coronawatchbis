package com.efrei.CoronaWatch;

import com.efrei.CoronaWatch.Entities.*;
import com.efrei.CoronaWatch.Repositories.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@SpringBootApplication
public class CoronaWatchApplication {
	@Autowired
	PasswordEncoder encoder;

	public static void main(String[] args) {
		SpringApplication.run(CoronaWatchApplication.class, args);
	}

	/*public static void writeJsonSimple() throws Exception {
		JSONObject sampleObject = new JSONObject();
		sampleObject.put("name", "Stackabuser");
		sampleObject.put("age", 35);

		JSONArray messages = new JSONArray();
		messages.add("Hey!");
		messages.add("What's up?!");

		sampleObject.put("messages", messages);
		Files.write(Paths.get("C:\\Users\\SEYF_GOUMEIDA\\Documents\\GitHub\\coronawatchbis\\src\\main\\java\\com\\efrei\\CoronaWatch\\DataBDD\\test.json"), sampleObject.toJSONString().getBytes());
	}*/
	public static void readJsonRegions(String Country, Country c, CountryRepository countryRepository,RegionRepository regionRepository,RegionsStatisticsRepository regionsStatisticsRepository) {
		JSONParser parser = new JSONParser();
		try {

			Object obj = parser.parse( "{\n" +
								"  \"Algeria\":[\n" +
								"    \"Algiers\",\n" +
								"    \"Souk Ahras\",\n" +
								"    \"Annaba\",\n" +
								"    \"Batna City\",\n" +
								"    \"Sétif\",\n" +
								"    \"Béjaïa\",\n" +
								"    \"Bordj Bou Arreridj\",\n" +
								"    \"Bordj\",\n" +
								"    \"Tiaret\",\n" +
								"    \"Oran\",\n" +
								"    \"Saida\",\n" +
								"    \"Tlemcen\",\n" +
								"    \"Oued Smar\",\n" +
								"    \"Tizi\",\n" +
								"    \"Tizi Ouzou\",\n" +
								"    \"Azazga\",\n" +
								"    \"Blida\",\n" +
								"    \"Rouiba\",\n" +
								"    \"Hussein Dey\",\n" +
								"    \"Draria\",\n" +
								"    \"Tissemsilt\",\n" +
								"    \"El Tarf\",\n" +
								"    \"Constantine\",\n" +
								"    \"Illizi\",\n" +
								"    \"Laghouat\",\n" +
								"    \"Kouba\",\n" +
								"    \"Jijel\",\n" +
								"    \"Ghardaïa\",\n" +
								"    \"Bougara\",\n" +
								"    \"Chlef\",\n" +
								"    \"Cheraga\",\n" +
								"    \"Ouargla\",\n" +
								"    \"Relizane\",\n" +
								"    \"Djelfa\",\n" +
								"    \"Béchar\",\n" +
								"    \"Tamanghasset\"\n" +
								"  ],\n" +
								"  \"Republic of Korea\":[\n" +
								"    \"Seoul\",\n" +
								"    \"Incheon\",\n" +
								"    \"Paju\",\n" +
								"    \"Cheonan\",\n" +
								"    \"Yongin\",\n" +
								"    \"Kwanghui-dong\",\n" +
								"    \"Pon-dong\",\n" +
								"    \"Gwangju\",\n" +
								"    \"Gwangmyeong\",\n" +
								"    \"Tang-ni\",\n" +
								"    \"Busan\",\n" +
								"    \"Seongnam-si\",\n" +
								"    \"Suwon-si\",\n" +
								"    \"Namyang\",\n" +
								"    \"Namyangju\",\n" +
								"    \"Jeju-si\",\n" +
								"    \"Ulsan\",\n" +
								"    \"Osan\"\n" +
								"  ],\n" +
								"  \"Hong Kong\":[\n" +
								"    \"Shuen Wan\",\n" +
								"    \"Central District\",\n" +
								"    \"Hung Hom\",\n" +
								"    \"Kowloon\",\n" +
								"    \"Quarry Bay\",\n" +
								"    \"Ngau Tau Kok\",\n" +
								"    \"Ying Pun\",\n" +
								"    \"Repulse Bay\",\n" +
								"    \"Causeway Bay\",\n" +
								"    \"Tseung Kwan O\",\n" +
								"    \"Tai Kok Tsui\",\n" +
								"    \"Tai Wai\",\n" +
								"    \"Ma On Shan Tsuen\",\n" +
								"    \"To Kwa Wan\",\n" +
								"    \"Wong Tai Sin\",\n" +
								"    \"Tuen Mun San Hui\",\n" +
								"    \"Ma Yau Tong\"\n" +
								"  ],\n" +
								"  \"Philippines\":[\n" +
								"    \"Manila\",\n" +
								"    \"Ayala\",\n" +
								"    \"Bayan\",\n" +
								"    \"Roosevelt\",\n" +
								"    \"Blumentritt\",\n" +
								"    \"Cardona\",\n" +
								"    \"Pasong Tamo\",\n" +
								"    \"Buting\",\n" +
								"    \"Lipa City\",\n" +
								"    \"Taguig\",\n" +
								"    \"Baguio City\",\n" +
								"    \"San Pablo City\",\n" +
								"    \"San Mateo\",\n" +
								"    \"Rizal\",\n" +
								"    \"Naguilian\",\n" +
								"    \"San Vicente\",\n" +
								"    \"Sto Nino\",\n" +
								"    \"Province of Laguna\",\n" +
								"    \"Quezon\"\n" +
								"  ],\n" +
								"  \"France\":[\n" +
								"    \"Paris\",\n" +
								"    \"Lyon\",\n" +
								"    \"Marseille\",\n" +
								"    \"Toulouse\",\n" +
								"    \"Nice\",\n" +
								"    \"Nantes\",\n" +
								"    \"Montpellier\",\n" +
								"    \"Bordeaux\",\n" +
								"    \"Strasbourg\",\n" +
								"    \"Lille\",\n" +
								"    \"Reims\",\n" +
								"    \"Toulon\"\n" +
								"  ],\n" +
								"  \"Germany\":[\n" +
								"    \"Langgons\",\n" +
								"    \"Holle\",\n" +
								"    \"Tespe\",\n" +
								"    \"Walsrode\",\n" +
								"    \"Salzgitter\",\n" +
								"    \"Bad Sassendorf\",\n" +
								"    \"Vienenburg\",\n" +
								"    \"Rosdorf\",\n" +
								"    \"Einbeck\",\n" +
								"    \"Markersbach\",\n" +
								"    \"Uetersen\",\n" +
								"    \"Lauenburg\",\n" +
								"    \"Neustadt in Holstein\",\n" +
								"    \"Heiligenhafen\",\n" +
								"    \"Lutjenburg\",\n" +
								"    \"Quickborn\",\n" +
								"    \"Tangstedt\",\n" +
								"    \"Tangstedt\",\n" +
								"    \"Negast\",\n" +
								"    \"Langendorf\",\n" +
								"    \"Stockelsdorf\",\n" +
								"    \"Prangendorf\",\n" +
								"    \"Lagerdorf\",\n" +
								"    \"Jersbek\",\n" +
								"    \"Lutjensee\",\n" +
								"    \"Hoisdorf\",\n" +
								"    \"Tremsbuttel\",\n" +
								"    \"Nahe\",\n" +
								"    \"Itzstedt\",\n" +
								"    \"Dabelow\",\n" +
								"    \"Monkeberg\",\n" +
								"    \"Altenholz\",\n" +
								"    \"Buxtehude\",\n" +
								"    \"Escheburg\",\n" +
								"    \"Aurachtal\",\n" +
								"    \"Frankenwinheim\",\n" +
								"    \"Armstorf\"\n" +
								"  ],\n" +
								"  \"Italy\":[\n" +
								"    \"Ferrara\",\n" +
								"    \"Sarnano\",\n" +
								"    \"Rome\",\n" +
								"    \"Gabicce Mare\",\n" +
								"    \"Sasso Marconi\",\n" +
								"    \"Sarno\",\n" +
								"    \"Collegno\",\n" +
								"    \"La Via\",\n" +
								"    \"Radda in Chianti\",\n" +
								"    \"Riale\"\n" +
								"  ],\n" +
								"  \"United Kingdom\":[\n" +
								"    \"Pershore\",\n" +
								"    \"Rowley Regis\",\n" +
								"    \"Stroud\",\n" +
								"    \"Birmingham\",\n" +
								"    \"Worcester\",\n" +
								"    \"Smethwick\",\n" +
								"    \"Alcester\",\n" +
								"    \"Dudley\",\n" +
								"    \"Ottershaw\",\n" +
								"    \"Petworth\",\n" +
								"    \"Bedminster\",\n" +
								"    \"Hitcham\",\n" +
								"    \"Westleigh\",\n" +
								"    \"West Langdon\",\n" +
								"    \"Handcross\",\n" +
								"    \"Blackheath\",\n" +
								"    \"Alrewas\",\n" +
								"    \"Clapham\",\n" +
								"    \"Harby\"\n" +
								"  ],\n" +
								"  \"United Arab Emirates\":[\n" +
								"    \"Abu Dhabi\",\n" +
								"    \"Abu al Abyad\",\n" +
								"    \"Adhen\",\n" +
								"    \"Ajman\",\n" +
								"    \"Al Ain\",\n" +
								"    \"Al Ajban\",\n" +
								"    \"Al Aryam\",\n" +
								"    \"Al Awir\",\n" +
								"    \"Al Badiyah\",\n" +
								"    \"Al Bataeh\",\n" +
								"    \"Al Bithnah\",\n" +
								"    \"Al Faqa\",\n" +
								"    \"Al Halah\",\n" +
								"    \"Al Hamraniyah\",\n" +
								"    \"Al Hamriyah\",\n" +
								"    \"Al Jazirah Al Hamra\",\n" +
								"    \"Al Jeer\",\n" +
								"    \"Al Khawaneej\",\n" +
								"    \"Al Lisaili\",\n" +
								"    \"Al Madam\",\n" +
								"    \"Al Manama\",\n" +
								"    \"Al Mirfa\",\n" +
								"    \"Al Qor\",\n" +
								"    \"Al Qusaidat\",\n" +
								"    \"Al Rafaah\",\n" +
								"    \"Al Rashidya\",\n" +
								"    \"Al Shuwaib\",\n" +
								"    \"Al Yahar\",\n" +
								"    \"Ar-Rams\",\n" +
								"    \"Asimah\",\n" +
								"    \"Dadna\",\n" +
								"    \"Dalma\",\n" +
								"    \"Dhaid\",\n" +
								"    \"Dibba Al-Fujairah\",\n" +
								"    \"Dibba Al-Hisn\",\n" +
								"    \"Digdaga\",\n" +
								"    \"Dubai\",\n" +
								"    \"Falaj Al Mualla\",\n" +
								"    \"Fujairah\",\n" +
								"    \"Ghalilah\",\n" +
								"    \"Ghayathi\",\n" +
								"    \"Ghub\",\n" +
								"    \"Habshan\",\n" +
								"    \"Hatta\",\n" +
								"    \"Huwaylat\",\n" +
								"    \"Jebel Ali\",\n" +
								"    \"Kalba\",\n" +
								"    \"Khatt\",\n" +
								"    \"Khor Fakkan\",\n" +
								"    \"Khor Khwair\",\n" +
								"    \"Lahbab\",\n" +
								"    \"Liwa Oasis\",\n" +
								"    \"Madinat Zayed\",\n" +
								"    \"Marawah\",\n" +
								"    \"Masafi\",\n" +
								"    \"Masfut\",\n" +
								"    \"Mirbah\",\n" +
								"    \"Mleiha\",\n" +
								"    \"Nahil\",\n" +
								"    \"RAK City\",\n" +
								"    \"Ruwais\",\n" +
								"    \"Sha'am\",\n" +
								"    \"Sharjah\",\n" +
								"    \"Sila\",\n" +
								"    \"Sir Bani Yas\",\n" +
								"    \"Sweihan\",\n" +
								"    \"Umm Al Quwain\",\n" +
								"    \"Wadi Shah\",\n" +
								"    \"Zubarah\"\n" +
								"  ],\n" +
								"  \"Syria\":[\n" +
								"    \"Damascus\",\n" +
								"    \"`Ara\",\n" +
								"    \"Aleppo\",\n" +
								"    \"Ad Darah\"\n" +
								"  ],\n" +
								"  \"Guinea\":[\n" +
								"    \"Conakry\",\n" +
								"    \"Forécariah\",\n" +
								"    \"Nzérékoré\",\n" +
								"    \"Labé\",\n" +
								"    \"Kankan\",\n" +
								"    \"Port Kamsar\",\n" +
								"    \"Boké\",\n" +
								"    \"Mamou\",\n" +
								"    \"Dabola\",\n" +
								"    \"Lola\",\n" +
								"    \"Sangaredi\",\n" +
								"    \"Kalia\"\n" +
								"  ],\n" +
								"  \"Congo\":[\n" +
								"    \"Kinshasa\",\n" +
								"    \"Lubumbashi\",\n" +
								"    \"Goma\",\n" +
								"    \"Banana\",\n" +
								"    \"Likasi\"\n" +
								"  ],\n" +
								"  \"Swaziland\":[\n" +
								"    \"Mbabane\",\n" +
								"    \"Piggs Peak\",\n" +
								"    \"Lobamba\",\n" +
								"    \"Kwaluseni\",\n" +
								"    \"Manzini\"\n" +
								"  ],\n" +
								"  \"Burkina Faso\":[\n" +
								"    \"Ouagadougou\",\n" +
								"    \"Bobo-Dioulasso\",\n" +
								"    \"Tenkodogo\"\n" +
								"  ],\n" +
								"  \"Sierra Leone\":[\n" +
								"    \"Freetown\"\n" +
								"  ],\n" +
								"  \"Somalia\":[\n" +
								"    \"Hargeysa\",\n" +
								"    \"Mogadishu\"\n" +
								"  ],\n" +
								"  \"Niger\":[\n" +
								"    \"Niamey\"\n" +
								"  ],\n" +
								"  \"Central African Republic\":[\n" +
								"    \"Bangui\"\n" +
								"  ],\n" +
								"  \"Togo\":[\n" +
								"    \"Lomé\",\n" +
								"    \"Sansanne-Mango\"\n" +
								"  ],\n" +
								"  \"Burundi\":[\n" +
								"    \"Bujumbura\",\n" +
								"    \"\"\n" +
								"  ],\n" +
								"  \"Equatorial Guinea\":[\n" +
								"    \"Malabo\"\n" +
								"  ],\n" +
								"  \"South Sudan\":[\n" +
								"    \"Juba\"\n" +
								"  ],\n" +
								"  \"Senegal\":[\n" +
								"    \"Sama\",\n" +
								"    \"Dakar\",\n" +
								"    \"Guediawaye\",\n" +
								"    \"Louga\",\n" +
								"    \"Kaolack\",\n" +
								"    \"Dodji\",\n" +
								"    \"Boussinki\",\n" +
								"    \"Tanaf\",\n" +
								"    \"Saint-Louis\",\n" +
								"    \"Camberene\",\n" +
								"    \"Kedougou\",\n" +
								"    \"Madina Kokoun\"\n" +
								"  ],\n" +
								"  \"Mauritania\":[\n" +
								"    \"Nouakchott\"\n" +
								"  ],\n" +
								"  \"Djibouti\":[\n" +
								"    \"Djibouti\"\n" +
								"  ],\n" +
								"  \"Comoros\":[\n" +
								"    \"Moutsamoudou\",\n" +
								"    \"Moroni\"\n" +
								"  ],\n" +
								"  \"Tunisia\":[\n" +
								"    \"Tunis\",\n" +
								"    \"Le Bardo\",\n" +
								"    \"Sousse\",\n" +
								"    \"Gafsa\",\n" +
								"    \"Monastir\",\n" +
								"    \"Hammamet\",\n" +
								"    \"Sidi Bouzid\",\n" +
								"    \"Manouba\",\n" +
								"    \"Beja\",\n" +
								"    \"Rades\",\n" +
								"    \"Ariana\",\n" +
								"    \"Sfax\"\n" +
								"  ],\n" +
								"  \"Nauru\":[\n" +
								"    \"Anabar\"\n" +
								"  ],\n" +
								"  \"South Georgia and the South Sandwich Islands\":[\n" +
								"    \"Grytviken\"\n" +
								"  ],\n" +
								"  \"U.S. Minor Outlying Islands\":[\n" +
								"    \"\"\n" +
								"  ],\n" +
								"  \"Sint Maarten\":[\n" +
								"    \"Philipsburg\",\n" +
								"    \"\"\n" +
								"  ],\n" +
								"  \"São Tomé and Príncipe\":[\n" +
								"    \"Neves\",\n" +
								"    \"São Tomé\",\n" +
								"    \"\"\n" +
								"  ],\n" +
								"  \"Falkland Islands\":[\n" +
								"    \"Stanley\"\n" +
								"  ],\n" +
								"  \"Northern Mariana Islands\":[\n" +
								"    \"Saipan\"\n" +
								"  ],\n" +
								"  \"East Timor\":[\n" +
								"    \"Dili\",\n" +
								"    \"\"\n" +
								"  ],\n" +
								"  \"Bonaire\":[\n" +
								"    \"Kralendijk\",\n" +
								"    \"Dorp Nikiboko\"\n" +
								"  ],\n" +
								"  \"American Samoa\":[\n" +
								"    \"American Samoa\",\n" +
								"    \"Pago Pago\"\n" +
								"  ],\n" +
								"  \"Federated States of Micronesia\":[\n" +
								"    \"Yap\"\n" +
								"  ],\n" +
								"  \"Palau\":[\n" +
								"    \"\"\n" +
								"  ],\n" +
								"  \"Guyana\":[\n" +
								"    \"Georgetown\",\n" +
								"    \"New Amsterdam\",\n" +
								"    \"Linden\"\n" +
								"  ],\n" +
								"  \"Honduras\":[\n" +
								"    \"Tegucigalpa\",\n" +
								"    \"San Pedro Sula\",\n" +
								"    \"Morazan\",\n" +
								"    \"La Ceiba\",\n" +
								"    \"Santa Barbara\",\n" +
								"    \"Copán\",\n" +
								"    \"Coxen Hole\",\n" +
								"    \"El Progreso\",\n" +
								"    \"San Antonio de Flores\",\n" +
								"    \"Piraera\",\n" +
								"    \"La Hacienda\",\n" +
								"    \"Comayaguela\",\n" +
								"    \"Choloma\",\n" +
								"    \"Comayagua\",\n" +
								"    \"Nacaome\",\n" +
								"    \"Pinalejo\",\n" +
								"    \"Puerto Lempira\",\n" +
								"    \"Sula\",\n" +
								"    \"El Barro\",\n" +
								"    \"El Paraiso\"\n" +
								"  ],\n" +
								"  \"Laos\":[\n" +
								"    \"Vientiane\"\n" +
								"  ],\n" +
								"  \"Uruguay\":[\n" +
								"    \"Montevideo\",\n" +
								"    \"La Floresta\",\n" +
								"    \"Barra de Carrasco\",\n" +
								"    \"Paysandú\",\n" +
								"    \"Salto\",\n" +
								"    \"Las Piedras\",\n" +
								"    \"Tacuarembó\",\n" +
								"    \"Toledo\",\n" +
								"    \"Colonia del Sacramento\",\n" +
								"    \"Mercedes\",\n" +
								"    \"Union\",\n" +
								"    \"Florida\",\n" +
								"    \"Maldonado\",\n" +
								"    \"Canelones\",\n" +
								"    \"La Paz\",\n" +
								"    \"San Carlos\",\n" +
								"    \"Durazno\",\n" +
								"    \"Punta del Este\"\n" +
								"  ],\n" +
								"  \"Eritrea\":[\n" +
								"    \"Asmara\",\n" +
								"    \"\"\n" +
								"  ],\n" +
								"  \"Cuba\":[\n" +
								"    \"Havana\",\n" +
								"    \"Habana\",\n" +
								"    \"La Habana\",\n" +
								"    \"Matanzas\",\n" +
								"    \"Villa\",\n" +
								"    \"Bayamo\",\n" +
								"    \"Cienfuegos\",\n" +
								"    \"Santiago de Cuba\",\n" +
								"    \"Holguín\",\n" +
								"    \"Ciego de Ávila\",\n" +
								"    \"Pinar del Río\",\n" +
								"    \"Sancti Spíritus\",\n" +
								"    \"Camagüey\",\n" +
								"    \"Las Tunas\",\n" +
								"    \"Guantánamo\",\n" +
								"    \"Varadero\"\n" +
								"  ],\n" +
								"  \"Saint Helena\":[\n" +
								"    \"Tristan Da Cunha\",\n" +
								"    \"Jamestown\"\n" +
								"  ],\n" +
								"  \"Christmas Island\":[\n" +
								"    \"Flying Fish Cove\"\n" +
								"  ],\n" +
								"  \"Ethiopia\":[\n" +
								"    \"Addis Ababa\",\n" +
								"    \"Awasa\",\n" +
								"    \"Jijiga\"\n" +
								"  ],\n" +
								"  \"British Indian Ocean Territory\":[\n" +
								"    \"\"\n" +
								"  ]\n" +
								"}");

			JSONObject jsonObject = (JSONObject) obj;

			JSONArray regionsList = (JSONArray) jsonObject.get(Country);

			if (regionsList != null){
				for(Iterator iterator = regionsList.iterator(); iterator.hasNext();) {
					String key = (String) iterator.next();
					System.out.println(key);
					Region r = new Region(key);
					regionRepository.save(r);
					r.setRegionCountry(c);
					regionRepository.save(r);
					RegionsStatistics rStatistics = new RegionsStatistics(0, 0, 0, 0,StatisticsTypes.Region);
					rStatistics.setStatisticsValidate(false);
					rStatistics.setStatisticsRegion(r);
					rStatistics.setStatisticsRegionName(r.getRegionName());
					rStatistics.setStatisticsValidate(true);
					rStatistics.setStatisticsHealthAgent(null);
					regionsStatisticsRepository.save(rStatistics);
					c.getCountryRegions().add(r);
					System.out.println("-----------------------------------------------------------------");
					System.out.println("-----------------------------------------------------------------");
					System.out.println("-----------------------------------------------------------------");
				}
			}
			countryRepository.save(c);
		} catch (Exception e) {
			e.printStackTrace();


		}
	}

	public static void readJsonCountries(CountryRepository countryRepository,RegionRepository regionRepository,StatisticsRepository statisticsRepository,RegionsStatisticsRepository regionsStatisticsRepository) {
		JSONParser parser = new JSONParser();
		try {
			//Object obj = parser.parse(new FileReader("src\\DataBDD\\geoLITE.json"));
			Object obj = parser.parse("{\n" +
					"  \"Algeria\":[\n" +
					"    \"Algiers\",\n" +
					"    \"Souk Ahras\",\n" +
					"    \"Annaba\",\n" +
					"    \"Batna City\",\n" +
					"    \"Sétif\",\n" +
					"    \"Béjaïa\",\n" +
					"    \"Bordj Bou Arreridj\",\n" +
					"    \"Bordj\",\n" +
					"    \"Tiaret\",\n" +
					"    \"Oran\",\n" +
					"    \"Saida\",\n" +
					"    \"Tlemcen\",\n" +
					"    \"Oued Smar\",\n" +
					"    \"Tizi\",\n" +
					"    \"Tizi Ouzou\",\n" +
					"    \"Azazga\",\n" +
					"    \"Blida\",\n" +
					"    \"Rouiba\",\n" +
					"    \"Hussein Dey\",\n" +
					"    \"Draria\",\n" +
					"    \"Tissemsilt\",\n" +
					"    \"El Tarf\",\n" +
					"    \"Constantine\",\n" +
					"    \"Illizi\",\n" +
					"    \"Laghouat\",\n" +
					"    \"Kouba\",\n" +
					"    \"Jijel\",\n" +
					"    \"Ghardaïa\",\n" +
					"    \"Bougara\",\n" +
					"    \"Chlef\",\n" +
					"    \"Cheraga\",\n" +
					"    \"Ouargla\",\n" +
					"    \"Relizane\",\n" +
					"    \"Djelfa\",\n" +
					"    \"Béchar\",\n" +
					"    \"Tamanghasset\"\n" +
					"  ],\n" +
					"  \"Republic of Korea\":[\n" +
					"    \"Seoul\",\n" +
					"    \"Incheon\",\n" +
					"    \"Paju\",\n" +
					"    \"Cheonan\",\n" +
					"    \"Yongin\",\n" +
					"    \"Kwanghui-dong\",\n" +
					"    \"Pon-dong\",\n" +
					"    \"Gwangju\",\n" +
					"    \"Gwangmyeong\",\n" +
					"    \"Tang-ni\",\n" +
					"    \"Busan\",\n" +
					"    \"Seongnam-si\",\n" +
					"    \"Suwon-si\",\n" +
					"    \"Namyang\",\n" +
					"    \"Namyangju\",\n" +
					"    \"Jeju-si\",\n" +
					"    \"Ulsan\",\n" +
					"    \"Osan\"\n" +
					"  ],\n" +
					"  \"Hong Kong\":[\n" +
					"    \"Shuen Wan\",\n" +
					"    \"Central District\",\n" +
					"    \"Hung Hom\",\n" +
					"    \"Kowloon\",\n" +
					"    \"Quarry Bay\",\n" +
					"    \"Ngau Tau Kok\",\n" +
					"    \"Ying Pun\",\n" +
					"    \"Repulse Bay\",\n" +
					"    \"Causeway Bay\",\n" +
					"    \"Tseung Kwan O\",\n" +
					"    \"Tai Kok Tsui\",\n" +
					"    \"Tai Wai\",\n" +
					"    \"Ma On Shan Tsuen\",\n" +
					"    \"To Kwa Wan\",\n" +
					"    \"Wong Tai Sin\",\n" +
					"    \"Tuen Mun San Hui\",\n" +
					"    \"Ma Yau Tong\"\n" +
					"  ],\n" +
					"  \"Philippines\":[\n" +
					"    \"Manila\",\n" +
					"    \"Ayala\",\n" +
					"    \"Bayan\",\n" +
					"    \"Roosevelt\",\n" +
					"    \"Blumentritt\",\n" +
					"    \"Cardona\",\n" +
					"    \"Pasong Tamo\",\n" +
					"    \"Buting\",\n" +
					"    \"Lipa City\",\n" +
					"    \"Taguig\",\n" +
					"    \"Baguio City\",\n" +
					"    \"San Pablo City\",\n" +
					"    \"San Mateo\",\n" +
					"    \"Rizal\",\n" +
					"    \"Naguilian\",\n" +
					"    \"San Vicente\",\n" +
					"    \"Sto Nino\",\n" +
					"    \"Province of Laguna\",\n" +
					"    \"Quezon\"\n" +
					"  ],\n" +
					"  \"France\":[\n" +
					"    \"Paris\",\n" +
					"    \"Lyon\",\n" +
					"    \"Marseille\",\n" +
					"    \"Toulouse\",\n" +
					"    \"Nice\",\n" +
					"    \"Nantes\",\n" +
					"    \"Montpellier\",\n" +
					"    \"Bordeaux\",\n" +
					"    \"Strasbourg\",\n" +
					"    \"Lille\",\n" +
					"    \"Reims\",\n" +
					"    \"Toulon\"\n" +
					"  ],\n" +
					"  \"Germany\":[\n" +
					"    \"Langgons\",\n" +
					"    \"Holle\",\n" +
					"    \"Tespe\",\n" +
					"    \"Walsrode\",\n" +
					"    \"Salzgitter\",\n" +
					"    \"Bad Sassendorf\",\n" +
					"    \"Vienenburg\",\n" +
					"    \"Rosdorf\",\n" +
					"    \"Einbeck\",\n" +
					"    \"Markersbach\",\n" +
					"    \"Uetersen\",\n" +
					"    \"Lauenburg\",\n" +
					"    \"Neustadt in Holstein\",\n" +
					"    \"Heiligenhafen\",\n" +
					"    \"Lutjenburg\",\n" +
					"    \"Quickborn\",\n" +
					"    \"Tangstedt\",\n" +
					"    \"Tangstedt\",\n" +
					"    \"Negast\",\n" +
					"    \"Langendorf\",\n" +
					"    \"Stockelsdorf\",\n" +
					"    \"Prangendorf\",\n" +
					"    \"Lagerdorf\",\n" +
					"    \"Jersbek\",\n" +
					"    \"Lutjensee\",\n" +
					"    \"Hoisdorf\",\n" +
					"    \"Tremsbuttel\",\n" +
					"    \"Nahe\",\n" +
					"    \"Itzstedt\",\n" +
					"    \"Dabelow\",\n" +
					"    \"Monkeberg\",\n" +
					"    \"Altenholz\",\n" +
					"    \"Buxtehude\",\n" +
					"    \"Escheburg\",\n" +
					"    \"Aurachtal\",\n" +
					"    \"Frankenwinheim\",\n" +
					"    \"Armstorf\"\n" +
					"  ],\n" +
					"  \"Italy\":[\n" +
					"    \"Ferrara\",\n" +
					"    \"Sarnano\",\n" +
					"    \"Rome\",\n" +
					"    \"Gabicce Mare\",\n" +
					"    \"Sasso Marconi\",\n" +
					"    \"Sarno\",\n" +
					"    \"Collegno\",\n" +
					"    \"La Via\",\n" +
					"    \"Radda in Chianti\",\n" +
					"    \"Riale\"\n" +
					"  ],\n" +
					"  \"United Kingdom\":[\n" +
					"    \"Pershore\",\n" +
					"    \"Rowley Regis\",\n" +
					"    \"Stroud\",\n" +
					"    \"Birmingham\",\n" +
					"    \"Worcester\",\n" +
					"    \"Smethwick\",\n" +
					"    \"Alcester\",\n" +
					"    \"Dudley\",\n" +
					"    \"Ottershaw\",\n" +
					"    \"Petworth\",\n" +
					"    \"Bedminster\",\n" +
					"    \"Hitcham\",\n" +
					"    \"Westleigh\",\n" +
					"    \"West Langdon\",\n" +
					"    \"Handcross\",\n" +
					"    \"Blackheath\",\n" +
					"    \"Alrewas\",\n" +
					"    \"Clapham\",\n" +
					"    \"Harby\"\n" +
					"  ],\n" +
					"  \"United Arab Emirates\":[\n" +
					"    \"Abu Dhabi\",\n" +
					"    \"Abu al Abyad\",\n" +
					"    \"Adhen\",\n" +
					"    \"Ajman\",\n" +
					"    \"Al Ain\",\n" +
					"    \"Al Ajban\",\n" +
					"    \"Al Aryam\",\n" +
					"    \"Al Awir\",\n" +
					"    \"Al Badiyah\",\n" +
					"    \"Al Bataeh\",\n" +
					"    \"Al Bithnah\",\n" +
					"    \"Al Faqa\",\n" +
					"    \"Al Halah\",\n" +
					"    \"Al Hamraniyah\",\n" +
					"    \"Al Hamriyah\",\n" +
					"    \"Al Jazirah Al Hamra\",\n" +
					"    \"Al Jeer\",\n" +
					"    \"Al Khawaneej\",\n" +
					"    \"Al Lisaili\",\n" +
					"    \"Al Madam\",\n" +
					"    \"Al Manama\",\n" +
					"    \"Al Mirfa\",\n" +
					"    \"Al Qor\",\n" +
					"    \"Al Qusaidat\",\n" +
					"    \"Al Rafaah\",\n" +
					"    \"Al Rashidya\",\n" +
					"    \"Al Shuwaib\",\n" +
					"    \"Al Yahar\",\n" +
					"    \"Ar-Rams\",\n" +
					"    \"Asimah\",\n" +
					"    \"Dadna\",\n" +
					"    \"Dalma\",\n" +
					"    \"Dhaid\",\n" +
					"    \"Dibba Al-Fujairah\",\n" +
					"    \"Dibba Al-Hisn\",\n" +
					"    \"Digdaga\",\n" +
					"    \"Dubai\",\n" +
					"    \"Falaj Al Mualla\",\n" +
					"    \"Fujairah\",\n" +
					"    \"Ghalilah\",\n" +
					"    \"Ghayathi\",\n" +
					"    \"Ghub\",\n" +
					"    \"Habshan\",\n" +
					"    \"Hatta\",\n" +
					"    \"Huwaylat\",\n" +
					"    \"Jebel Ali\",\n" +
					"    \"Kalba\",\n" +
					"    \"Khatt\",\n" +
					"    \"Khor Fakkan\",\n" +
					"    \"Khor Khwair\",\n" +
					"    \"Lahbab\",\n" +
					"    \"Liwa Oasis\",\n" +
					"    \"Madinat Zayed\",\n" +
					"    \"Marawah\",\n" +
					"    \"Masafi\",\n" +
					"    \"Masfut\",\n" +
					"    \"Mirbah\",\n" +
					"    \"Mleiha\",\n" +
					"    \"Nahil\",\n" +
					"    \"RAK City\",\n" +
					"    \"Ruwais\",\n" +
					"    \"Sha'am\",\n" +
					"    \"Sharjah\",\n" +
					"    \"Sila\",\n" +
					"    \"Sir Bani Yas\",\n" +
					"    \"Sweihan\",\n" +
					"    \"Umm Al Quwain\",\n" +
					"    \"Wadi Shah\",\n" +
					"    \"Zubarah\"\n" +
					"  ],\n" +
					"  \"Syria\":[\n" +
					"    \"Damascus\",\n" +
					"    \"`Ara\",\n" +
					"    \"Aleppo\",\n" +
					"    \"Ad Darah\"\n" +
					"  ],\n" +
					"  \"Guinea\":[\n" +
					"    \"Conakry\",\n" +
					"    \"Forécariah\",\n" +
					"    \"Nzérékoré\",\n" +
					"    \"Labé\",\n" +
					"    \"Kankan\",\n" +
					"    \"Port Kamsar\",\n" +
					"    \"Boké\",\n" +
					"    \"Mamou\",\n" +
					"    \"Dabola\",\n" +
					"    \"Lola\",\n" +
					"    \"Sangaredi\",\n" +
					"    \"Kalia\"\n" +
					"  ],\n" +
					"  \"Congo\":[\n" +
					"    \"Kinshasa\",\n" +
					"    \"Lubumbashi\",\n" +
					"    \"Goma\",\n" +
					"    \"Banana\",\n" +
					"    \"Likasi\"\n" +
					"  ],\n" +
					"  \"Swaziland\":[\n" +
					"    \"Mbabane\",\n" +
					"    \"Piggs Peak\",\n" +
					"    \"Lobamba\",\n" +
					"    \"Kwaluseni\",\n" +
					"    \"Manzini\"\n" +
					"  ],\n" +
					"  \"Burkina Faso\":[\n" +
					"    \"Ouagadougou\",\n" +
					"    \"Bobo-Dioulasso\",\n" +
					"    \"Tenkodogo\"\n" +
					"  ],\n" +
					"  \"Sierra Leone\":[\n" +
					"    \"Freetown\"\n" +
					"  ],\n" +
					"  \"Somalia\":[\n" +
					"    \"Hargeysa\",\n" +
					"    \"Mogadishu\"\n" +
					"  ],\n" +
					"  \"Niger\":[\n" +
					"    \"Niamey\"\n" +
					"  ],\n" +
					"  \"Central African Republic\":[\n" +
					"    \"Bangui\"\n" +
					"  ],\n" +
					"  \"Togo\":[\n" +
					"    \"Lomé\",\n" +
					"    \"Sansanne-Mango\"\n" +
					"  ],\n" +
					"  \"Burundi\":[\n" +
					"    \"Bujumbura\",\n" +
					"    \"\"\n" +
					"  ],\n" +
					"  \"Equatorial Guinea\":[\n" +
					"    \"Malabo\"\n" +
					"  ],\n" +
					"  \"South Sudan\":[\n" +
					"    \"Juba\"\n" +
					"  ],\n" +
					"  \"Senegal\":[\n" +
					"    \"Sama\",\n" +
					"    \"Dakar\",\n" +
					"    \"Guediawaye\",\n" +
					"    \"Louga\",\n" +
					"    \"Kaolack\",\n" +
					"    \"Dodji\",\n" +
					"    \"Boussinki\",\n" +
					"    \"Tanaf\",\n" +
					"    \"Saint-Louis\",\n" +
					"    \"Camberene\",\n" +
					"    \"Kedougou\",\n" +
					"    \"Madina Kokoun\"\n" +
					"  ],\n" +
					"  \"Mauritania\":[\n" +
					"    \"Nouakchott\"\n" +
					"  ],\n" +
					"  \"Djibouti\":[\n" +
					"    \"Djibouti\"\n" +
					"  ],\n" +
					"  \"Comoros\":[\n" +
					"    \"Moutsamoudou\",\n" +
					"    \"Moroni\"\n" +
					"  ],\n" +
					"  \"Tunisia\":[\n" +
					"    \"Tunis\",\n" +
					"    \"Le Bardo\",\n" +
					"    \"Sousse\",\n" +
					"    \"Gafsa\",\n" +
					"    \"Monastir\",\n" +
					"    \"Hammamet\",\n" +
					"    \"Sidi Bouzid\",\n" +
					"    \"Manouba\",\n" +
					"    \"Beja\",\n" +
					"    \"Rades\",\n" +
					"    \"Ariana\",\n" +
					"    \"Sfax\"\n" +
					"  ],\n" +
					"  \"Nauru\":[\n" +
					"    \"Anabar\"\n" +
					"  ],\n" +
					"  \"South Georgia and the South Sandwich Islands\":[\n" +
					"    \"Grytviken\"\n" +
					"  ],\n" +
					"  \"U.S. Minor Outlying Islands\":[\n" +
					"    \"\"\n" +
					"  ],\n" +
					"  \"Sint Maarten\":[\n" +
					"    \"Philipsburg\",\n" +
					"    \"\"\n" +
					"  ],\n" +
					"  \"São Tomé and Príncipe\":[\n" +
					"    \"Neves\",\n" +
					"    \"São Tomé\",\n" +
					"    \"\"\n" +
					"  ],\n" +
					"  \"Falkland Islands\":[\n" +
					"    \"Stanley\"\n" +
					"  ],\n" +
					"  \"Northern Mariana Islands\":[\n" +
					"    \"Saipan\"\n" +
					"  ],\n" +
					"  \"East Timor\":[\n" +
					"    \"Dili\",\n" +
					"    \"\"\n" +
					"  ],\n" +
					"  \"Bonaire\":[\n" +
					"    \"Kralendijk\",\n" +
					"    \"Dorp Nikiboko\"\n" +
					"  ],\n" +
					"  \"American Samoa\":[\n" +
					"    \"American Samoa\",\n" +
					"    \"Pago Pago\"\n" +
					"  ],\n" +
					"  \"Federated States of Micronesia\":[\n" +
					"    \"Yap\"\n" +
					"  ],\n" +
					"  \"Palau\":[\n" +
					"    \"\"\n" +
					"  ],\n" +
					"  \"Guyana\":[\n" +
					"    \"Georgetown\",\n" +
					"    \"New Amsterdam\",\n" +
					"    \"Linden\"\n" +
					"  ],\n" +
					"  \"Honduras\":[\n" +
					"    \"Tegucigalpa\",\n" +
					"    \"San Pedro Sula\",\n" +
					"    \"Morazan\",\n" +
					"    \"La Ceiba\",\n" +
					"    \"Santa Barbara\",\n" +
					"    \"Copán\",\n" +
					"    \"Coxen Hole\",\n" +
					"    \"El Progreso\",\n" +
					"    \"San Antonio de Flores\",\n" +
					"    \"Piraera\",\n" +
					"    \"La Hacienda\",\n" +
					"    \"Comayaguela\",\n" +
					"    \"Choloma\",\n" +
					"    \"Comayagua\",\n" +
					"    \"Nacaome\",\n" +
					"    \"Pinalejo\",\n" +
					"    \"Puerto Lempira\",\n" +
					"    \"Sula\",\n" +
					"    \"El Barro\",\n" +
					"    \"El Paraiso\"\n" +
					"  ],\n" +
					"  \"Laos\":[\n" +
					"    \"Vientiane\"\n" +
					"  ],\n" +
					"  \"Uruguay\":[\n" +
					"    \"Montevideo\",\n" +
					"    \"La Floresta\",\n" +
					"    \"Barra de Carrasco\",\n" +
					"    \"Paysandú\",\n" +
					"    \"Salto\",\n" +
					"    \"Las Piedras\",\n" +
					"    \"Tacuarembó\",\n" +
					"    \"Toledo\",\n" +
					"    \"Colonia del Sacramento\",\n" +
					"    \"Mercedes\",\n" +
					"    \"Union\",\n" +
					"    \"Florida\",\n" +
					"    \"Maldonado\",\n" +
					"    \"Canelones\",\n" +
					"    \"La Paz\",\n" +
					"    \"San Carlos\",\n" +
					"    \"Durazno\",\n" +
					"    \"Punta del Este\"\n" +
					"  ],\n" +
					"  \"Eritrea\":[\n" +
					"    \"Asmara\",\n" +
					"    \"\"\n" +
					"  ],\n" +
					"  \"Cuba\":[\n" +
					"    \"Havana\",\n" +
					"    \"Habana\",\n" +
					"    \"La Habana\",\n" +
					"    \"Matanzas\",\n" +
					"    \"Villa\",\n" +
					"    \"Bayamo\",\n" +
					"    \"Cienfuegos\",\n" +
					"    \"Santiago de Cuba\",\n" +
					"    \"Holguín\",\n" +
					"    \"Ciego de Ávila\",\n" +
					"    \"Pinar del Río\",\n" +
					"    \"Sancti Spíritus\",\n" +
					"    \"Camagüey\",\n" +
					"    \"Las Tunas\",\n" +
					"    \"Guantánamo\",\n" +
					"    \"Varadero\"\n" +
					"  ],\n" +
					"  \"Saint Helena\":[\n" +
					"    \"Tristan Da Cunha\",\n" +
					"    \"Jamestown\"\n" +
					"  ],\n" +
					"  \"Christmas Island\":[\n" +
					"    \"Flying Fish Cove\"\n" +
					"  ],\n" +
					"  \"Ethiopia\":[\n" +
					"    \"Addis Ababa\",\n" +
					"    \"Awasa\",\n" +
					"    \"Jijiga\"\n" +
					"  ],\n" +
					"  \"British Indian Ocean Territory\":[\n" +
					"    \"\"\n" +
					"  ]\n" +
					"}");

			JSONObject jsonObject = (JSONObject) obj;

			for(Iterator iterator = jsonObject.keySet().iterator(); iterator.hasNext();) {
				String key = (String) iterator.next();
				Country c = new Country(key);
				countryRepository.save(c);
				CountryStatistics al = new CountryStatistics(0,0,0,0,StatisticsTypes.Country);
				al.setStatisticsCountry(c);
				c.setCountryStatistics(al);
				statisticsRepository.save(c.getCountryStatistics());

				System.out.println(jsonObject.get(key));
				System.out.println(key);
				readJsonRegions(key,c,countryRepository,regionRepository,regionsStatisticsRepository);
				System.out.println("-----------------------------------------------------------------");
				System.out.println("-----------------------------------------------------------------");
				System.out.println("-----------------------------------------------------------------");
			}



		} catch (Exception e) {
			e.printStackTrace();



		}
	}


	@Bean
	public CommandLineRunner demo(ArticleRepository articlerepository ,
								  UserRepository userrepository ,
								  StatisticsRepository statisticsRepository,
								  RegionRepository regionrepository ,
								  ContinentRepository continentRepository ,
								  CountryRepository countryRepository,
								  RegionsStatisticsRepository regionsStatisticsRepository
	) {
		return (args) -> {


			Redactor redactor = new Redactor("Redactor", "firstnameRedactor", "LastNameRedactor", "Redactor@gmail.com", encoder.encode("azerty"), UserType.Redactor);
			SuperAdmin SuperAdmin = new SuperAdmin("SuperAdmin", "Super", "Admin", "superadmin@gmail.com", encoder.encode("azerty"), UserType.SuperAdmin);
			Moderator moderator = new Moderator("Moderator", "firstnameModerator", "LastNameModerator", "Moderator@gmail.com",  encoder.encode("azerty"), UserType.Moderator);
			HealthAgent healthagent = new HealthAgent("HealthAgent", "firstnameHealthAgent", "LastNameHealthAgent", "HealthAgent@gmail.com",  encoder.encode("azerty"), UserType.HealthAgent);
			WebUser webuser = new WebUser("WebUser", "firstnameWebUser", "LastNameWebUser", "WebUser@gmail.com",  encoder.encode("azerty"), UserType.WebUser);

			userrepository.save(healthagent);
			userrepository.save(moderator);
			userrepository.save(SuperAdmin);
			userrepository.save(redactor);
			userrepository.save(webuser);



			//--------------TEST ARTICLES -----------------------------
			Article article1 = new Article("Article Title 1 ", "Article Content 1");
			article1.setArticleValidate(true);
			Commentary comment1 = new Commentary("Bla Bla Bla Bla Bla Bla Bla Bla ");
			comment1.setCommentArticle(article1);
			Commentary comment2 = new Commentary("TEST TEST TEST TEST TEST TEST TEST ");
			comment2.setCommentArticle(article1);
			Commentary comment3 = new Commentary("SOMETHING SOMETHING SOMETHING ");
			comment3.setCommentArticle(article1);
			Commentary comment4 = new Commentary("ANYWAYS ......");
			comment4.setCommentArticle(article1);
			Set<Commentary> comments = new HashSet<Commentary>();
			comments.add(comment1);
			comments.add(comment2);
			comments.add(comment3);
			comments.add(comment4);
			article1.setArticleCommentaries(comments);
			Article article2 = new Article("Article Title 2 ", "Article Content 2");
			article2.setArticleValidate(false);
			Article article3 = new Article("Article Title 3 ", "Article Content 3");
			article1.setArticleValidate(true);

			articlerepository.save(article1);
			articlerepository.save(article2);
			articlerepository.save(article3);

			webuser.setWebUserCommentaries(comments);
			comment1.setCommentEditor(webuser);
			comment2.setCommentEditor(webuser);
			comment3.setCommentEditor(webuser);
			comment4.setCommentEditor(webuser);
			userrepository.save(webuser);

			articlerepository.save(article1);
			articlerepository.save(article2);
			articlerepository.save(article3);

			//-------------- REGION COUNTRY CONTINENT    -----------------------------

/*
			Continent africa = new Continent(Continents.Africa);
			Continent europe = new Continent(Continents.Europe);
			Continent asia = new Continent(Continents.Asia);
			Continent north_America = new Continent(Continents.North_America);
			Continent south_America = new Continent(Continents.South_America);
			Continent australia_Oceania = new Continent(Continents.Australia_Oceania);
			Continent antarctica = new Continent(Continents.Antarctica);


			continentRepository.save(asia);
			continentRepository.save(north_America);
			continentRepository.save(south_America);
			continentRepository.save(australia_Oceania);
			continentRepository.save(antarctica);
			continentRepository.save(africa);
			continentRepository.save(europe);
			ContinentStatistics af = new ContinentStatistics(1649480,20515259,74248878,52488879,StatisticsTypes.Continent);
			af.setStatisticsContinent(africa);
			africa.setContinentStatistics(af);
			africa.getContinentStatistics().setStatisticsValidate(true);
			ContinentStatistics as = new ContinentStatistics(0,0,0,0,StatisticsTypes.Continent);
			as.setStatisticsContinent(asia);
			asia.setContinentStatistics(as);
			asia.getContinentStatistics().setStatisticsValidate(true);
			ContinentStatistics so = new ContinentStatistics(0,0,0,0,StatisticsTypes.Continent);
			so.setStatisticsContinent(south_America);
			south_America.setContinentStatistics(so);
			south_America.getContinentStatistics().setStatisticsValidate(true);
			ContinentStatistics no = new ContinentStatistics(0,0,0,0,StatisticsTypes.Continent);
			no.setStatisticsContinent(north_America);
			north_America.setContinentStatistics(no);
			north_America.getContinentStatistics().setStatisticsValidate(true);
			ContinentStatistics au = new ContinentStatistics(0,0,0,0,StatisticsTypes.Continent);
			au.setStatisticsContinent(australia_Oceania);
			australia_Oceania.setContinentStatistics(au);
			australia_Oceania.getContinentStatistics().setStatisticsValidate(true);
			ContinentStatistics an = new ContinentStatistics(0,0,0,0,StatisticsTypes.Continent);
			an.setStatisticsContinent(antarctica);
			antarctica.setContinentStatistics(an);
			antarctica.getContinentStatistics().setStatisticsValidate(true);
			ContinentStatistics e = new ContinentStatistics(1,1,1,1,StatisticsTypes.Continent);
			e.setStatisticsContinent(europe);
			europe.setContinentStatistics(e);
			europe.getContinentStatistics().setStatisticsValidate(true);
			statisticsRepository.save(asia.getContinentStatistics());
			statisticsRepository.save(north_America.getContinentStatistics());
			statisticsRepository.save(south_America.getContinentStatistics());
			statisticsRepository.save(australia_Oceania.getContinentStatistics());
			statisticsRepository.save(antarctica.getContinentStatistics());
			statisticsRepository.save(africa.getContinentStatistics());
			statisticsRepository.save(europe.getContinentStatistics());
*/

			Country algeria = new Country("DZ");
			countryRepository.save(algeria);


			CountryStatistics al = new CountryStatistics(1649480,20515259,74248878,52488879,StatisticsTypes.Country);
			al.setStatisticsCountry(algeria);
			algeria.setCountryStatistics(al);
			al.setStatisticsValidate(true);
			statisticsRepository.save(algeria.getCountryStatistics());


			Region constantine = new Region("Constantine");
			regionrepository.save(constantine);
			RegionsStatistics r = new RegionsStatistics(1649480,20515259,74248878,52488879,StatisticsTypes.Region);
			r.setStatisticsRegion(constantine);
			r.setStatisticsRegionName(constantine.getRegionName());
			statisticsRepository.save(r);
			constantine.setRegionStatistics(r);

			regionrepository.save(constantine);
			constantine.setRegionCountry(algeria);
			constantine.setRegionRisk(RegionRisks.ValidatedRisk);
			regionrepository.save(constantine);
			algeria.getCountryRegions().add(constantine);
			countryRepository.save(algeria);


			Region batna = new Region("Batna");
			regionrepository.save(batna);
			RegionsStatistics r1 = new RegionsStatistics(1,2,3,4,StatisticsTypes.Region);
			r1.setStatisticsRegion(batna);
			r1.setStatisticsRegionName(batna.getRegionName());
			r1.setStatisticsValidate(true);
			statisticsRepository.save(r1);
			batna.setRegionStatistics(r1);

			regionrepository.save(batna);
			batna.setRegionCountry(algeria);
			batna.setRegionRisk(RegionRisks.NonValidatedRisk);
			regionrepository.save(batna);
			algeria.getCountryRegions().add(batna);
			countryRepository.save(algeria);

			Region annaba = new Region("annaba");
			regionrepository.save(annaba);
			RegionsStatistics r2 = new RegionsStatistics(1,2,3,4,StatisticsTypes.Region);
			r2.setStatisticsRegion(annaba);
			r2.setStatisticsRegionName(annaba.getRegionName());
			r2.setStatisticsValidate(true);
			statisticsRepository.save(r2);
			annaba.setRegionStatistics(r2);

			regionrepository.save(annaba);
			annaba.setRegionCountry(algeria);
			annaba.setRegionRisk(RegionRisks.NonRisk);
			regionrepository.save(annaba);
			algeria.getCountryRegions().add(annaba);
			countryRepository.save(algeria);


			//--------------TEST STATISTICS -----------------------------
			/*
			RegionsStatistics constantineStatistics = new RegionsStatistics(11111, 11111, 11111, 11111,StatisticsTypes.Region);
			constantineStatistics.setStatisticsValidate(true);
			constantineStatistics.setStatisticsRegion(constantine);
			constantineStatistics.setStatisticsHealthAgent(healthagent);
			statisticsRepository.save(constantineStatistics);

			RegionsStatistics batnaStatistics = new RegionsStatistics(22222, 22222, 22222, 22222,StatisticsTypes.Region);
			batnaStatistics.setStatisticsValidate(false);
			batnaStatistics.setStatisticsHealthAgent(healthagent);
			batnaStatistics.setStatisticsRegion(batna);
			statisticsRepository.save(batnaStatistics);

			CountryStatistics algeriaStatistics = new CountryStatistics(33333, 33333, 33333, 33333,StatisticsTypes.Country);
			algeriaStatistics.setStatisticsValidate(true);
			algeriaStatistics.setStatisticsCountry(algeria);
			algeriaStatistics.setStatisticsHealthAgent(healthagent);
			constantineStatistics.setRegionsStatisticsCountryStatistics(algeriaStatistics);
			statisticsRepository.save(algeriaStatistics);

			 */

			readJsonCountries(countryRepository,regionrepository,statisticsRepository,regionsStatisticsRepository);

		};
	}
}





