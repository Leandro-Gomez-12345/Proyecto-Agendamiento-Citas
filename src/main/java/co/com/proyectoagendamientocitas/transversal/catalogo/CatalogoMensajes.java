package co.com.proyectoagendamientocitas.transversal.catalogo;

import co.com.proyectoagendamientocitas.transversal.utilitarios.UtilTexto;

public final class CatalogoMensajes {

	private static final String CONTACTAR_ADMINISTRADOR = " Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación y reporte la novedad.";

	private CatalogoMensajes() {

	}

	public static final class UtilSQL {

		private UtilSQL() {

		}

		public static final String USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_CONEXION_SQL_ESTA_ABIERTA = UtilTexto.concatenar("Se presentó un problema tratando de validar si la conexión con la fuente de información estaba abierta.", CONTACTAR_ADMINISTRADOR);
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_SI_CONEXION_SQL_ESTA_ABIERTA = UtilTexto.concatenar("Se presentó un problema NO CONTROLADO tratando de validar si la conexión con la fuente de información estaba abierta.", CONTACTAR_ADMINISTRADOR);
		public static final String USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_CONEXION_SQL_ES_VALIDA = UtilTexto.concatenar("Se presentó un problema tratando de validar si la conexión con la fuente de información está respondiendo.", CONTACTAR_ADMINISTRADOR);
		public static final String USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_TRANSACCION_SQL_ESTA_INICIADA = UtilTexto.concatenar("Se presentó un problema tratando de validar si la operación sobre la fuente de información ya estaba iniciada.", CONTACTAR_ADMINISTRADOR);
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_VALIDANDO_SI_TRANSACCION_SQL_ESTA_INICIADA = UtilTexto.concatenar("Se presentó un problema NO CONTROLADO tratando de validar si la operación sobre la fuente de información ya estaba iniciada.", CONTACTAR_ADMINISTRADOR);

		public static final String USUARIO_ERROR_CONEXION_SQL_NO_ESTA_ABIERTA = UtilTexto.concatenar("No es posible llevar a cabo la operación deseada porque la conexión con la fuente de información no está abierta.", CONTACTAR_ADMINISTRADOR);
		public static final String USUARIO_ERROR_CONEXION_SQL_NO_ES_VALIDA = UtilTexto.concatenar("La conexión con la fuente de información no está respondiendo.", CONTACTAR_ADMINISTRADOR);

		public static final String USUARIO_ERROR_NO_ES_POSIBLE_INICIAR_TRANSACCION_SQL = UtilTexto.concatenar("No es posible iniciar la operación deseada porque ya hay una operación en curso sobre la fuente de información.", CONTACTAR_ADMINISTRADOR);
		public static final String USUARIO_ERROR_INICIANDO_TRANSACCION_SQL = UtilTexto.concatenar("Se presentó un problema tratando de iniciar la operación sobre la fuente de información.", CONTACTAR_ADMINISTRADOR);
		public static final String USUARIO_ERROR_NO_ES_POSIBLE_CONFIRMAR_TRANSACCION_SQL = UtilTexto.concatenar("No es posible confirmar la operación porque no fue iniciada previamente.", CONTACTAR_ADMINISTRADOR);
		public static final String USUARIO_ERROR_CONFIRMANDO_TRANSACCION_SQL = UtilTexto.concatenar("Se presentó un problema tratando de confirmar los cambios en la fuente de información.", CONTACTAR_ADMINISTRADOR);
		public static final String USUARIO_ERROR_NO_ES_POSIBLE_CANCELAR_TRANSACCION_SQL = UtilTexto.concatenar("No es posible cancelar la operación porque no fue iniciada previamente.", CONTACTAR_ADMINISTRADOR);
		public static final String USUARIO_ERROR_CANCELANDO_TRANSACCION_SQL = UtilTexto.concatenar("Se presentó un problema tratando de deshacer los cambios en la fuente de información.", CONTACTAR_ADMINISTRADOR);
		public static final String USUARIO_ERROR_CERRANDO_CONEXION_SQL = UtilTexto.concatenar("Se presentó un problema tratando de cerrar la conexión con la fuente de información.", CONTACTAR_ADMINISTRADOR);
	}

	public static final class BarberiaImpl {

		private BarberiaImpl() {

		}

		public static final String USUARIO_ERROR_REGISTRANDO_BARBERIA = UtilTexto.concatenar("Se presentó un problema tratando de registrar la barbería.", CONTACTAR_ADMINISTRADOR);
		
	}

	public static final class TipoSociedadImpl {

		private TipoSociedadImpl() {

		}

		public static final String USUARIO_ERROR_CONSULTANDO_TIPOS_SOCIEDAD = UtilTexto.concatenar("Se presentó un problema tratando de consultar los tipos de sociedad.", CONTACTAR_ADMINISTRADOR);
	}

	public static final class Datos {

		private Datos() {

		}

		public static final String USUARIO_ERROR_ABRIENDO_CONEXION = UtilTexto.concatenar("Se presentó un problema tratando de abrir la conexión con la fuente de información.", CONTACTAR_ADMINISTRADOR);
		public static final String USUARIO_ERROR_FACTORIA_NO_HABILITADA = UtilTexto.concatenar("La fuente de información solicitada para llevar a cabo la operación no está habilitada.", CONTACTAR_ADMINISTRADOR);

		public static final String USUARIO_ERROR_CREANDO_BARBERIA = UtilTexto.concatenar("Se presentó un problema tratando de crear la información de la barbería.", CONTACTAR_ADMINISTRADOR);
		public static final String USUARIO_ERROR_CONSULTANDO_BARBERIA = UtilTexto.concatenar("Se presentó un problema tratando de consultar la información de la barbería.", CONTACTAR_ADMINISTRADOR);
		public static final String USUARIO_ERROR_ACTUALIZANDO_BARBERIA = UtilTexto.concatenar("Se presentó un problema tratando de actualizar la información de la barbería.", CONTACTAR_ADMINISTRADOR);
		public static final String USUARIO_ERROR_ELIMINANDO_BARBERIA = UtilTexto.concatenar("Se presentó un problema tratando de eliminar la información de la barbería.", CONTACTAR_ADMINISTRADOR);

		public static final String USUARIO_ERROR_CONSULTANDO_DIA_SEMANA = UtilTexto.concatenar("Se presentó un problema tratando de consultar la información del día de la semana.", CONTACTAR_ADMINISTRADOR);

		public static final String USUARIO_ERROR_CONSULTANDO_DEPARTAMENTO = UtilTexto.concatenar("Se presentó un problema tratando de consultar la información del departamento.", CONTACTAR_ADMINISTRADOR);

		public static final String USUARIO_ERROR_CONSULTANDO_ESTADO = UtilTexto.concatenar("Se presentó un problema tratando de consultar la información del estado.", CONTACTAR_ADMINISTRADOR);
		public static final String USUARIO_ERROR_ACTUALIZANDO_ESTADO = UtilTexto.concatenar("Se presentó un problema tratando de actualizar la información del estado.", CONTACTAR_ADMINISTRADOR);

		public static final String USUARIO_ERROR_CONSULTANDO_PREFIJO_CELULAR = UtilTexto.concatenar("Se presentó un problema tratando de consultar la información del prefijo de celular.", CONTACTAR_ADMINISTRADOR);

		public static final String USUARIO_ERROR_CONSULTANDO_TIPO_MULTA = UtilTexto.concatenar("Se presentó un problema tratando de consultar la información del tipo de multa.", CONTACTAR_ADMINISTRADOR);

		public static final String USUARIO_ERROR_CONSULTANDO_TIPO_SOCIEDAD = UtilTexto.concatenar("Se presentó un problema tratando de consultar la información del tipo de sociedad.", CONTACTAR_ADMINISTRADOR);

		public static final String USUARIO_ERROR_CREANDO_FESTIVO = UtilTexto.concatenar("Se presentó un problema tratando de crear la información del festivo.", CONTACTAR_ADMINISTRADOR);
		public static final String USUARIO_ERROR_CONSULTANDO_FESTIVO = UtilTexto.concatenar("Se presentó un problema tratando de consultar la información del festivo.", CONTACTAR_ADMINISTRADOR);
		public static final String USUARIO_ERROR_ACTUALIZANDO_FESTIVO = UtilTexto.concatenar("Se presentó un problema tratando de actualizar la información del festivo.", CONTACTAR_ADMINISTRADOR);
		public static final String USUARIO_ERROR_ELIMINANDO_FESTIVO = UtilTexto.concatenar("Se presentó un problema tratando de eliminar la información del festivo.", CONTACTAR_ADMINISTRADOR);

		public static final String USUARIO_ERROR_CREANDO_CLIENTE = UtilTexto.concatenar("Se presentó un problema tratando de crear la información del cliente.", CONTACTAR_ADMINISTRADOR);
		public static final String USUARIO_ERROR_CONSULTANDO_CLIENTE = UtilTexto.concatenar("Se presentó un problema tratando de consultar la información del cliente.", CONTACTAR_ADMINISTRADOR);
		public static final String USUARIO_ERROR_ACTUALIZANDO_CLIENTE = UtilTexto.concatenar("Se presentó un problema tratando de actualizar la información del cliente.", CONTACTAR_ADMINISTRADOR);

		public static final String USUARIO_ERROR_CONSULTANDO_CIUDAD = UtilTexto.concatenar("Se presentó un problema tratando de consultar la información de la ciudad.", CONTACTAR_ADMINISTRADOR);

		public static final String USUARIO_ERROR_CREANDO_SEDE = UtilTexto.concatenar("Se presentó un problema tratando de crear la información de la sede.", CONTACTAR_ADMINISTRADOR);
		public static final String USUARIO_ERROR_CONSULTANDO_SEDE = UtilTexto.concatenar("Se presentó un problema tratando de consultar la información de la sede.", CONTACTAR_ADMINISTRADOR);
		public static final String USUARIO_ERROR_ACTUALIZANDO_SEDE = UtilTexto.concatenar("Se presentó un problema tratando de actualizar la información de la sede.", CONTACTAR_ADMINISTRADOR);
		public static final String USUARIO_ERROR_ELIMINANDO_SEDE = UtilTexto.concatenar("Se presentó un problema tratando de eliminar la información de la sede.", CONTACTAR_ADMINISTRADOR);

		public static final String USUARIO_ERROR_CREANDO_BARBERO = UtilTexto.concatenar("Se presentó un problema tratando de crear la información del barbero.", CONTACTAR_ADMINISTRADOR);
		public static final String USUARIO_ERROR_CONSULTANDO_BARBERO = UtilTexto.concatenar("Se presentó un problema tratando de consultar la información del barbero.", CONTACTAR_ADMINISTRADOR);
		public static final String USUARIO_ERROR_ACTUALIZANDO_BARBERO = UtilTexto.concatenar("Se presentó un problema tratando de actualizar la información del barbero.", CONTACTAR_ADMINISTRADOR);
		public static final String USUARIO_ERROR_ELIMINANDO_BARBERO = UtilTexto.concatenar("Se presentó un problema tratando de eliminar la información del barbero.", CONTACTAR_ADMINISTRADOR);

		public static final String USUARIO_ERROR_CREANDO_HORARIO_SEDE = UtilTexto.concatenar("Se presentó un problema tratando de crear la información del horario de la sede.", CONTACTAR_ADMINISTRADOR);
		public static final String USUARIO_ERROR_CONSULTANDO_HORARIO_SEDE = UtilTexto.concatenar("Se presentó un problema tratando de consultar la información del horario de la sede.", CONTACTAR_ADMINISTRADOR);
		public static final String USUARIO_ERROR_ACTUALIZANDO_HORARIO_SEDE = UtilTexto.concatenar("Se presentó un problema tratando de actualizar la información del horario de la sede.", CONTACTAR_ADMINISTRADOR);

		public static final String USUARIO_ERROR_CREANDO_SERVICIO = UtilTexto.concatenar("Se presentó un problema tratando de crear la información del servicio.", CONTACTAR_ADMINISTRADOR);
		public static final String USUARIO_ERROR_CONSULTANDO_SERVICIO = UtilTexto.concatenar("Se presentó un problema tratando de consultar la información del servicio.", CONTACTAR_ADMINISTRADOR);
		public static final String USUARIO_ERROR_ACTUALIZANDO_SERVICIO = UtilTexto.concatenar("Se presentó un problema tratando de actualizar la información del servicio.", CONTACTAR_ADMINISTRADOR);

		public static final String USUARIO_ERROR_CREANDO_PERIODO_CIERRE = UtilTexto.concatenar("Se presentó un problema tratando de crear la información del periodo de cierre.", CONTACTAR_ADMINISTRADOR);
		public static final String USUARIO_ERROR_CONSULTANDO_PERIODO_CIERRE = UtilTexto.concatenar("Se presentó un problema tratando de consultar la información del periodo de cierre.", CONTACTAR_ADMINISTRADOR);
		public static final String USUARIO_ERROR_ACTUALIZANDO_PERIODO_CIERRE = UtilTexto.concatenar("Se presentó un problema tratando de actualizar la información del periodo de cierre.", CONTACTAR_ADMINISTRADOR);
		public static final String USUARIO_ERROR_ELIMINANDO_PERIODO_CIERRE = UtilTexto.concatenar("Se presentó un problema tratando de eliminar la información del periodo de cierre.", CONTACTAR_ADMINISTRADOR);

		public static final String USUARIO_ERROR_CREANDO_FECHA_FESTIVO = UtilTexto.concatenar("Se presentó un problema tratando de crear la información de la apertura de un festivo.", CONTACTAR_ADMINISTRADOR);
		public static final String USUARIO_ERROR_CONSULTANDO_FECHA_FESTIVO = UtilTexto.concatenar("Se presentó un problema tratando de consultar la información de la apertura de un festivo.", CONTACTAR_ADMINISTRADOR);
		public static final String USUARIO_ERROR_ELIMINANDO_FECHA_FESTIVO = UtilTexto.concatenar("Se presentó un problema tratando de eliminar la información de la apertura de un festivo.", CONTACTAR_ADMINISTRADOR);

		public static final String USUARIO_ERROR_CREANDO_BARBERO_SERVICIO = UtilTexto.concatenar("Se presentó un problema tratando de crear la información del servicio del barbero.", CONTACTAR_ADMINISTRADOR);
		public static final String USUARIO_ERROR_CONSULTANDO_BARBERO_SERVICIO = UtilTexto.concatenar("Se presentó un problema tratando de consultar la información del servicio del barbero.", CONTACTAR_ADMINISTRADOR);
		public static final String USUARIO_ERROR_ACTUALIZANDO_BARBERO_SERVICIO = UtilTexto.concatenar("Se presentó un problema tratando de actualizar la información del servicio del barbero.", CONTACTAR_ADMINISTRADOR);

		public static final String USUARIO_ERROR_CREANDO_BLOQUEO = UtilTexto.concatenar("Se presentó un problema tratando de crear la información del bloqueo.", CONTACTAR_ADMINISTRADOR);
		public static final String USUARIO_ERROR_CONSULTANDO_BLOQUEO = UtilTexto.concatenar("Se presentó un problema tratando de consultar la información del bloqueo.", CONTACTAR_ADMINISTRADOR);
		public static final String USUARIO_ERROR_ACTUALIZANDO_BLOQUEO = UtilTexto.concatenar("Se presentó un problema tratando de actualizar la información del bloqueo.", CONTACTAR_ADMINISTRADOR);
		public static final String USUARIO_ERROR_ELIMINANDO_BLOQUEO = UtilTexto.concatenar("Se presentó un problema tratando de eliminar la información del bloqueo.", CONTACTAR_ADMINISTRADOR);

		public static final String USUARIO_ERROR_CREANDO_HORARIO_BARBERO = UtilTexto.concatenar("Se presentó un problema tratando de crear la información del horario del barbero.", CONTACTAR_ADMINISTRADOR);
		public static final String USUARIO_ERROR_CONSULTANDO_HORARIO_BARBERO = UtilTexto.concatenar("Se presentó un problema tratando de consultar la información del horario del barbero.", CONTACTAR_ADMINISTRADOR);
		public static final String USUARIO_ERROR_ACTUALIZANDO_HORARIO_BARBERO = UtilTexto.concatenar("Se presentó un problema tratando de actualizar la información del horario del barbero.", CONTACTAR_ADMINISTRADOR);

		public static final String USUARIO_ERROR_CREANDO_AGENDA = UtilTexto.concatenar("Se presentó un problema tratando de crear la información de la agenda.", CONTACTAR_ADMINISTRADOR);
		public static final String USUARIO_ERROR_CONSULTANDO_AGENDA = UtilTexto.concatenar("Se presentó un problema tratando de consultar la información de la agenda.", CONTACTAR_ADMINISTRADOR);

		public static final String USUARIO_ERROR_CREANDO_CITA = UtilTexto.concatenar("Se presentó un problema tratando de crear la información de la cita.", CONTACTAR_ADMINISTRADOR);
		public static final String USUARIO_ERROR_CONSULTANDO_CITA = UtilTexto.concatenar("Se presentó un problema tratando de consultar la información de la cita.", CONTACTAR_ADMINISTRADOR);
		public static final String USUARIO_ERROR_ACTUALIZANDO_CITA = UtilTexto.concatenar("Se presentó un problema tratando de actualizar la información de la cita.", CONTACTAR_ADMINISTRADOR);

		public static final String USUARIO_ERROR_CREANDO_CITA_SERVICIO = UtilTexto.concatenar("Se presentó un problema tratando de crear la información del servicio de la cita.", CONTACTAR_ADMINISTRADOR);
		public static final String USUARIO_ERROR_CONSULTANDO_CITA_SERVICIO = UtilTexto.concatenar("Se presentó un problema tratando de consultar la información del servicio de la cita.", CONTACTAR_ADMINISTRADOR);

		public static final String USUARIO_ERROR_CREANDO_MULTA = UtilTexto.concatenar("Se presentó un problema tratando de crear la información de la multa.", CONTACTAR_ADMINISTRADOR);
		public static final String USUARIO_ERROR_CONSULTANDO_MULTA = UtilTexto.concatenar("Se presentó un problema tratando de consultar la información de la multa.", CONTACTAR_ADMINISTRADOR);
		public static final String USUARIO_ERROR_ACTUALIZANDO_MULTA = UtilTexto.concatenar("Se presentó un problema tratando de actualizar la información de la multa.", CONTACTAR_ADMINISTRADOR);
		public static final String USUARIO_ERROR_ELIMINANDO_MULTA = UtilTexto.concatenar("Se presentó un problema tratando de eliminar la información de la multa.", CONTACTAR_ADMINISTRADOR);
	}
	
	public static final class Reglas {

		private Reglas() {

		}

		public static final String DATO_OBLIGATORIO = "El dato %s es obligatorio.";
		public static final String LONGITUD_NO_VALIDA = "El dato %s debe tener entre %d y %d caracteres.";
		public static final String FORMATO_NO_VALIDO = "El dato %s no cumple con el formato permitido: %s.";
		public static final String RANGO_NO_VALIDO = "El dato %s debe estar entre %d y %d.";

		public static final String ASEGURAR_AGENDA_NO_EN_FESTIVO_SIN_APERTURA = "La fecha es festivo y la sede no tiene registrada su apertura ese día; por defecto las sedes no atienden los festivos.";
		public static final String ASEGURAR_AGENDA_NO_EXISTA = "Ya existe una agenda para ese horario del barbero y esa fecha.";
		public static final String ASEGURAR_ANIO_CON_FESTIVOS = "El año no tiene festivos registrados; primero se deben generar.";
		public static final String ASEGURAR_ANIO_FESTIVOS_ACTUAL_O_SIGUIENTE = "Solo se pueden generar los festivos del año actual o del año siguiente.";
		public static final String ASEGURAR_ANIO_SIN_FESTIVOS = "El año ya tiene festivos registrados; se deben actualizar en lugar de volver a generarse.";
		public static final String ASEGURAR_BARBERO_ES_DE_LA_CITA = "Solo el barbero de la cita puede cambiar su estado o cancelarla.";
		public static final String ASEGURAR_BARBERO_ES_DE_LA_MULTA = "Solo el barbero de la cita que originó la multa puede registrar su pago o eliminarla.";
		public static final String ASEGURAR_BARBERO_NO_VIGENTE = "El barbero se encuentra vigente y por lo tanto no es posible reactivarlo.";
		public static final String ASEGURAR_BARBERO_SERVICIO_NO_VIGENTE = "El servicio del barbero se encuentra activo y por lo tanto no es posible reactivarlo.";
		public static final String ASEGURAR_BARBERO_SERVICIO_VIGENTE = "El servicio del barbero ya se encuentra desactivado.";
		public static final String ASEGURAR_BARBERO_VIGENTE = "El barbero ya no se encuentra vigente.";
		public static final String ASEGURAR_BLOQUEO_NO_SE_CRUCE = "El bloqueo se cruza con otro bloqueo del mismo barbero.";
		public static final String ASEGURAR_CAMBIO_ESTADO_EN_FECHA_DE_LA_CITA = "El estado de la cita solo se puede cambiar el mismo día de la cita.";
		public static final String ASEGURAR_CANCELACION_BARBERO_CON_ANTICIPACION = "Ya no es posible cancelar la cita porque faltan menos de 2 horas para su hora de inicio.";
		public static final String ASEGURAR_CANCELACION_CLIENTE_CON_ANTICIPACION = "Ya no es posible cancelar la cita porque faltan menos de 2 horas para su hora de inicio.";
		public static final String ASEGURAR_CELULAR_BARBERO_NO_EXISTA = "Ya existe otro barbero registrado con ese prefijo y número de celular.";
		public static final String ASEGURAR_CELULAR_CLIENTE_NO_EXISTA = "Ya existe otro cliente registrado con ese prefijo y número de celular.";
		public static final String ASEGURAR_CITA_AGENDADA = "La cita no se encuentra en estado Agendada.";
		public static final String ASEGURAR_CITA_DENTRO_DE_QUINCE_DIAS = "Solo es posible agendar una cita hasta 15 días después del día actual.";
		public static final String ASEGURAR_CITA_NO_SOLICITADA_EN_EL_PASADO = "La cita no se puede solicitar para una fecha y hora que ya pasaron.";
		public static final String ASEGURAR_CITA_PUEDE_FINALIZARSE = "La cita no se encuentra en un estado desde el que se pueda finalizar.";
		public static final String ASEGURAR_CITA_PUEDE_REGISTRARSE_NO_PAGADA = "La cita no se encuentra en un estado desde el que se pueda registrar el no pago.";
		public static final String ASEGURAR_DENOMINACION_BARBERIA_NO_EXISTA = "Ya existe una barbería registrada con esa denominación.";
		public static final String ASEGURAR_DENOMINACION_BARBERIA_SIN_SUFIJO_SOCIEDAD = "La denominación no debe terminar en un sufijo de tipo de sociedad (S.A.S., SAS, Ltda., Limitada, S.A., SA); el sistema lo agrega según el tipo de sociedad elegido.";
		public static final String ASEGURAR_DURACION_SERVICIO_BARBERO_MAYOR_CERO = "La suma del tiempo en horas y minutos para realizar el servicio debe ser mayor a cero.";
		public static final String ASEGURAR_EXISTE_BARBERIA_CON_ID = "No existe la barbería con el identificador enviado y por lo tanto no es posible llevar a cabo la operación.";
		public static final String ASEGURAR_EXISTE_BARBERO_CON_ID = "No existe el barbero con el identificador enviado y por lo tanto no es posible llevar a cabo la operación.";
		public static final String ASEGURAR_EXISTE_BARBERO_SERVICIO_CON_ID = "No existe el servicio del barbero con el identificador enviado y por lo tanto no es posible llevar a cabo la operación.";
		public static final String ASEGURAR_EXISTE_BLOQUEO_CON_ID = "No existe el bloqueo con el identificador enviado y por lo tanto no es posible llevar a cabo la operación.";
		public static final String ASEGURAR_EXISTE_CITA_CON_ID = "No existe la cita con el identificador enviado y por lo tanto no es posible llevar a cabo la operación.";
		public static final String ASEGURAR_EXISTE_CIUDAD_CON_ID = "No existe la ciudad con el identificador enviado y por lo tanto no es posible llevar a cabo la operación.";
		public static final String ASEGURAR_EXISTE_CLIENTE_CON_ID ="No existe el cliente con el identificador enviado y por lo tanto no es posible llevar a cabo la operación.";
		public static final String ASEGURAR_EXISTE_ESTADO_CON_ID = "No existe el estado con el identificador enviado y por lo tanto no es posible llevar a cabo la operación.";
		public static final String ASEGURAR_EXISTE_FECHA_FESTIVO_CON_ID = "No existe la apertura de un festivo con el identificador enviado y por lo tanto no es posible llevar a cabo la operación.";
		public static final String ASEGURAR_EXISTE_FESTIVO_CON_ID = "No existe el festivo con el identificador enviado y por lo tanto no es posible llevar a cabo la operación.";
		public static final String ASEGURAR_EXISTE_HORARIO_BARBERO_CON_ID = "No existe el horario del barbero con el identificador enviado y por lo tanto no es posible llevar a cabo la operación.";
		public static final String ASEGURAR_EXISTE_HORARIO_SEDE_CON_ID = "No existe el horario de la sede con el identificador enviado y por lo tanto no es posible llevar a cabo la operación.";
		public static final String ASEGURAR_EXISTE_MULTA_CON_ID = "No existe la multa con el identificador enviado y por lo tanto no es posible llevar a cabo la operación.";
		public static final String ASEGURAR_EXISTE_PERIODO_CIERRE_CON_ID = "No existe el periodo de cierre con el identificador enviado y por lo tanto no es posible llevar a cabo la operación.";
		public static final String ASEGURAR_EXISTE_SEDE_CON_ID = "No existe la sede con el identificador enviado y por lo tanto no es posible llevar a cabo la operación.";
		public static final String ASEGURAR_EXISTE_SERVICIO_CON_ID = "No existe el servicio con el identificador enviado y por lo tanto no es posible llevar a cabo la operación.";
		public static final String ASEGURAR_EXISTE_TIPO_SOCIEDAD_CON_ID = "No existe el tipo de sociedad con el identificador enviado y por lo tanto no es posible llevar a cabo la operación.";
		public static final String ASEGURAR_FECHA_FESTIVO_NO_EXISTA = "La sede ya tiene registrada la apertura de ese festivo.";
		public static final String ASEGURAR_FECHA_HORA_FINAL_MAYOR_INICIO_BLOQUEO = "La fecha y hora de fin del bloqueo debe ser mayor a la fecha y hora de inicio.";
		public static final String ASEGURAR_FECHA_HORA_FINAL_MAYOR_INICIO_PERIODO_CIERRE = "La fecha y hora final del periodo de cierre debe ser mayor a la fecha y hora de inicio.";
		public static final String ASEGURAR_FESTIVO_CON_FECHA_NO_EXISTA = "Ya existe un festivo registrado con esa fecha.";
		public static final String ASEGURAR_FESTIVO_FUTURO = "Solo se pueden registrar, cambiar o eliminar festivos con fecha posterior al día actual.";
		public static final String ASEGURAR_FESTIVO_NO_HA_LLEGADO = "El festivo ya llegó y por lo tanto no es posible eliminar su apertura.";
		public static final String ASEGURAR_FESTIVO_NO_HA_PASADO = "El festivo ya pasó: su fecha debe ser igual o posterior al día actual.";
		public static final String ASEGURAR_HORARIO_BARBERO_VIGENTE = "El horario de trabajo ya se encuentra desactivado y por lo tanto no puede volver a desactivarse.";
		public static final String ASEGURAR_HORARIO_SEDE_NO_SE_CRUCE = "El horario se cruza en horas con otro horario vigente de la misma sede el mismo día de la semana.";
		public static final String ASEGURAR_HORARIO_SEDE_VIGENTE = "El horario de la sede ya no se encuentra vigente y por lo tanto no es posible modificarlo ni desactivarlo.";
		public static final String ASEGURAR_HORA_CIERRE_MAYOR_APERTURA = "La hora de cierre debe ser mayor a la hora de apertura.";
		public static final String ASEGURAR_HORA_FINAL_MAYOR_INICIO_HORARIO_BARBERO = "La hora de fin del horario de trabajo debe ser mayor a la hora de inicio.";
		public static final String ASEGURAR_HORA_FIN_ESTIMADA_CITA_YA_PASO = "La cita todavía no ha terminado según su hora estimada de finalización; el cliente aún puede llegar.";
		public static final String ASEGURAR_HORA_INICIO_CITA_YA_PASO = "Todavía no ha llegado la hora de inicio de la cita.";
		public static final String ASEGURAR_INICIO_PERIODO_CIERRE_FUTURO = "El periodo de cierre no puede empezar en un momento que ya pasó.";
		public static final String ASEGURAR_MULTA_DE_TIPO_NO_EXISTA_PARA_CITA = "La cita ya tiene una multa de ese tipo.";
		public static final String ASEGURAR_MULTA_NO_PAGADA = "La multa ya se encuentra pagada.";
		public static final String ASEGURAR_NIT_BARBERIA_NO_EXISTA = "Ya existe una barbería registrada con ese NIT.";
		public static final String ASEGURAR_NOMBRE_SEDE_NO_EXISTA_EN_BARBERIA = "Ya existe una sede con ese nombre en la barbería.";
		public static final String ASEGURAR_NOMBRE_SERVICIO_NO_EXISTA_EN_SEDE = "Ya existe un servicio con ese nombre en la sede.";
		public static final String ASEGURAR_NUMERO_CELULAR_BARBERO_CORRECTO = "El barbero debe confirmar que su número de celular es correcto.";
		public static final String ASEGURAR_PERIODO_CIERRE_NO_INICIADO = "El periodo de cierre ya empezó y por lo tanto no es posible eliminarlo.";
		public static final String ASEGURAR_PERIODO_CIERRE_NO_SE_CRUCE = "El periodo de cierre se cruza con otro periodo de cierre de la misma sede.";
		public static final String ASEGURAR_PERIODO_CIERRE_NO_TERMINADO = "El periodo de cierre ya terminó y por lo tanto no es posible cambiarlo.";
		public static final String ASEGURAR_SEDE_CON_HORARIO_EL_DIA_DEL_FESTIVO = "La sede no tiene ningún horario vigente el día de la semana en que cae el festivo.";
		public static final String ASEGURAR_SEDE_SIN_BARBEROS_TRABAJANDO = "La sede tiene barberos trabajando actualmente y no se puede dar de baja.";
		public static final String ASEGURAR_SERVICIO_DISPONIBLE = "El servicio ya se encuentra retirado.";
		public static final String ASEGURAR_SERVICIO_NO_HABILITADO_PARA_BARBERO = "El barbero ya tiene habilitado ese mismo servicio.";
		public static final String ASEGURAR_SERVICIO_RETIRADO = "El servicio se encuentra disponible y por lo tanto no es necesario volver a ofrecerlo.";
		public static final String ASEGURAR_TIEMPO_ESPERA_CITA_YA_PASO = "Todavía no ha pasado la hora de inicio de la cita más su tiempo de espera.";
	}
	
	public static final class AbstractRestController {
		
		private AbstractRestController() {
			
		}
		
		public static final String RECURSO_NO_EXISTE = "El recurso %s solicitado con el método %s no existe.";
		public static final String ERROR_NO_CONTROLADO = UtilTexto.concatenar("Se ha presentado un error inesperado tratando de llevar a cabo la operación deseada.",
				" Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación y entréguele el código de la respuesta (correlationId).");
	}
}
