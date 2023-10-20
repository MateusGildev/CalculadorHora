import java.time.Duration;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;


public class Main {
    public static void main(String[] args) {



            ZoneId fusoHorario = ZoneId.of("Europe/Paris");
            ZonedDateTime horaAtual = ZonedDateTime.now(fusoHorario);
            LocalTime horaLancamento = LocalTime.MIDNIGHT;
            ZonedDateTime zonedDateTimeLancamento = horaLancamento.atDate(horaAtual.toLocalDate()).atZone(fusoHorario);

            Duration horaCalculada = Duration.between(horaAtual , zonedDateTimeLancamento);

            if (horaCalculada.isNegative()) {
                horaCalculada = horaCalculada.plusDays(1);
            }

        long tempoHoras = horaCalculada.toHours();
        long tempoMInutos = horaCalculada.toMinutes() % 60;
        long tempoSegundos = horaCalculada.toSeconds() % 60;

        System.out.println("FALTAM " + tempoHoras + " HORAS");
        System.out.println(tempoMInutos + " MINUTOS");
        System.out.println(tempoSegundos + " SEGUNDOS");

    }
}