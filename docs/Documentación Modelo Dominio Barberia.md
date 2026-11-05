# Documentación Modelo de Dominio — Barbería

**Otras secciones:** [Relaciones del modelo de dominio](#relaciones-del-modelo-de-dominio)

## Objetos de dominio

| # | Objeto | Descripción | Línea de vida |
|---|---|---|---|
| 1 | [DiaSemana](#diasemana) | Representa cada uno de los días de la semana que se usa como catálogo para definir los horarios de la barbería y de cada barbero. | 1 |
| 2 | [Departamento](#departamento) | Representa cada uno de los departamentos del país en los que se encuentran las ciudades donde la barbería puede tener sedes. | 1 |
| 3 | [Estado](#estado) | Representa en qué situación puntual se encuentra una cita: agendada, finalizada, cancelada por alguna de las partes, por cambio de políticas de la barbería o por veto, con demora del cliente o del barbero, con inasistencia del cliente o sin pago. | 1 |
| 4 | [PrefijoCelular](#prefijocelular) | Representa el catálogo de prefijos telefónicos, que los van a usar los clientes y barberos. | 1 |
| 5 | [TipoMulta](#tipomulta) | Representa los tipos de multa que puede recibir un cliente: por tardanza, por inasistencia o por no pagar los servicios recibidos. | 1 |
| 6 | [Festivo](#festivo) | Representa cada fecha festiva de Colombia en la que, por ley, es día de descanso. El sistema genera automáticamente los festivos de cada año a partir del calendario oficial de festivos, con la fecha en la que realmente se descansa (ya trasladada al lunes cuando la ley lo indica). Por defecto ninguna sede abre en un festivo. | 1 |
| 7 | [TipoSociedad](#tiposociedad) | Representa el catálogo de tipos de sociedad con los que puede estar constituida legalmente una barbería ante la Cámara de Comercio (S.A.S., Ltda. o S.A.), cada uno con el sufijo que se agrega al final de su razón social. | 1 |
| 8 | [Barberia](#barberia) | Representa la cadena o marca comercial de barbería, dueña de una o varias sedes. | 2 |
| 9 | [Cliente](#cliente) | Representa a la persona que solicita citas en las sedes de una o varias barberías. Si tiene multas sin pagar en una barbería, no puede agendar en ninguna de sus sedes, pero sí en las demás barberías. | 2 |
| 10 | [Ciudad](#ciudad) | Representa cada una de las ciudades, pertenecientes a un departamento, en las que puede estar ubicada una sede de la barbería. | 2 |
| 11 | [Sede](#sede) | Representa cada una de las sucursales físicas de una barbería, ubicada en una ciudad puntual, donde se ofrecen los servicios y trabajan los barberos. | 3 |
| 12 | [Barbero](#barbero) | Representa a un trabajador de la barbería que atiende clientes según los servicios que sabe realizar, organiza su propio horario y tiene su agenda personal para atender todas las citas que valla teniendo. | 4 |
| 13 | [HorarioSede](#horariosede) | Representa los horarios de apertura y cierre de una sede de la barbería para cada día de la semana; una sede puede tener varios horarios el mismo día (jornada partida) si no se cruzan. El administrador puede definirlos para todas las sedes a la vez o para una sede en particular, y son el límite dentro del cual debe caber el horario de cualquier barbero de esa sede. | 4 |
| 14 | [Servicio](#servicio) | Representa cada tipo de corte o arreglo que ofrece una sede de la barbería; el administrador puede definirlo para todas las sedes a la vez o para una sede en particular, y cada barbero decide cuáles sabe hacer. | 4 |
| 15 | [PeriodoCierre](#periodocierre) | Representa un intervalo de fecha y hora durante el cual una sede de la barbería permanece cerrada por una decisión de la barbería (por ejemplo vacaciones, mantenimiento o remodelación): mientras dura no se atiende a clientes ni se pueden agendar citas que se crucen con él. El administrador puede registrarlo para todas las sedes de la barbería a la vez o para una sede en particular. | 4 |
| 16 | [SedeFestivo](#sedefestivo) | Representa la decisión de una sede de abrir en un festivo puntual. Por defecto ninguna sede abre en los festivos; si la sede tiene registrado el festivo, ese día atiende con su horario habitual del día de la semana en que cae. El administrador puede definirla para todas las sedes a la vez o para una sede en particular. | 4 |
| 17 | [BarberoServicio](#barberoservicio) | Representa qué servicios sabe hacer cada barbero, cuánto se demora en realizarlos y cuánto tiempo extra usa de colchón, ya que no todos los barberos ofrecen los mismos servicios que están en la barbería. | 5 |
| 18 | [Bloqueo](#bloqueo) | Representa los momentos en que el barbero no esta disponible para atender sus citas, el barbero establece la hora y la fecha en que empieza y termina ese estado de no disponible. | 5 |
| 19 | [HorarioBarbero](#horariobarbero) | Representa el día de la semana en que trabaja un barbero, junto con la hora en la que empieza y termina su jornada de trabajo. | 5 |
| 20 | [Agenda](#agenda) | Representa una fecha puntual en donde el barbero ve todas las citas que debe de atender ese día. El sistema la crea con anticipación, de modo que siempre haya agendas desde hoy hasta 15 días después. | 6 |
| 21 | [Cita](#cita) | Representa la reserva de un cliente con un barbero para un fecha y hora puntual, con los servicios pedidos, su estado, y lo que realmente ocurrió (atención, tardanzas, inasistencia). | 7 |
| 22 | [CitaServicio](#citaservicio) | Representa cada servicio incluido dentro de una cita puntual, guardando el precio y la duración que tenía ese servicio para ese barbero en el momento exacto en que se agendó, para que cambios futuros en el catálogo no alteren citas ya registradas. | 8 |
| 23 | [Multa](#multa) | Representa la sanción económica que se le impone a un cliente por incumplir una cita, ya sea por llegar tarde fuera de tolerancia, por no presentarse o por no pagar los servicios recibidos, calculada a partir de la cita específica que la originó. Mientras siga sin pagar, el cliente queda vetado en la barbería donde se originó. | 8 |

---

## DiaSemana

**Descripción:** Representa cada uno de los días de la semana que se usa como catálogo para definir los horarios de la barbería y de cada barbero.  
**Línea de vida:** 1

### Muestreo de datos

- **id**: Representa un identificador que hará unico cada objeto de dominio de este tipo, no se puede repetir
- **nombre**: Representa como se llama el dia de la semana, para los horarios
- **Combinación única **: Combinacion única que indica que no puede existir más un dia de la semana con el mismo nombre

| id | nombre | Combinación única  |
|---|---|---|
| 1 | Lunes | Lunes |
| 2 | Martes | Martes |
| 3 | Miércoles | Miércoles |
| 4 | Jueves | Jueves |
| 5 | Viernes | Viernes |
| 6 | Sábado | Sábado |
| 7 | Domingo | Domingo |

**Combinaciones únicas y datos tomados de otros objetos:**

- **Combinación única**: formada por `nombre`.

**Clasificación de las columnas del muestreo:**

- Corresponde al identificador unico del objeto de dominio: id
- Corresponde a los datos que ingresa el usuario: nombre
- Corresponde a la combinacion única: Combinación única 

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Rendondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | VerDiasDeLaSemana |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| id | Representa un identificador que hará unico cada objeto de dominio de este tipo, no se puede repetir | Si | Identificador único universal | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No | No aplica | No aplica | No aplica | No aplica | No | UUID vacio | Si | No mostrar |
| nombre | Representa como se llama el dia de la semana, para los horarios | No | Alfanumérico | Si | 5 | 9 | No aplica | No aplica | No aplica | No aplica | No aplica | Solo pueden ser los dias de la semana como Lunes, Martes, Miércoles, Jueves, Viernes, Sábado y Domingo | No | No aplica | No aplica | Si | Si | No | Vacio | No | Mostrar |

| Nombre combinación única | Descripción | Atributos involucrados |
|---|---|---|
| Combinación única  | Combinacion única que indica que no puede existir más un dia de la semana con el mismo nombre | nombre |

| Responsabilidad | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Salida / Descripción | Políticas (Reglas de Negocio) / Política | Políticas (Reglas de Negocio) / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |
|---|---|---|---|---|---|---|---|---|---|---|
| VerDiasDeLaSemana | Permite consultar el catálogo de días de la semana para definir los horarios |  |  |  | Lista<DiaSemana> | Contiene todos los días de la semana |  |  |  |  |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Administrador | Ver los días de las semanas | Permite consultar el catálogo de días de la semana disponibles para definir horarios | DiaSemana |  |  |  |  |  | Días de la semana consultados |  |
| Barbero | Ver los días de las semanas | Permite consultar el catálogo de días de la semana disponibles para definir horarios | DiaSemana |  |  |  |  |  | Días de la semana consultados |  |

### Políticas

> No aplica: es un catálogo de solo lectura, sin comandos que impliquen políticas de negocio propias

[↑ Volver al índice](#objetos-de-dominio)

---

## Departamento

**Descripción:** Representa cada uno de los departamentos del país en los que se encuentran las ciudades donde la barbería puede tener sedes.  
**Línea de vida:** 1

### Muestreo de datos

- **id**: Representa un identificador que hará unico cada objeto de dominio de este tipo, no se puede repetir
- **nombre**: Representa el nombre del departamento en el que están ubicadas las ciudades donde la barbería puede tener sedes
- **Combinación única**: Combinación única que indica que no puede existir más de un departamento con el mismo nombre

| id | nombre | Combinación única |
|---|---|---|
| 1 | Antioquia | Antioquia |
| 2 | Cundinamarca | Cundinamarca |
| 3 | Valle del Cauca | Valle del Cauca |
| 4 | Atlántico | Atlántico |
| 5 | Santander | Santander |

**Combinaciones únicas y datos tomados de otros objetos:**

- **Combinación única**: formada por `nombre`.

**Clasificación de las columnas del muestreo:**

- Corresponde al identificador unico del objeto de dominio: id
- Corresponde a los datos de libre ingreso: nombre
- Corresponde a la combinacion única: Combinación única

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Rendondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | consultarDepartamentos |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| id | Representa un identificador que hará unico cada objeto de dominio de este tipo, no se puede repetir | Si | Identificador único universal | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No | No aplica | No aplica | No aplica | No aplica | No | UUID vacio | Si | No mostrar |
| nombre | Representa el nombre del departamento en el que están ubicadas las ciudades donde la barbería puede tener sedes | No | Alfanumérico | Si | 4 | 60 | No aplica | No aplica | No aplica | No aplica | No aplica | Permite caracterez de la 'a' a la 'z' minusculas y mayusculas, con espacios en blanco y esas letras pero con tilde | No | No aplica | No aplica | Si | Si | No | Vacio | No | Mostrar |

| Nombre combinación única | Descripción | Atributos involucrados |
|---|---|---|
| Combinación única | Combinación única que indica que no puede existir más de un departamento con el mismo nombre | nombre |

| Responsabilidad | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Salida / Descripción | Políticas (Reglas de Negocio) / Política | Políticas (Reglas de Negocio) / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |
|---|---|---|---|---|---|---|---|---|---|---|
| consultarDepartamentos | Permite consultar el catálogo de departamentos disponibles |  |  |  | Lista<Departamento> | Contiene todos los departamentos registrados |  |  |  |  |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Administrador | Ver los departamentos | Permite consultar el catálogo de departamentos en los que se pueden ubicar las ciudades de las sedes | Departamento |  |  |  |  |  | Departamentos consultados |  |

### Políticas

> No aplica: es un catálogo de solo lectura, sin comandos que impliquen políticas de negocio propias

[↑ Volver al índice](#objetos-de-dominio)

---

## Estado

**Descripción:** Representa en qué situación puntual se encuentra una cita: agendada, finalizada, cancelada por alguna de las partes, por cambio de políticas de la barbería o por veto, con demora del cliente o del barbero, con inasistencia del cliente o sin pago.  
**Línea de vida:** 1

### Muestreo de datos

- **id**: Representa un identificador que hará unico cada objeto de dominio de este tipo, no se puede repetir
- **nombre**: Representa como se llama el estado en el que se encuentra una cita puntual
- **descripcion**: Representa el significado de que representa cada estado para la cita
- **Combinación única **: Combinacion única que indica que no puede existir más un dia de la semana con el mismo nombre

| id | nombre | descripcion | Combinación única  |
|---|---|---|---|
| 1 | Agendada | La cita quedó registrada en la agenda del barbero y está a la espera de la fecha y hora acordadas. | Agendada |
| 2 | Finalizada | El barbero atendió al cliente y el servicio contratado se prestó por completo, sin tener ninguna sanción. | Finalizada |
| 3 | Cancelada por el cliente | El cliente decidió no asistir y anuló la cita antes de la fecha y hora programada; mientras esa hora siga libre puede reagendarla y la misma cita vuelve a quedar Agendada. | Cancelada por el cliente |
| 4 | Cancelada por el barbero | El barbero anuló la cita antes de la fecha y hora programada, por ejemplo por una eventualidad. | Cancelada por el barbero |
| 5 | El cliente se demoro | El cliente llegó después de la horaInicio superando el tiempoEspera de la cita; el barbero de la cita lo registra, se le genera una multa de tipo Tardanza y queda pendiente de ser atendido y de pagar. | El cliente se demoro |
| 6 | El barbero se demoro | El barbero se demoró más de lo previsto en una cita anterior y empezó a atender al cliente superando el tiempoEspera definido en la cita, lo que le da un descuento al cliente. | El barbero se demoro |
| 7 | Inasistencia del cliente | El cliente nunca llegó a la cita: el barbero de la cita lo registra después de la hora estimada de finalización, lo que genera una multa de tipo Inasistencia por el valor total de los servicios pedidos. | Inasistencia del cliente |
| 8 | Cancelación | La cita se anuló automáticamente porque la barbería cambió sus políticas: se desactivó el horario de la sede o el horario del barbero del que dependía, se retiró un servicio incluido en ella, se eliminó la apertura de la sede en el festivo de esa fecha o esa fecha pasó a ser festivo, o se registró o se cambió un periodo de cierre de la sede que se cruza con ella. | Cancelación |
| 9 | No pagado | El cliente asistió a la cita y recibió la atención, pero no realizó el pago, lo que genera una multa de tipo No pagado por el precioTotal de la cita. | No pagado |
| 10 | Cancelación por veto | La cita se anuló automáticamente porque al cliente se le impuso una multa en la barbería: todas sus citas futuras agendadas en cualquier sede de esa barbería se cancelan y no se restauran aunque después pague la multa o el barbero la elimine. | Cancelación por veto |

**Combinaciones únicas y datos tomados de otros objetos:**

- **Combinación única**: formada por `nombre`.

**Clasificación de las columnas del muestreo:**

- Corresponde al identificador unico del objeto de dominio: id
- Corresponde a los datos del objeto de dominio: nombre, descripcion
- Corresponde a la combinacion única: Combinación única 

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Rendondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | consultarTodosLosEstados | editarDescripcion | editarDescripcion | consultarDescripcion |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| id | Representa un identificador que hará unico cada objeto de dominio de este tipo, no se puede repetir | Si | Identificador único universal | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No | No aplica | No aplica | No aplica | No aplica | No aplica | UUID vacio | Si | No mostrar | Requerido | No modificable | No mostrar |
| nombre | Representa como se llama el estado en el que se encuentra una cita puntual | No | Alfanumérico | Si | 4 | 50 | No aplica | No aplica | No aplica | No aplica | No aplica | Solo se aceptan caracteres de letras de la 'a' a la 'z' y espacios en blanco | No | No aplica | No aplica | Si | Si | No | Vacio | No | Mostrar | No requerido | No modificable | No mostrar |
| descripcion | Representa el significado de que representa cada estado para la cita | No | Alfanumérico | Si | 10 | 300 | No aplica | No aplica | No aplica | No aplica | No aplica | Solo se aceptan caracteres de letras de la 'a' a la 'z', caracteres con tilde y espacios en blanco | No | No aplica | No aplica | Si | Si | No | Vacio | No | No mostrar | Requerido | Modificable | Mostrar |

| Nombre combinación única | Descripción | Atributos involucrados |
|---|---|---|
| Combinación única  | Combinacion única que indica que no puede existir más un dia de la semana con el mismo nombre | nombre |

| Responsabilidad | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Salida / Descripción | Políticas (Reglas de Negocio) / Política | Políticas (Reglas de Negocio) / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |
|---|---|---|---|---|---|---|---|---|---|---|
| consultarTodosLosEstados | Permite consultar los estados posibles que puede tener una cita |  |  |  | Lista<Estado> | Contiene todos los estados que cumplen con el filtro enviado |  |  |  |  |
| editarDescripcion | Permite ajustar el texto descriptivo de un estado ya creado, sin cambiar su significado en el flujo de la cita | id | UUID | Corresponde al identificador del estado que se va a editar |  | La descripcion del estado se editó | P-EST-0002 | Asegurar que exista el estado con el id enviado | Informar con un mensaje que no existe un estado con el identificador enviado y por lo tanto no es posible modificar la descripción | Detener ejecución de la operación |
|  |  | datos{descripcion} | Estado | Contiene la nueva descripción del estado |  |  | P-EST-0001 | Asegurar que los datos requeridos (descripción) sean válidos en tipo de dato, longitud, formato y rango | Generar una excepción indicándole al usuario cuáles datos de la descripción del estado no cumplen con las reglas definidas | Detener operación |
| consultarDescripcion | Permite consultar la descripcion de un estado en especifico | datos{nombre} | Estado | Contiene el nombre del estado | Alfanumérico | Contiene la información del estado consultado por su identificador | P-EST-0002 | Asegurar que exista el estado con el id enviado | Informar con un mensaje que no existe un Estado con el identificador enviado y por lo tanto no es posible modificar la descripción | Detener ejecución de la operación |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Administrador | Ver estados de las citas | Permite consultar los estados posibles que puede tener una cita | Estado |  |  |  |  |  | Estados consultados |  |
| Barbero | Ver estados de las citas | Permite consultar los estados posibles que puede tener una cita | Estado |  |  |  |  |  | Estados consultados |  |
| Cliente | Ver estados de las citas | Permite consultar los estados posibles que puede tener una cita | Estado |  |  |  |  |  | Estados consultados |  |
| Administrador | Editar descripción del estado | Permite ajustar el texto descriptivo de un estado ya creado, sin cambiar su significado en el flujo de la cita | Estado |  |  | P-EST-0001 | Asegurar que los datos requeridos (descripción) sean válidos en tipo de dato, longitud, formato y rango |  | Descripción de estado actualizada |  |
| Administrador | Ver descripcion de un estado | Permite consultar la descripcion de un estado en especifico | Estado |  |  |  |  |  | Descripción del estado consultada |  |
| Barbero | Ver descripcion de un estado | Permite consultar la descripcion de un estado en especifico | Estado |  |  |  |  |  | Descripción del estado consultada |  |
| Cliente | Ver descripcion de un estado | Permite consultar la descripcion de un estado en especifico | Estado |  |  |  |  |  | Descripción del estado consultada |  |

### Políticas

| Número Política | Descripción Política | Objeto Responsable |
|---|---|---|
| P-EST-0001 | Asegurar que los datos requeridos (descripción) sean válidos en tipo de dato, longitud, formato y rango | [Estado](#estado) |
| P-EST-0002 | Asegurar que exista el estado con el id enviado | [Estado](#estado) |

[↑ Volver al índice](#objetos-de-dominio)

---

## PrefijoCelular

**Descripción:** Representa el catálogo de prefijos telefónicos, que los van a usar los clientes y barberos.  
**Línea de vida:** 1

### Muestreo de datos

- **id**: Representa un identificador que hará unico cada objeto de dominio de este tipo, no se puede repetir
- **prefijo**: Representa el prefijo telefónico del país que el administrador habilita para que la barbería pueda atender números de ese país
- **Combinación única **: Combinacion única que indica que no puede existir más un mismo prefijo

| id | prefijo | Combinación única  |
|---|---|---|
| 1 | +57 | +57 |
| 2 | +91 | +91 |
| 3 | +593 | +593 |
| 4 | +58 | +58 |

**Combinaciones únicas y datos tomados de otros objetos:**

- **Combinación única**: formada por `prefijo`.

**Clasificación de las columnas del muestreo:**

- Corresponde al identificador unico del objeto de dominio: id
- Corresponde a los datos que ingresa el usuario: prefijo
- Corresponde a la combinacion única: Combinación única 

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Rendondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | consultarPrefijosCelular |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| id | Representa un identificador que hará unico cada objeto de dominio de este tipo, no se puede repetir | Si | Identificador único universal | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No | No | No aplica | No | No | No | No aplica | Si | No mostrar |
| prefijo | Representa el prefijo telefónico del país que el administrador habilita para que la barbería pueda atender números de ese país | No | Alfanumérico | Si | 2 | 6 | No aplica | No aplica | No aplica | No aplica | Simbolo + seguido de un número. Por ejemplo +57. Tambien el anterior puede ser seguido de un - y un numero. Por ejemplo +1-809 | Solo se aceptan caracteres numericos del 0 al 9 y el carácter '+' y '-' | No | No | No aplica | Si | Si | No | +0 | No | Mostrar |

| Nombre combinación única | Descripción | Atributos involucrados |
|---|---|---|
| Combinación única  | Combinacion única que indica que no puede existir más un mismo prefijo | prefijo |

| Responsabilidad | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Salida / Descripción | Políticas (Reglas de Negocio) / Política | Políticas (Reglas de Negocio) / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |
|---|---|---|---|---|---|---|---|---|---|---|
| consultarPrefijosCelular | Permite al barbero y al cliente consultar el catálogo de prefijos telefónicos de país disponibles |  |  |  | Lista<PrefijoCelular> | Contiene todos los prefijos de celular registrados |  |  |  |  |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Barbero | Ver prefijos de celular | Permite consultar el catálogo de prefijos telefónicos de país disponibles | PrefijoCelular |  |  |  |  |  | Prefijos de celular consultados |  |
| Cliente | Ver prefijos de celular | Permite consultar el catálogo de prefijos telefónicos de país disponibles | PrefijoCelular |  |  |  |  |  | Prefijos de celular consultados |  |

### Políticas

> No aplica: es un catálogo de solo lectura, sin comandos que impliquen políticas de negocio propias

[↑ Volver al índice](#objetos-de-dominio)

---

## TipoMulta

**Descripción:** Representa los tipos de multa que puede recibir un cliente: por tardanza, por inasistencia o por no pagar los servicios recibidos.  
**Línea de vida:** 1

### Muestreo de datos

- **id**: Representa un identificador que hará unico cada objeto de dominio de este tipo, no se puede repetir
- **nombre**: Representa el nombre del tipo de multa
- **descripcion**: Representa que hace cada tipo de multa
- **Combinación única**: Combinación única indica que no puede existir más de un tipo de multa con el mismo nombre 

| id | nombre | descripcion | Combinación única |
|---|---|---|---|
| 1 | Tardanza | El cliente llegó a la cita después de la horaInicio superando el tiempoEspera (estado El cliente se demoro). Su monto es el valor de multa de la cita. | Tardanza |
| 2 | Inasistencia | El cliente no se presentó a la cita (estado Inasistencia del cliente). Su monto es el precioTotal de la cita. | Inasistencia |
| 3 | No pagado | El cliente asistió y recibió la atención, pero no pagó (estado No pagado). Su monto es el precioTotal de la cita. | No pagado |

**Combinaciones únicas y datos tomados de otros objetos:**

- **Combinación única**: formada por `nombre`.

**Clasificación de las columnas del muestreo:**

- Corresponde al identificador unico del objeto de dominio: id
- Corresponde a los datos del objeto de dominio: nombre, descripcion
- Corresponde a la combinacion única: Combinación única

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Rendondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | consultarTodosLosTiposMulta |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| id | Representa un identificador que hará unico cada objeto de dominio de este tipo, no se puede repetir | Si | Identificador único universal | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No | No | No aplica | No | No | No | UUID vacio | Si | No mostrar |
| nombre | Representa el nombre del tipo de multa | No | Alfanumérico | Si | 4 | 50 | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No | No | No aplica | Si | Si | No | Vacio | No | Mostrar |
| descripcion | Representa que hace cada tipo de multa | No | Alfanumérico | Si | 10 | 300 | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No | No | No aplica | Si | Si | No | Vacio | No | Mostrar |

| Nombre combinación única | Descripción | Atributos involucrados |
|---|---|---|
| Combinación única | Combinación única indica que no puede existir más de un tipo de multa con el mismo nombre  | nombre |

| Responsabilidad | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Salida / Descripción | Políticas (Reglas de Negocio) / Política | Políticas (Reglas de Negocio) / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |
|---|---|---|---|---|---|---|---|---|---|---|
| consultarTodosLosTiposMulta | Permite consultar los tipos de multa que puede recibir un cliente |  |  |  | Lista<TipoMulta> | Contiene todos los tipos de multa que hay |  |  |  |  |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Administrador | Ver tipos de multa | Permite consultar los tipos de multa que puede recibir un cliente | TipoMulta |  |  |  |  |  | Tipos de multa consultados |  |
| Barbero | Ver tipos de multa | Permite consultar los tipos de multa que puede recibir un cliente | TipoMulta |  |  |  |  |  | Tipos de multa consultados |  |
| Cliente | Ver tipos de multa | Permite consultar los tipos de multa que puede recibir un cliente | TipoMulta |  |  |  |  |  | Tipos de multa consultados |  |

### Políticas

> No aplica: es un catálogo de solo lectura, sin comandos que impliquen políticas de negocio propias

[↑ Volver al índice](#objetos-de-dominio)

---

## Festivo

**Descripción:** Representa cada fecha festiva de Colombia en la que, por ley, es día de descanso. El sistema genera automáticamente los festivos de cada año a partir del calendario oficial de festivos, con la fecha en la que realmente se descansa (ya trasladada al lunes cuando la ley lo indica). Por defecto ninguna sede abre en un festivo.  
**Línea de vida:** 1

### Muestreo de datos

- **id**: Representa un identificador que hará unico cada objeto de dominio de este tipo, no se puede repetir
- **fecha**: Representan las fechas que son festivos en Colombia
- **nombre**: Representa el nombre con el que se conoce el festivo (por ejemplo Día de la Raza o Independencia de Cartagena); lo genera el sistema y se le muestra al administrador, al barbero y al cliente
- **Combinación única 1**: Combinación única que indica que no pueden existir dos festivos con la misma fecha

| id | fecha | nombre | Combinación única 1 |
|---|---|---|---|
| 1 | 01/01/2026 | Año Nuevo | 01/01/2026 |
| 2 | 12/01/2026 | Día de los Reyes Magos | 12/01/2026 |
| 3 | 23/03/2026 | Día de San José | 23/03/2026 |
| 4 | 02/04/2026 | Jueves Santo | 02/04/2026 |
| 5 | 03/04/2026 | Viernes Santo | 03/04/2026 |
| 6 | 01/05/2026 | Día del Trabajo | 01/05/2026 |
| 7 | 18/05/2026 | Ascensión del Señor | 18/05/2026 |
| 8 | 08/06/2026 | Corpus Christi | 08/06/2026 |
| 9 | 15/06/2026 | Sagrado Corazón | 15/06/2026 |
| 10 | 29/06/2026 | San Pedro y San Pablo | 29/06/2026 |
| 11 | 13/07/2026 | Nuestra Señora del Rosario de Chiquinquirá | 13/07/2026 |
| 12 | 20/07/2026 | Día de la Independencia | 20/07/2026 |
| 13 | 07/08/2026 | Batalla de Boyacá | 07/08/2026 |
| 14 | 17/08/2026 | Asunción de la Virgen | 17/08/2026 |
| 15 | 12/10/2026 | Día de la Raza | 12/10/2026 |
| 16 | 02/11/2026 | Día de Todos los Santos | 02/11/2026 |
| 17 | 16/11/2026 | Independencia de Cartagena | 16/11/2026 |
| 18 | 08/12/2026 | Inmaculada Concepción | 08/12/2026 |
| 19 | 25/12/2026 | Navidad | 25/12/2026 |

**Combinaciones únicas y datos tomados de otros objetos:**

- **Combinación única 1**: formada por `fecha`.

**Clasificación de las columnas del muestreo:**

- Corresponde al identificador unico del objeto de dominio: id
- Corresponde a los datos auto generados por el sistema: fecha, nombre
- Corresponde a la combinacion única: Combinación única 1

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Rendondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | generarFestivosAnio | actualizarFestivosAnio | actualizarFestivosAnio | consultarFestivosAnio | consultarFestivoPorFecha |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| id | Representa un identificador que hará unico cada objeto de dominio de este tipo, no se puede repetir | Si | Identificador único universal | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No | No aplica | No aplica | No aplica | No aplica | No | UUID vacio | Si | No requerido | No requerido | No modificable | No mostrar | No mostrar |
| fecha | Representan las fechas que son festivos en Colombia | No | Fecha | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | Debe ser una fecha que el calendario oficial de festivos de Colombia marque como día de descanso, ya trasladada al lunes cuando la ley lo indica. No la ingresa ningún usuario: la genera el sistema y no se puede repetir | No | No aplica | No aplica | No aplica | No aplica | No | 01/01/1000 | Si | No requerido | No requerido | No modificable | Mostrar | Mostrar |
| nombre | Representa el nombre con el que se conoce el festivo (por ejemplo Día de la Raza o Independencia de Cartagena); lo genera el sistema y se le muestra al administrador, al barbero y al cliente | No | Alfanumérico | Si | 3 | 100 | No aplica | No aplica | No aplica | No aplica | No aplica | Nombre del festivo según el calendario oficial; si dos festivos caen en la misma fecha, reúne el nombre de ambos | No | No aplica | No aplica | Si | Si | No | Vacio | Si | No requerido | No requerido | Modificable | Mostrar | Mostrar |

| Nombre combinación única | Descripción | Atributos involucrados |
|---|---|---|
| Combinación única 1 | Combinación única que indica que no pueden existir dos festivos con la misma fecha | fecha |

| Responsabilidad | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Salida / Descripción | Políticas (Reglas de Negocio) / Política | Políticas (Reglas de Negocio) / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |
|---|---|---|---|---|---|---|---|---|---|---|
| generarFestivosAnio | Comando que permite al sistema registrar automáticamente todos los festivos de Colombia de un año, con su fecha y su nombre, tomándolos del calendario oficial de festivos que provee la librería Jollyday. Se ejecuta cada 1 de diciembre para el año siguiente, para que los festivos existan antes de que se puedan agendar citas en ese año | datos{anio} | Festivo | Contiene el año del que se van a generar los festivos | Lista<Festivo> | Contiene los festivos registrados para ese año | P-FES-0001 | Asegurar que el año de los festivos sea válido en tipo de dato, obligatoriedad, formato y rango: un número entero de cuatro dígitos | Generar una excepción indicando que el año no cumple con las reglas definidas | Detener operación |
|  |  |  |  |  |  |  | P-FES-0002 | Asegurar que el año para el que se generan los festivos sea el año actual o el año siguiente | Generar una excepción indicando que solo se pueden generar los festivos del año actual o del año siguiente | Detener operación |
|  |  |  |  |  |  |  | P-FES-0003 | Asegurar que el año no tenga festivos registrados; si ya los tiene, se deben actualizar en lugar de volver a generarse | Informar con un mensaje que los festivos de ese año ya fueron generados y que, si cambió la ley, se deben actualizar | Detener operación |
|  |  |  |  |  |  |  | P-FES-0004 | Tomar como festivos solo las fechas que el calendario oficial de festivos de Colombia marca como día de descanso nacional, con la fecha en la que realmente se descansa (trasladada al lunes cuando la ley lo indica). Las celebraciones que no son día de descanso no se registran | Si no se puede consultar el calendario oficial de festivos, generar una excepción informando que no fue posible obtener los festivos del año | Detener operación |
|  |  |  |  |  |  |  | P-FES-0005 | Si dos festivos caen en la misma fecha, registrar un solo festivo cuyo nombre reúna los nombres de ambos; no pueden existir dos festivos con la misma fecha | Unir los nombres de los festivos que caen en la misma fecha y registrar uno solo | Continuar operación |
|  |  |  |  |  |  |  | P-FES-0006 | La generación o la actualización de los festivos de un año se realiza como una sola operación: si alguno de los festivos no se puede registrar, cambiar o eliminar, no se aplica ninguno | Si alguno de los festivos no pudo ser registrado, revertir toda la operación e informar el error | Detener operación |
|  |  |  |  |  |  |  | P-FES-0011 | Asegurar que no exista otro objeto de tipo Festivo con el mismo id; el id solo debe ser único entre los objetos de tipo Festivo | Generar un nuevo id para el Festivo y volver a validar que no lo tenga otro Festivo | Continuar operación |
| actualizarFestivosAnio | Comando que permite al sistema volver a comparar los festivos registrados de un año con el calendario oficial de festivos cuando cambia la ley (por ejemplo cuando se crea un festivo nuevo o se elimina uno): registra los que falten, elimina los que ya no son festivo y corrige el nombre de los que cambiaron. Se ejecuta cuando se actualiza el calendario oficial de festivos del sistema y solo afecta los festivos que todavía no han llegado | datos{anio} | Festivo | Contiene el año cuyos festivos se van a actualizar | Lista<Festivo> | Contiene los festivos del año ya actualizados | P-FES-0001 | Asegurar que el año de los festivos sea válido en tipo de dato, obligatoriedad, formato y rango: un número entero de cuatro dígitos | Generar una excepción indicando que el año no cumple con las reglas definidas | Detener operación |
|  |  |  |  |  |  |  | P-FES-0007 | Asegurar que el año tenga festivos registrados antes de actualizarlos; si no los tiene, primero se deben generar | Informar con un mensaje que el año no tiene festivos registrados y que primero se deben generar | Detener operación |
|  |  |  |  |  |  |  | P-FES-0004 | Tomar como festivos solo las fechas que el calendario oficial de festivos de Colombia marca como día de descanso nacional, con la fecha en la que realmente se descansa (trasladada al lunes cuando la ley lo indica). Las celebraciones que no son día de descanso no se registran | Si no se puede consultar el calendario oficial de festivos, generar una excepción informando que no fue posible obtener los festivos del año | Detener operación |
|  |  |  |  |  |  |  | P-FES-0005 | Si dos festivos caen en la misma fecha, registrar un solo festivo cuyo nombre reúna los nombres de ambos; no pueden existir dos festivos con la misma fecha | Unir los nombres de los festivos que caen en la misma fecha y registrar uno solo | Continuar operación |
|  |  |  |  |  |  |  | P-FES-0008 | Solo registrar, cambiar o eliminar festivos cuya fecha sea posterior al día actual; los festivos de hoy y los pasados se conservan como historial aunque la ley haya cambiado | Dejar sin cambios los festivos de hoy y los pasados | Continuar operación |
|  |  |  |  |  |  |  | P-FES-0009 | Cuando se registre un festivo nuevo, cancelar en el estado Cancelación todas las citas en estado Agendada de esa fecha en todas las sedes, ya que ninguna sede tiene registrada la apertura de un festivo que acaba de crearse. Las citas de otras fechas no se modifican | Si alguna de las citas no pudo ser cancelada, revertir toda la operación e informar el error | Detener operación |
|  |  |  |  |  |  |  | P-FES-0010 | Cuando una fecha deje de ser festivo, eliminar las aperturas de festivo que las sedes tenían registradas para esa fecha; ese día las sedes atienden según su horario habitual y sus citas no se modifican | Si alguna de las aperturas de festivo no pudo ser eliminada, revertir toda la operación e informar el error | Detener operación |
|  |  |  |  |  |  |  | P-FES-0006 | La generación o la actualización de los festivos de un año se realiza como una sola operación: si alguno de los festivos no se puede registrar, cambiar o eliminar, no se aplica ninguno | Si alguno de los festivos no pudo ser registrado, cambiado o eliminado, revertir toda la operación e informar el error | Detener operación |
|  |  |  |  |  |  |  | P-FES-0011 | Asegurar que no exista otro objeto de tipo Festivo con el mismo id; el id solo debe ser único entre los objetos de tipo Festivo | Generar un nuevo id para el Festivo y volver a validar que no lo tenga otro Festivo | Continuar operación |
| consultarFestivosAnio | Permite consultar los festivos de Colombia de un año, con su fecha y su nombre, para que el administrador decida en cuáles abre cada sede y el barbero y el cliente sepan qué días no se atiende | filtro{anio} | Festivo | Contiene el año del que se van a consultar los festivos | Lista<Festivo> | Contiene los festivos del año ordenados por fecha; si la lista está vacía, los festivos de ese año todavía no se han generado |  |  |  |  |
| consultarFestivoPorFecha | Permite al sistema saber si una fecha es festivo en Colombia, para que luego determine si una sede abre ese día al abrir una agenda o al agendar una cita | filtro{fecha} | Festivo | Contiene la fecha que se quiere revisar | Festivo | Contiene el festivo de esa fecha; si no hay ninguno, la fecha no es festivo |  |  |  |  |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Sistema | Generar los festivos de un año | Comando que registra automáticamente los festivos de Colombia de un año, con su fecha y su nombre, tomándolos del calendario oficial de festivos. Se ejecuta cada 1 de diciembre para el año siguiente | Festivo |  |  | P-FES-0001 | Asegurar que el año de los festivos sea válido en tipo de dato, obligatoriedad, formato y rango: un número entero de cuatro dígitos | Nager.Date | Festivos del año generados |  |
|  |  |  |  |  |  | P-FES-0002 | Asegurar que el año para el que se generan los festivos sea el año actual o el año siguiente |  |  |  |
|  |  |  |  |  |  | P-FES-0003 | Asegurar que el año no tenga festivos registrados; si ya los tiene, se deben actualizar en lugar de volver a generarse |  |  |  |
|  |  |  |  |  |  | P-FES-0004 | Tomar como festivos solo las fechas que el calendario oficial de festivos de Colombia marca como día de descanso nacional, con la fecha en la que realmente se descansa (trasladada al lunes cuando la ley lo indica). Las celebraciones que no son día de descanso no se registran |  |  |  |
|  |  |  |  |  |  | P-FES-0005 | Si dos festivos caen en la misma fecha, registrar un solo festivo cuyo nombre reúna los nombres de ambos; no pueden existir dos festivos con la misma fecha |  |  |  |
|  |  |  |  |  |  | P-FES-0006 | La generación o la actualización de los festivos de un año se realiza como una sola operación: si alguno de los festivos no se puede registrar, cambiar o eliminar, no se aplica ninguno |  |  |  |
| Administrador | Ver los festivos de un año | Permite al administrador consultar los festivos de un año para decidir en cuáles abren las sedes | Festivo |  |  |  |  |  | Festivos del año consultados |  |
| Barbero | Ver los festivos de un año | Permite al barbero consultar los festivos de un año y saber qué días no se atiende | Festivo |  |  |  |  |  | Festivos del año consultados |  |
| Cliente | Ver los festivos de un año | Permite al cliente consultar los festivos de un año y saber qué días no se atiende | Festivo |  |  |  |  |  | Festivos del año consultados |  |
| Sistema | Saber si una fecha es festivo | Permite al sistema saber si una fecha es festivo en Colombia, para que luego determine si una sede abre ese día al abrir una agenda o al agendar una cita | Festivo |  |  |  |  |  | Festivo por fecha consultado |  |

### Políticas

| Número Política | Descripción Política | Objeto Responsable |
|---|---|---|
| P-FES-0001 | Asegurar que el año de los festivos sea válido en tipo de dato, obligatoriedad, formato y rango: un número entero de cuatro dígitos | [Festivo](#festivo) |
| P-FES-0002 | Asegurar que el año para el que se generan los festivos sea el año actual o el año siguiente | [Festivo](#festivo) |
| P-FES-0003 | Asegurar que el año no tenga festivos registrados; si ya los tiene, se deben actualizar en lugar de volver a generarse | [Festivo](#festivo) |
| P-FES-0004 | Tomar como festivos solo las fechas que el calendario oficial de festivos de Colombia marca como día de descanso nacional, con la fecha en la que realmente se descansa (trasladada al lunes cuando la ley lo indica). Las celebraciones que no son día de descanso no se registran | [Festivo](#festivo) |
| P-FES-0005 | Si dos festivos caen en la misma fecha, registrar un solo festivo cuyo nombre reúna los nombres de ambos; no pueden existir dos festivos con la misma fecha | [Festivo](#festivo) |
| P-FES-0006 | La generación o la actualización de los festivos de un año se realiza como una sola operación: si alguno de los festivos no se puede registrar, cambiar o eliminar, no se aplica ninguno | [Festivo](#festivo) |
| P-FES-0007 | Asegurar que el año tenga festivos registrados antes de actualizarlos; si no los tiene, primero se deben generar | [Festivo](#festivo) |
| P-FES-0008 | Solo registrar, cambiar o eliminar festivos cuya fecha sea posterior al día actual; los festivos de hoy y los pasados se conservan como historial aunque la ley haya cambiado | [Festivo](#festivo) |
| P-FES-0009 | Cuando se registre un festivo nuevo, cancelar en el estado Cancelación todas las citas en estado Agendada de esa fecha en todas las sedes, ya que ninguna sede tiene registrada la apertura de un festivo que acaba de crearse. Las citas de otras fechas no se modifican | [Cita](#cita) |
| P-FES-0010 | Cuando una fecha deje de ser festivo, eliminar las aperturas de festivo que las sedes tenían registradas para esa fecha; ese día las sedes atienden según su horario habitual y sus citas no se modifican | [SedeFestivo](#sedefestivo) |
| P-FES-0011 | Asegurar que no exista otro objeto de tipo Festivo con el mismo id; el id solo debe ser único entre los objetos de tipo Festivo | [Festivo](#festivo) |

[↑ Volver al índice](#objetos-de-dominio)

---

## TipoSociedad

**Descripción:** Representa el catálogo de tipos de sociedad con los que puede estar constituida legalmente una barbería ante la Cámara de Comercio (S.A.S., Ltda. o S.A.), cada uno con el sufijo que se agrega al final de su razón social.  
**Línea de vida:** 1

### Muestreo de datos

- **id**: Representa un identificador que hará unico cada objeto de dominio de este tipo, no se puede repetir
- **nombre**: Representa el nombre completo del tipo de sociedad
- **sufijo**: Representa la abreviatura legal del tipo de sociedad que se agrega al final de la razón social
- **Combinación única 1**: Combinación única que indica que no puede existir más de un tipo de sociedad con el mismo nombre
- **Combinación única 2**: Combinación única que indica que no puede existir más de un tipo de sociedad con el mismo sufijo

| id | nombre | sufijo | Combinación única 1 | Combinación única 2 |
|---|---|---|---|---|
| 1 | Sociedad por Acciones Simplificada | S.A.S. | Sociedad por Acciones Simplificada | S.A.S. |
| 2 | Sociedad Limitada | Ltda. | Sociedad Limitada | Ltda. |
| 3 | Sociedad Anónima | S.A. | Sociedad Anónima | S.A. |

**Combinaciones únicas y datos tomados de otros objetos:**

- **Combinación única 1**: formada por `nombre`.
- **Combinación única 2**: formada por `sufijo`.

**Clasificación de las columnas del muestreo:**

- Corresponde al identificador unico del objeto de dominio: id
- Corresponde a los datos del objeto de dominio: nombre, sufijo
- Corresponde a la combinacion única 1: Combinación única 1
- Corresponde a la combinacion única 2: Combinación única 2

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Rendondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | consultarTodosLosTiposSociedad |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| id | Representa un identificador que hará unico cada objeto de dominio de este tipo, no se puede repetir | Si | Identificador único universal | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No | No | No aplica | No | No | No | UUID vacio | Si | No mostrar |
| nombre | Representa el nombre completo del tipo de sociedad | No | Alfanumérico | Si | 5 | 60 | No aplica | No aplica | No aplica | No aplica | No aplica | Solo se aceptan letras de la 'a' a la 'z' en minúsculas y mayúsculas, esas letras con tilde y espacios | No | No | No aplica | Si | Si | No | Vacio | No | Mostrar |
| sufijo | Representa la abreviatura legal del tipo de sociedad que se agrega al final de la razón social | No | Alfanumérico | Si | 2 | 10 | No aplica | No aplica | No aplica | No aplica | Abreviatura del tipo de sociedad terminada en punto | Solo se aceptan letras de la 'a' a la 'z' en minúsculas y mayúsculas y el signo '.' | No | No | No aplica | Si | Si | No | Vacio | No | Mostrar |

| Nombre combinación única | Descripción | Atributos involucrados |
|---|---|---|
| Combinación única 1 | Combinación única que indica que no puede existir más de un tipo de sociedad con el mismo nombre | nombre |
| Combinación única 2 | Combinación única que indica que no puede existir más de un tipo de sociedad con el mismo sufijo | sufijo |

| Responsabilidad | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Salida / Descripción | Políticas (Reglas de Negocio) / Política | Políticas (Reglas de Negocio) / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |
|---|---|---|---|---|---|---|---|---|---|---|
| consultarTodosLosTiposSociedad | Permite consultar los tipos de sociedad con los que puede estar constituida una barbería |  |  |  | Lista<TipoSociedad> | Contiene todos los tipos de sociedad que hay |  |  |  |  |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Administrador | Ver tipos de sociedad | Permite consultar los tipos de sociedad con los que puede estar constituida una barbería | TipoSociedad |  |  |  |  |  | Tipos de sociedad consultados |  |

### Políticas

> No aplica: es un catálogo de solo lectura, sin comandos que impliquen políticas de negocio propias

[↑ Volver al índice](#objetos-de-dominio)

---

## Barberia

**Descripción:** Representa la cadena o marca comercial de barbería, dueña de una o varias sedes.  
**Línea de vida:** 2

### Muestreo de datos

- **id**: Representa un identificador que hará unico cada objeto de dominio de este tipo, no se puede repetir
- **tipoSociedad**: Representa el tipo de sociedad con el que está constituida legalmente la barbería; de él se toma el sufijo de su razón social
- **nombreBarberia**: Representa el nombre comercial de la cadena de barbería, dueña de una o varias sedes. Este es el nombre con el que el cliente ve el nombre de la barberia para pedir sus citas
- **denominacion**: Representa el nombre registrado en la Cámara de Comercio, sin el sufijo del tipo de sociedad
- **razonSocial**: Representa el nombre legal completo de la sociedad, formado por la denominación seguida del sufijo de su tipo de sociedad. Es un dato calculado, que sale a partir de la denominación y el tipo de sociedad
- **nit**: Representa el número de identificación tributaria (NIT) que identifica legalmente a la barbería como sociedad
- **Combinación única 1**: Combinación única que indica que no puede existir más de una barbería con la misma denominación
- **Combinación única 2**: Combinación única que indica que no puede existir más de una barbería con el mismo nit

| id | tipoSociedad | nombreBarberia | denominacion | razonSocial | nit | Combinación única 1 | Combinación única 2 |
|---|---|---|---|---|---|---|---|
| 1 | S.A.S. | BarberClub | BarberClub Colombia | BarberClub Colombia S.A.S. | 900123456-7 | BarberClub Colombia | 900123456-7 |
| 2 | S.A.S. | Corte y Estilo | Corte y Estilo Barberías | Corte y Estilo Barberías S.A.S. | 900654321-9 | Corte y Estilo Barberías | 900654321-9 |
| 3 | Ltda. | Clásica del Oriente | Barbería Clásica del Oriente | Barbería Clásica del Oriente Ltda. | 901234567-3 | Barbería Clásica del Oriente | 901234567-3 |

**Combinaciones únicas y datos tomados de otros objetos:**

- **tipoSociedad**: referencia a [TipoSociedad](#tiposociedad); en los datos de ejemplo se muestra con su combinación única.
- **razonSocial**: se calcula como la `denominacion` seguida de un espacio y el `sufijo` del [TipoSociedad](#tiposociedad) de la barbería.
- **Combinación única 1**: formada por `denominacion`.
- **Combinación única 2**: formada por `nit`.

**Clasificación de las columnas del muestreo:**

- Corresponde al identificador unico del objeto de dominio: id
- Corresponde a las referencias de otros objetos de dominio: tipoSociedad
- Corresponde a los datos que ingresa el usuario: nombreBarberia, denominacion, nit
- Corresponde a los datos calculados por el sistema: razonSocial
- Corresponde a la combinacion única 1: Combinación única 1
- Corresponde a la combinacion única 2: Combinación única 2

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Rendondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | registrarBarberia | consultarBarberias | consultarNombreBarberia | consultarRazonSocialYNitBarberia | cambiarNombreBarberia | cambiarNombreBarberia | cambiarRazonSocialBarberia | cambiarRazonSocialBarberia | cambiarNitBarberia | cambiarNitBarberia | darDeBajaBarberia |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| id | Representa un identificador que hará unico cada objeto de dominio de este tipo, no se puede repetir | Si | Identificador único universal | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No | No aplica | No aplica | No aplica | No aplica | No | UUID vacio | Si | No requerido | No mostrar | No mostrar | No mostrar | Requerido | No modificable | Requerido | No modificable | Requerido | No modificable | Requerido |
| tipoSociedad | Representa el tipo de sociedad con el que está constituida legalmente la barbería; de él se toma el sufijo de su razón social | No | [TipoSociedad](#tiposociedad) | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | Aplican las reglas del objeto referenciado | No | No aplica | No aplica | No aplica | No aplica | No | UUID vacio | No | Requerido | No mostrar | No mostrar | Mostrar | No requerido | No modificable | Requerido | Modificable | No requerido | No modificable | No requerido |
| nombreBarberia | Representa el nombre comercial de la cadena de barbería, dueña de una o varias sedes. Este es el nombre con el que el cliente ve el nombre de la barberia para pedir sus citas | No | Alfanumérico | Si | 2 | 50 | No aplica | No aplica | No aplica | No aplica | No aplica | Se aceptan todos los caracterez | No | No aplica | No aplica | Si | Si | No | Vacio | No | Requerido | Mostrar | Mostrar | No mostrar | Requerido | Modificable | No requerido | No modificable | No requerido | No modificable | No requerido |
| denominacion | Representa el nombre registrado en la Cámara de Comercio, sin el sufijo del tipo de sociedad | No | Alfanumérico | Si | 2 | 117 | No aplica | No aplica | No aplica | No aplica | Nombre de la sociedad sin el sufijo del tipo de sociedad (por ejemplo: BarberClub Colombia) | Se aceptan todas las letras con tilde y sus mayúsculas, números, espacios y los signos . , & - ‘ ( ). No debe terminar en ningún sufijo de tipo de sociedad (S.A.S., SAS, Ltda., Limitada, S.A., SA) | No | No aplica | No aplica | Si | Si | No | Vacio | No | Requerido | No mostrar | No mostrar | Mostrar | No requerido | No modificable | Requerido | Modificable | No requerido | No modificable | No requerido |
| razonSocial | Representa el nombre legal completo de la sociedad, formado por la denominación seguida del sufijo de su tipo de sociedad. Es un dato calculado, que sale a partir de la denominación y el tipo de sociedad | No | Alfanumérico | Si | 5 | 128 | No aplica | No aplica | No aplica | No aplica | Denominación, seguida de un espacio y el sufijo del tipo de sociedad (por ejemplo: BarberClub Colombia S.A.S.) | Se calcula como denominacion + " " + tipoSociedad.sufijo. No la ingresa el administrador: se vuelve a calcular cada vez que cambia la denominación o el tipo de sociedad | Si | No aplica | No aplica | No aplica | No aplica | No | Vacio | No | No requerido | No mostrar | No mostrar | Mostrar | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No requerido |
| nit | Representa el número de identificación tributaria (NIT) que identifica legalmente a la barbería como sociedad | No | Alfanumérico | Si | 10 | 12 | No aplica | No aplica | No aplica | No aplica | El usuario debe ingresar entre 8 y 10 dígitos, seguido de un guion (-), seguido de 1 dígito | Solo se aceptan numeros del 0 al 9 y el '-' | No | No aplica | No aplica | Si | Si | No | Vacio | No | Requerido | No mostrar | No mostrar | Mostrar | No requerido | No modificable | No requerido | No modificable | Requerido | Modificable | No requerido |

| Nombre combinación única | Descripción | Atributos involucrados |
|---|---|---|
| Combinación única 1 | Combinación única que indica que no puede existir más de una barbería con la misma denominación | denominacion |
| Combinación única 2 | Combinación única que indica que no puede existir más de una barbería con el mismo nit | nit |

| Responsabilidad | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Salida / Descripción | Políticas (Reglas de Negocio) / Política | Políticas (Reglas de Negocio) / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |
|---|---|---|---|---|---|---|---|---|---|---|
| registrarBarberia | Comando que permite registrar una nueva barbería con su nombre, su tipo de sociedad, su denominación y su nit; el sistema forma su razón social con la denominación seguida del sufijo del tipo de sociedad | datos{nombreBarberia, tipoSociedad, denominacion, nit} | Barberia | Contiene la información requerida para registrar la barbería | Barberia | Contiene la información de la barbería registrada | P-BRA-0001 | Asegurar que los datos requeridos de la barbería (nombre de la barbería, tipo de sociedad, denominación, nit) sean válidos en tipo de dato, longitud, obligatoriedad, formato y rango | Generar una excepción indicándole al administrador que los datos no cumplen con las reglas definidas | Detener operación |
|  |  |  |  |  |  |  | P-BRA-0006 | Asegurar que no exista otra barbería registrada con la misma denominación | Generar una excepción indicándole al administrador que ya existe una barbería con esa denominación | Detener operación |
|  |  |  |  |  |  |  | P-BRA-0002 | Asegurar que no exista otra barbería registrada con el mismo nit | Generar una excepción indicándole al administrador que ya existe una barbería con ese nit | Detener operación |
|  |  |  |  |  |  |  | P-BRA-0008 | Asegurar que no exista otro objeto de tipo Barberia con el mismo id; el id solo debe ser único entre los objetos de tipo Barberia | Generar un nuevo id para el Barberia y volver a validar que no lo tenga otro Barberia | Continuar operación |
| consultarBarberias | Permite al administrador consultar el listado de barberías para poder elegir a cuál pertenece una sede |  |  |  | Lista<Barberia> | Contiene el nombre de cada barbería registrada (junto con su identificador, que se usa internamente para seleccionarla) |  |  |  |  |
| consultarNombreBarberia | Permite al administrador, al barbero y al cliente consultar el nombre de la barbería | id | UUID | Corresponde al identificador de la barbería que se va a consultar | Alfanumérico | Contiene el nombre de la barbería | P-BRA-0003 | Asegurar que exista la barbería con el id enviado | Informar con un mensaje que no existe una barbería con el identificador enviado y por lo tanto no se puede realizar la operación | Detener operación |
| consultarRazonSocialYNitBarberia | Permite al administrador consultar la razón social, el tipo de sociedad y el nit de la barbería | id | UUID | Corresponde al identificador de la barbería que se va a consultar | Barberia | Contiene la razón social, el tipo de sociedad y el nit de la barbería | P-BRA-0003 | Asegurar que exista la barbería con el id enviado | Informar con un mensaje que no existe una barbería con el identificador enviado y por lo tanto no se puede realizar la operación | Detener operación |
| cambiarNombreBarberia | Permite al administrador cambiar el nombre de la barbería | id | UUID | Corresponde al identificador de la barbería | Barberia | Contiene la barbería con su nombre actualizado | P-BRA-0003 | Asegurar que exista la barbería con el id enviado | Informar con un mensaje que no existe una barbería con el identificador enviado y por lo tanto no se puede realizar la operación | Detener operación |
|  |  | datos{nombreBarberia} | Barberia | Contiene el nuevo nombre de la barbería |  |  | P-BRA-0004 | Asegurar que los dato requeridos de la barbería (nombre de la barbería) sean válidos en tipo de dato, longitud, obligatoriedad, formato y rango | Generar una excepción indicándole al administrador que el nombre no cumple con los requisitos | Detener operación |
| cambiarRazonSocialBarberia | Permite al administrador cambiar el tipo de sociedad o la denominación de la barbería, con lo que se vuelve a formar su razón social (por ejemplo, cuando una Ltda. se transforma en S.A.S. conservando su nit) | id | UUID | Corresponde al identificador de la barbería | Barberia | Contiene la barbería con su tipo de sociedad, su denominación y su razón social actualizados | P-BRA-0003 | Asegurar que exista la barbería con el id enviado | Informar con un mensaje que no existe una barbería con el identificador enviado y por lo tanto no se puede realizar la operación | Detener operación |
|  |  | datos{tipoSociedad, denominacion} | Barberia | Contiene el nuevo tipo de sociedad y la nueva denominación de la barbería |  |  | P-BRA-0007 | Asegurar que los datos requeridos para cambiar la razón social de la barbería (tipo de sociedad, denominación) sean válidos en tipo de dato, longitud, obligatoriedad, formato y rango | Generar una excepción indicándole al administrador que el tipo de sociedad o la denominación no cumplen con los requisitos | Detener operación |
|  |  |  |  |  |  |  | P-BRA-0006 | Asegurar que no exista otra barbería registrada con la misma denominación | Generar una excepción indicándole al administrador que ya existe una barbería con esa denominación | Detener operación |
| cambiarNitBarberia | Permite al administrador cambiar el nit de la barbería | id | UUID | Corresponde al identificador de la barbería | Barberia | Contiene la barbería con su nit actualizado | P-BRA-0003 | Asegurar que exista la barbería con el id enviado | Informar con un mensaje que no existe una barbería con el identificador enviado y por lo tanto no se puede realizar la operación | Detener operación |
|  |  | datos{nit} | Barberia | Contiene el nuevo nit de la barbería |  |  | P-BRA-0005 | Asegurar que los dato requeridos de la barbería (nit) sean válidos en tipo de dato, longitud, obligatoriedad, formato y rango | Generar una excepción indicándole al administrador que el nit no cumple con los requisitos | Detener operación |
|  |  |  |  |  |  |  | P-BRA-0002 | Asegurar que no exista otra barbería registrada con el mismo nit | Generar una excepción indicándole al administrador que ya existe una barbería con ese nit | Detener operación |
| darDeBajaBarberia | Permite al administrador eliminar la barbería del sistema cuando ya no tiene sedes registradas | id | UUID | Corresponde al identificador de la barbería que se va a dar de baja | No retorna ningún valor. En caso de error genera una excepción. |  | P-BRA-0003 | Asegurar que exista la barbería con el id enviado | Informar con un mensaje que no existe una barbería con el identificador enviado y por lo tanto no se puede realizar la operación | Detener operación |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Administrador | Registrar barberia | Comando que permite al administrador registrar una nueva barbería con su nombre, su tipo de sociedad, su denominación y su nit | Barberia | TipoSociedad | Permite elegir el tipo de sociedad y obtener el sufijo con el que se forma la razón social de la barbería. | P-BRA-0001 | Asegurar que los datos requeridos de la barbería (nombre de la barbería, tipo de sociedad, denominación, nit) sean válidos en tipo de dato, longitud, obligatoriedad, formato y rango |  | Barbería registrada |  |
|  |  |  |  |  |  | P-BRA-0006 | Asegurar que no exista otra barbería registrada con la misma denominación |  |  |  |
|  |  |  |  |  |  | P-BRA-0002 | Asegurar que no exista otra barbería registrada con el mismo nit |  |  |  |
| Administrador | Consultar barberias | Permite al administrador consultar el listado de barberías para elegir a cuál pertenece una sede | Barberia |  |  |  |  |  | Barberías consultadas |  |
| Administrador | Ver nombre de la barberia | Permite al administrador consultar el nombre de la barbería | Barberia |  |  |  |  |  | Nombre de barbería consultado |  |
| Barbero | Ver nombre de la barberia | Permite al barbero consultar el nombre de la barbería | Barberia |  |  |  |  |  | Nombre de barbería consultado |  |
| Cliente | Ver nombre de la barberia | Permite al cliente consultar el nombre de la barbería | Barberia |  |  |  |  |  | Nombre de barbería consultado |  |
| Administrador | Ver razon social y nit | Permite al administrador consultar la razón social, el tipo de sociedad y el nit de la barbería | Barberia | TipoSociedad | Permite obtener el sufijo con el que se forma la razón social y mostrar el tipo de sociedad de la barbería. |  |  |  | Razón social y nit de barbería consultados |  |
| Administrador | Cambiar nombre de la barberia | Permite al administrador cambiar el nombre de la barbería | Barberia |  |  | P-BRA-0004 | Asegurar que los dato requeridos de la barbería (nombre de la barbería) sean válidos en tipo de dato, longitud, obligatoriedad, formato y rango |  | Nombre de barbería cambiado |  |
| Administrador | Cambiar razon social de la barberia | Permite al administrador cambiar el tipo de sociedad o la denominación de la barbería, con lo que se vuelve a formar su razón social | Barberia | TipoSociedad | Permite elegir el nuevo tipo de sociedad y obtener su sufijo. | P-BRA-0007 | Asegurar que los datos requeridos para cambiar la razón social de la barbería (tipo de sociedad, denominación) sean válidos en tipo de dato, longitud, obligatoriedad, formato y rango |  | Razón social de barbería cambiada |  |
|  |  |  |  |  |  | P-BRA-0006 | Asegurar que no exista otra barbería registrada con la misma denominación |  |  |  |
| Administrador | Cambiar nit de la barberia | Permite al administrador cambiar el nit de la barbería | Barberia |  |  | P-BRA-0005 | Asegurar que los dato requeridos de la barbería (nit) sean válidos en tipo de dato, longitud, obligatoriedad, formato y rango |  | Nit de barbería cambiado |  |
|  |  |  |  |  |  | P-BRA-0002 | Asegurar que no exista otra barbería registrada con el mismo nit |  |  |  |
| Administrador | Eliminar barberia | Permite al administrador eliminar la barbería del sistema, como si nunca hubiera existido | Barberia |  |  |  |  |  | Barbería eliminada |  |

### Políticas

| Número Política | Descripción Política | Objeto Responsable |
|---|---|---|
| P-BRA-0001 | Asegurar que los datos requeridos de la barbería (nombre de la barbería, tipo de sociedad, denominación, nit) sean válidos en tipo de dato, longitud, obligatoriedad, formato y rango | [Barberia](#barberia) |
| P-BRA-0002 | Asegurar que no exista otra barbería registrada con el mismo nit | [Barberia](#barberia) |
| P-BRA-0003 | Asegurar que exista la barbería con el id enviado | [Barberia](#barberia) |
| P-BRA-0004 | Asegurar que los dato requeridos de la barbería (nombre de la barbería) sean válidos en tipo de dato, longitud, obligatoriedad, formato y rango | [Barberia](#barberia) |
| P-BRA-0005 | Asegurar que los dato requeridos de la barbería (nit) sean válidos en tipo de dato, longitud, obligatoriedad, formato y rango | [Barberia](#barberia) |
| P-BRA-0006 | Asegurar que no exista otra barbería registrada con la misma denominación | [Barberia](#barberia) |
| P-BRA-0007 | Asegurar que los datos requeridos para cambiar la razón social de la barbería (tipo de sociedad, denominación) sean válidos en tipo de dato, longitud, obligatoriedad, formato y rango | [Barberia](#barberia) |
| P-BRA-0008 | Asegurar que no exista otro objeto de tipo Barberia con el mismo id; el id solo debe ser único entre los objetos de tipo Barberia | [Barberia](#barberia) |

[↑ Volver al índice](#objetos-de-dominio)

---

## Cliente

**Descripción:** Representa a la persona que solicita citas en las sedes de una o varias barberías. Si tiene multas sin pagar en una barbería, no puede agendar en ninguna de sus sedes, pero sí en las demás barberías.  
**Línea de vida:** 2

### Muestreo de datos

- **id**: Representa un identificador que hará unico cada objeto de dominio de este tipo, no se puede repetir
- **primerNombre**: Representa el primer nombre de la persona, que va a estar llendo a la barberia para las citas
- **segundoNombre**: Representa el segundo nombre de la persona, que va a estar llendo a la barberia para las citas
- **primerApellido**: Representa el primer apellido de la persona, que va a estar llendo a la barberia para las citas
- **segundoApellido**: Representa el segundo apellido de la persona, que va a estar llendo a la barberia para las citas
- **prefijoCelular**: Representa cual es el prefijo del numero de celular del cliente (referencia a [PrefijoCelular](#prefijocelular))
- **celular**: Representa el numero de celular del cliente, es el dato que el barbero necesita en caso de que tenga que contactarse con el
- **elNumeroCelularEsCorrecto**: Representa si el numero que ingreso el cliente es correcto o no
- **Combinación única  1**: Combinacion única que indica que no puede existir más de un cliente con el mismo prefijo de celular y número de celular

| id | primerNombre | segundoNombre | primerApellido | segundoApellido | prefijoCelular | celular | elNumeroCelularEsCorrecto | Combinación única  1 |
|---|---|---|---|---|---|---|---|---|
| 1 | Juan |  | Gómez |  | +57 | 3234528921 | Si | +57-3234528921 |
| 2 | Jose | Miguel | Ramirez | Perez | +57 | 3161657782 | Si | +57-3161657782 |
| 3 | Simon |  | Ochoa | Ramirez | +57 | 3119884321 | Si | +57-3119884321 |
| 4 | Alexis |  | Gallego |  | +58 | 4127359182 | Si | +58-4127359182 |
| 5 | Kevin | Andrés | Muñoz | Salazar | +57 | 3005544332 | Si | +57-3005544332 |

**Combinaciones únicas y datos tomados de otros objetos:**

- **prefijoCelular**: referencia a [PrefijoCelular](#prefijocelular); en los datos de ejemplo se muestra con su combinación única.
- **Combinación única  1**: formada por `prefijoCelular` + `celular`.

**Clasificación de las columnas del muestreo:**

- Corresponde al identificador unico del objeto de dominio: id
- Corresponde a las referencias de otros objetos de dominio: prefijoCelular
- Corresponde a los datos que ingresa el usuario: primerNombre, segundoNombre, primerApellido, segundoApellido, celular, elNumeroCelularEsCorrecto
- Corresponde a la combinacion única: Combinación única  1

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Rendondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | registrarCliente | editarContactoCliente | editarContactoCliente | consultarDatosCliente |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| id | Representa un identificador que hará unico cada objeto de dominio de este tipo, no se puede repetir | Si | Identificador único universal | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | Si | No | No aplica | No aplica | No aplica | No | UUID vacio | Si | No requerido | Requerido | No modificable | No mostrar |
| primerNombre | Representa el primer nombre de la persona, que va a estar llendo a la barberia para las citas | No | Alfanumérico | Si | 3 | 50 | No aplica | No aplica | No aplica | No aplica | No aplica | Solo se aceptan caracteres de letras de la 'a' a la 'z', caracteres con tilde y numeros del 0 al 9  | No | No | No | Si | Si | No | Vacio | No | Requerido | No requerido | No modificable | Mostrar |
| segundoNombre | Representa el segundo nombre de la persona, que va a estar llendo a la barberia para las citas | No | Alfanumérico | No | 0 | 50 | No aplica | No aplica | No aplica | No aplica | No aplica | Solo se aceptan caracteres de letras de la 'a' a la 'z', caracteres con tilde y numeros del 0 al 9  | No | No | No | Si | Si | No | Vacio | No | No requerido | No requerido | No modificable | Mostrar |
| primerApellido | Representa el primer apellido de la persona, que va a estar llendo a la barberia para las citas | No | Alfanumérico | Si | 3 | 50 | No aplica | No aplica | No aplica | No aplica | No aplica | Solo se aceptan caracteres de letras de la 'a' a la 'z', caracteres con tilde y numeros del 0 al 9  | No | No | No | Si | Si | No | Vacio | No | Requerido | No requerido | No modificable | Mostrar |
| segundoApellido | Representa el segundo apellido de la persona, que va a estar llendo a la barberia para las citas | No | Alfanumérico | No | 0 | 50 | No aplica | No aplica | No aplica | No aplica | No aplica | Solo se aceptan caracteres de letras de la 'a' a la 'z', caracteres con tilde y numeros del 0 al 9  | No | No | No | Si | Si | No | Vacio | No | No requerido | No requerido | No modificable | Mostrar |
| prefijoCelular | Representa cual es el prefijo del numero de celular del cliente | No | [PrefijoCelular](#prefijocelular) | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | Aplican las reglas del objeto referenciado | No | No aplica | No aplica | No aplica | No aplica | No | UUID vacio | No | Requerido | Requerido | Modificable | Mostrar |
| celular | Representa el numero de celular del cliente, es el dato que el barbero necesita en caso de que tenga que contactarse con el | No | Alfanumérico | Si | 6 | 15 | No aplica | No aplica | No aplica | No aplica | No aplica | Solo se aceptan caracteres de numeros del '0' al '9' | No | No aplica | No aplica | Si | Si | Si | 0 | No | Requerido | Requerido | Modificable | Mostrar |
| elNumeroCelularEsCorrecto | Representa si el numero que ingreso el cliente es correcto o no | No | Lógico | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No | No aplica | No aplica | No aplica | No aplica | No | No | No | No requerido | No requerido | Modificable | Mostrar |

| Nombre combinación única | Descripción | Atributos involucrados |
|---|---|---|
| Combinación única  1 | Combinacion única que indica que no puede existir más de un cliente con el mismo prefijo de celular y número de celular | prefijoCelular, celular |

| Responsabilidad | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Salida / Descripción | Políticas (Reglas de Negocio) / Política | Políticas (Reglas de Negocio) / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |
|---|---|---|---|---|---|---|---|---|---|---|
| registrarCliente | Comando que permite el registro de un nuevo cliente en la barbería | datos{primerNombre, segundoNombre, primerApellido, segundoApellido, prefijoCelular, celular} | Cliente | Contiene la información requerida para registrar un nuevo cliente en la barbería | Cliente | Contiene la información del cliente registrado | P-CLI-0001 | Asegurar que los datos requeridos del cliente (nombres, apellidos, prefijo de celular, celular) sean válidos en tipo de dato, longitud, obligatoriedad, formato y rango | Generar una excepción indicándole al usuario cuáles datos del cliente no cumplen con las reglas definidas | Detener operación |
|  |  |  |  |  |  |  | P-CLI-0002 | Asegurar que el número de celular y prefijo de celular no esté siendo utilizado por otro cliente | Generar una excepción indicándole al usuario que ya existe otro cliente registrado con ese prefijo y número de celular | Detener operación |
|  |  |  |  |  |  |  | P-CLI-0008 | Asegurar que el número de celular y prefijo de celular no esté siendo utilizado por otro barbero | Generar una excepción indicándole al usuario que ese prefijo y número de celular ya está registrado por un barbero | Detener operación |
|  |  |  |  |  |  |  | P-CLI-0009 | Asegurar que no exista otro objeto de tipo Cliente con el mismo id; el id solo debe ser único entre los objetos de tipo Cliente | Generar un nuevo id para el Cliente y volver a validar que no lo tenga otro Cliente | Continuar operación |
| editarContactoCliente | Permite al cliente actualizar su número de celular y su prefijo | id | UUID | Corresponde al identificador del cliente que va a editar su contacto | Cliente | Contiene la información del cliente con su contacto actualizado | P-CLI-0005 | Asegurar que exista el cliente con el id enviado | Informar con un mensaje que no existe un cliente con el identificador enviado y por lo tanto no es posible editar el contacto del cliente | Detener operación |
|  |  | datos{prefijoCelular, celular} | Cliente | Contiene el nuevo prefijo y número de celular del cliente |  |  | P-CLI-0003 | Asegurar que los datos requeridos del cliente para editar su contacto (prefijo de celular y celular) sean válidos en tipo de dato, longitud, obligatoriedad, formato y rango | Generar una excepción indicándole al usuario cuáles datos de contacto del cliente no cumplen con las reglas definidas | Detener operación |
|  |  |  |  |  |  |  | P-CLI-0008 | Asegurar que el número de celular y prefijo de celular no esté siendo utilizado por otro barbero | Generar una excepción indicándole al usuario que ese prefijo y número de celular ya está registrado por un barbero | Detener operación |
| consultarDatosCliente | Permite a un barbero ver los datos de un cliente que le va a pedir una cita | id | UUID | Corresponde al identificador del cliente que se va a consultar | Cliente | Contiene la información del cliente consultado por su identificador | P-CLI-0005 | Asegurar que exista el cliente con el id enviado | Informar con un mensaje que no existe un cliente con el identificador enviado y por lo tanto no es posible llevar a cabo la operación | Detener operación |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Cliente | Registrar cliente a la barbería | Comando que permite el registro de un nuevo cliente en la barbería | Cliente | PrefijoCelular | Permite asignar el prefijo de país del número de celular del cliente. | P-CLI-0001 | Asegurar que los datos requeridos del cliente (nombres, apellidos, prefijo de celular, celular) sean válidos en tipo de dato, longitud, obligatoriedad, formato y rango |  | Cliente registrado |  |
|  |  |  |  |  |  | P-CLI-0002 | Asegurar que el número de celular y prefijo de celular no esté siendo utilizado por otro cliente |  |  |  |
|  |  |  |  |  |  | P-CLI-0008 | Asegurar que el número de celular y prefijo de celular no esté siendo utilizado por otro barbero |  |  |  |
| Cliente | Editar contacto | Permite al cliente actualizar su número de celular y su prefijo | Cliente | PrefijoCelular | Permite actualizar el prefijo de país del número de celular. | P-CLI-0003 | Asegurar que los datos requeridos del cliente para editar su contacto (prefijo de celular y celular) sean válidos en tipo de dato, longitud, obligatoriedad, formato y rango |  | Contacto de cliente actualizado |  |
|  |  |  |  |  |  | P-CLI-0008 | Asegurar que el número de celular y prefijo de celular no esté siendo utilizado por otro barbero |  |  |  |
| Barbero | Ver datos de un cliente | Permite a un barbero ver los datos de un cliente que le va a pedir una cita | Cliente | PrefijoCelular | Permite mostrar el número de celular completo con su prefijo. |  |  |  | Datos del cliente vistos |  |

### Políticas

| Número Política | Descripción Política | Objeto Responsable |
|---|---|---|
| P-CLI-0001 | Asegurar que los datos requeridos del cliente (nombres, apellidos, prefijo de celular, celular) sean válidos en tipo de dato, longitud, obligatoriedad, formato y rango | [Cliente](#cliente) |
| P-CLI-0002 | Asegurar que el número de celular y prefijo de celular no esté siendo utilizado por otro cliente | [Cliente](#cliente) |
| P-CLI-0003 | Asegurar que los datos requeridos del cliente para editar su contacto (prefijo de celular y celular) sean válidos en tipo de dato, longitud, obligatoriedad, formato y rango | [Cliente](#cliente) |
| P-CLI-0005 | Asegurar que exista el cliente con el id enviado | [Cliente](#cliente) |
| P-CLI-0008 | Asegurar que el número de celular y prefijo de celular no esté siendo utilizado por otro barbero | [Barbero](#barbero) |
| P-CLI-0009 | Asegurar que no exista otro objeto de tipo Cliente con el mismo id; el id solo debe ser único entre los objetos de tipo Cliente | [Cliente](#cliente) |

[↑ Volver al índice](#objetos-de-dominio)

---

## Ciudad

**Descripción:** Representa cada una de las ciudades, pertenecientes a un departamento, en las que puede estar ubicada una sede de la barbería.  
**Línea de vida:** 2

### Muestreo de datos

- **id**: Representa un identificador que hará unico cada objeto de dominio de este tipo, no se puede repetir
- **nombre**: Representa el nombre de la ciudad en la que puede estar ubicada una sede de la barbería
- **departamento**: Representa a qué departamento pertenece esta ciudad
- **Combinación única**: Combinación única que indica que no puede existir más de una ciudad con el mismo nombre dentro de un mismo departamento

| id | nombre | departamento | Combinación única |
|---|---|---|---|
| 1 | Medellín | Antioquia | Medellín-Antioquia |
| 2 | Rionegro | Antioquia | Rionegro-Antioquia |
| 3 | Bogotá | Cundinamarca | Bogotá-Cundinamarca |
| 4 | Cali | Valle del Cauca | Cali-Valle del Cauca |
| 5 | Barranquilla | Atlántico | Barranquilla-Atlántico |

**Combinaciones únicas y datos tomados de otros objetos:**

- **departamento**: referencia a [Departamento](#departamento); en los datos de ejemplo se muestra con su combinación única.
- **Combinación única**: formada por `nombre` + `departamento`.

**Clasificación de las columnas del muestreo:**

- Corresponde al identificador unico del objeto de dominio: id
- Corresponde a las referencias de otros objetos de dominio: nombre
- Corresponde a los datos de libre ingreso: departamento
- Corresponde a la combinacion única: Combinación única

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Rendondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | consultarCiudades |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| id | Representa un identificador que hará unico cada objeto de dominio de este tipo, no se puede repetir | Si | Identificador único universal | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No | No aplica | No aplica | No aplica | No aplica | No | UUID vacio | Si | No mostrar |
| nombre | Representa el nombre de la ciudad en la que puede estar ubicada una sede de la barbería | No | Alfanumérico | Si | 3 | 30 | No aplica | No aplica | No aplica | No aplica | No aplica | Permite caracterez de la 'a' a la 'z' minusculas y mayusculas, con espacios en blanco y esas letras pero con tilde | No | No aplica | No aplica | Si | Si | No | Vacio | No | Mostrar |
| departamento | Representa a qué departamento pertenece esta ciudad | No | [Departamento](#departamento) | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | Aplican las reglas del objeto referenciado | No | No aplica | No aplica | No aplica | No aplica | No | UUID vacio | No | Mostrar |

| Nombre combinación única | Descripción | Atributos involucrados |
|---|---|---|
| Combinación única | Combinación única que indica que no puede existir más de una ciudad con el mismo nombre dentro de un mismo departamento | nombre, departamento |

| Responsabilidad | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Salida / Descripción | Políticas (Reglas de Negocio) / Política | Políticas (Reglas de Negocio) / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |
|---|---|---|---|---|---|---|---|---|---|---|
| consultarCiudades | Permite consultar el catálogo de ciudades con su departamento |  |  |  | Lista<Ciudad> | Contiene todas las ciudades registradas con su departamento |  |  |  |  |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Administrador | Ver las ciudades | Permite consultar el catálogo de ciudades, con su departamento, en las que se pueden ubicar las sedes | Ciudad | Departamento | Permite mostrar el departamento al que pertenece cada ciudad. |  |  |  | Ciudades consultadas |  |

### Políticas

> No aplica: es un catálogo de solo lectura, sin comandos que impliquen políticas de negocio propias

[↑ Volver al índice](#objetos-de-dominio)

---

## Sede

**Descripción:** Representa cada una de las sucursales físicas de una barbería, ubicada en una ciudad puntual, donde se ofrecen los servicios y trabajan los barberos.  
**Línea de vida:** 3

### Muestreo de datos

- **id**: Representa un identificador que hará unico cada objeto de dominio de este tipo, no se puede repetir
- **ciudad**: Representa a qué ciudad pertenece esta sede
- **barberia**: Representa a qué barbería pertenece esta sede
- **nombre**: Representa el nombre con el que se identifica esta sede dentro de la barbería a la que pertenece
- **direccion**: Representa la dirección física en la que está ubicada esta sede
- **Combinación única**: Combinación única que indica que una misma barbería no puede tener dos sedes con el mismo nombre

| id | ciudad | barberia | nombre | direccion | Combinación única |
|---|---|---|---|---|---|
| 1 | Medellín-Antioquia | BarberClub Colombia | Sede Poblado | Cra 43A #10-25 | BarberClub Colombia-Sede Poblado |
| 2 | Medellín-Antioquia | BarberClub Colombia | Sede Laureles | Cl 33 #70-12 | BarberClub Colombia-Sede Laureles |
| 3 | Rionegro-Antioquia | BarberClub Colombia | Sede Rionegro | Cl 45 #50-30 | BarberClub Colombia-Sede Rionegro |
| 4 | Bogotá-Cundinamarca | Corte y Estilo Barberías | Sede Centro | Cra 7 #24-18 | Corte y Estilo Barberías-Sede Centro |
| 5 | Rionegro-Antioquia | Barbería Clásica del Oriente | Sede Principal | Cl 50 #48-20 | Barbería Clásica del Oriente-Sede Principal |

**Combinaciones únicas y datos tomados de otros objetos:**

- **ciudad**: referencia a [Ciudad](#ciudad); en los datos de ejemplo se muestra con su combinación única.
- **barberia**: referencia a [Barberia](#barberia); en los datos de ejemplo se muestra con su combinación única.
- **Combinación única**: formada por `barberia` + `nombre`.

**Clasificación de las columnas del muestreo:**

- Corresponde al identificador unico del objeto de dominio: id
- Corresponde a las referencias de otros objetos de dominio: ciudad, barberia
- Corresponde a los datos que ingresa el administrador: nombre, direccion
- Corresponde a la combinacion única: Combinación única

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Rendondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | registrarSede | consultarDatosSede | cambiarNombreSede | cambiarNombreSede | cambiarDireccionSede | cambiarDireccionSede | darDeBajaSede |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| id | Representa un identificador que hará unico cada objeto de dominio de este tipo, no se puede repetir | Si | Identificador único universal | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No | No aplica | No aplica | No aplica | No aplica | No | UUID vacio | Si | No requerido | No mostrar | Requerido | No modificable | Requerido | No modificable | Requerido |
| ciudad | Representa a qué ciudad pertenece esta sede | No | [Ciudad](#ciudad) | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | Aplican las reglas del objeto referenciado | No | No aplica | No aplica | No aplica | No aplica | No | UUID vacio | No | Requerido | Mostrar | No requerido | No modificable | No requerido | No modificable | No requerido |
| barberia | Representa a qué barbería pertenece esta sede | No | [Barberia](#barberia) | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | Aplican las reglas del objeto referenciado | No | No aplica | No aplica | No aplica | No aplica | No | UUID vacio | No | Requerido | No mostrar | No requerido | No modificable | No requerido | No modificable | No requerido |
| nombre | Representa el nombre con el que se identifica esta sede dentro de la barbería a la que pertenece | No | Alfanumérico | Si | 2 | 50 | No aplica | No aplica | No aplica | No aplica | No aplica | Permite todos los caracterez | No | No aplica | No aplica | Si | Si | No | Vacio | No | Requerido | Mostrar | Requerido | Modificable | No requerido | No modificable | No requerido |
| direccion | Representa la dirección física en la que está ubicada esta sede | No | Alfanumérico | Si | 5 | 100 | No aplica | No aplica | No aplica | No aplica | Tipo de vía + número de vía + letra/sufijo (si aplica) + # + número de vía generadora + letra/sufijo (si aplica) + - + número de placa + complemento (si aplica). Por ejemplo: Carrera 30A # 10-21 Apartamento 201 | Permite caracterez de la 'a' a la 'z' minusculas y mayusculas, espacios en blanco y el carácter '#' | No | No aplica | No aplica | Si | Si | No | Vacio | No | Requerido | Mostrar | No requerido | No modificable | Requerido | Modificable | No requerido |

| Nombre combinación única | Descripción | Atributos involucrados |
|---|---|---|
| Combinación única | Combinación única que indica que una misma barbería no puede tener dos sedes con el mismo nombre | barberia, nombre |

| Responsabilidad | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Salida / Descripción | Políticas (Reglas de Negocio) / Política | Políticas (Reglas de Negocio) / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |
|---|---|---|---|---|---|---|---|---|---|---|
| registrarSede | Comando que permite registrar una nueva sede de una barbería en una ciudad | datos{barberia, ciudad, nombre, direccion} | Sede | Contiene la información requerida para registrar la sede | Sede | Contiene la información de la sede registrada | P-SED-0001 | Asegurar que los datos requeridos de la sede (barbería, ciudad, nombre, dirección) sean válidos en tipo de dato, longitud, obligatoriedad, formato y rango | Generar una excepción indicándole al administrador cuáles datos de la sede no cumplen con las reglas definidas | Detener operación |
|  |  |  |  |  |  |  | P-SED-0002 | Asegurar que no exista otra sede con el mismo nombre en la misma barbería | Generar una excepción indicándole al administrador que ya existe una sede con ese nombre en la barbería | Detener operación |
|  |  |  |  |  |  |  | P-SED-0008 | Asegurar que no exista otro objeto de tipo Sede con el mismo id; el id solo debe ser único entre los objetos de tipo Sede | Generar un nuevo id para el Sede y volver a validar que no lo tenga otro Sede | Continuar operación |
| consultarDatosSede | Permite consultar el nombre y la dirección de una sede | id | UUID | Corresponde al identificador de la sede que se va a consultar | Sede | Contiene el nombre, la dirección y la ciudad de la sede | P-SED-0003 | Asegurar que exista la sede con el id enviado | Informar con un mensaje que no existe una sede con el identificador enviado y por lo tanto no se puede realizar la operación | Detener operación |
| cambiarNombreSede | Permite al administrador cambiar el nombre de la sede | id | UUID | Corresponde al identificador de la sede | Sede | Contiene la sede con su nombre actualizado | P-SED-0003 | Asegurar que exista la sede con el id enviado | Informar con un mensaje que no existe una sede con el identificador enviado y por lo tanto no se puede realizar la operación | Detener operación |
|  |  | datos{nombre} | Sede | Contiene el nuevo nombre de la sede |  |  | P-SED-0006 | Asegurar que los datos requeridos de la sede (barbería, nombre) sean válidos en tipo de dato, longitud, obligatoriedad, formato y rango | Generar una excepción indicándole al administrador cuáles datos de la sede no cumplen con las reglas definidas | Detener operación |
|  |  |  |  |  |  |  | P-SED-0002 | Asegurar que no exista otra sede con el mismo nombre en la misma barbería | Generar una excepción indicándole al administrador que ya existe una sede con ese nombre en la barbería | Detener operación |
| cambiarDireccionSede | Permite al administrador cambiar la dirección de la sede | id | UUID | Corresponde al identificador de la sede | Sede | Contiene la sede con su dirección actualizada | P-SED-0003 | Asegurar que exista la sede con el id enviado | Informar con un mensaje que no existe una sede con el identificador enviado y por lo tanto no se puede realizar la operación | Detener operación |
|  |  | datos{direccion} | Sede | Contiene la nueva dirección de la sede |  |  | P-SED-0007 | Asegurar que los datos requeridos de la sede (barbería, ciudad, dirección) sean válidos en tipo de dato, longitud, obligatoriedad, formato y rango | Generar una excepción indicándole al administrador cuáles datos de la sede no cumplen con las reglas definidas | Detener operación |
| darDeBajaSede | Permite al administrador dar de baja una sede para que deje de operar | id | UUID | Corresponde al identificador de la sede que se va a dar de baja | No retorna ningún valor. En caso de error genera una excepción. |  | P-SED-0003 | Asegurar que exista la sede con el id enviado | Informar con un mensaje que no existe una sede con el identificador enviado y por lo tanto no se puede realizar la operación | Detener operación |
|  |  |  |  |  |  |  | P-SED-0004 | Asegurar que la sede no tenga barberos trabajando actualmente en ella antes de darla de baja | Generar una excepción indicándole al administrador que la sede todavía tiene barberos trabajando en ella | Detener operación |
|  |  |  |  |  |  |  | P-SED-0005 | Asegurar que la sede no tenga citas futuras en estado Agendada antes de darla de baja; las citas pasadas se conservan como historial | Generar una excepción indicándole al administrador que la sede tiene citas futuras agendadas | Detener operación |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Administrador | Registrar sede | Comando que permite al administrador registrar una nueva sede de una barbería en una ciudad | Sede | Barberia | Permite asociar la sede a la barbería a la que pertenece. | P-SED-0001 | Asegurar que los datos requeridos de la sede (barbería, ciudad, nombre, dirección) sean válidos en tipo de dato, longitud, obligatoriedad, formato y rango |  | Sede registrada |  |
|  |  |  |  | Ciudad | Permite asignar la ciudad donde queda la sede. | P-SED-0002 | Asegurar que no exista otra sede con el mismo nombre en la misma barbería |  |  |  |
| Administrador | Ver nombre y direccion de la sede | Permite al administrador consultar el nombre y la dirección de la sede | Sede | Ciudad | Permite mostrar la ciudad en la que queda la sede. |  |  |  | Nombre y dirección de sede consultados |  |
| Barbero | Ver nombre y direccion de la sede | Permite al barbero consultar el nombre y la dirección de la sede | Sede | Ciudad | Permite mostrar la ciudad en la que queda la sede. |  |  |  | Nombre y dirección de sede consultados |  |
| Cliente | Ver nombre y direccion de la sede | Permite al cliente consultar el nombre y la dirección de la sede | Sede | Ciudad | Permite mostrar la ciudad en la que queda la sede. |  |  |  | Nombre y dirección de sede consultados |  |
| Administrador | Cambiar nombre de la sede | Permite al administrador cambiar el nombre de la sede | Sede |  |  | P-SED-0006 | Asegurar que los datos requeridos de la sede (barbería, nombre) sean válidos en tipo de dato, longitud, obligatoriedad, formato y rango |  | Nombre de sede cambiado |  |
|  |  |  |  |  |  | P-SED-0002 | Asegurar que no exista otra sede con el mismo nombre en la misma barbería |  |  |  |
| Administrador | Cambiar la direccion de la sede | Permite al administrador cambiar la dirección de la sede | Sede |  |  | P-SED-0007 | Asegurar que los datos requeridos de la sede (barbería, ciudad, dirección) sean válidos en tipo de dato, longitud, obligatoriedad, formato y rango |  | Dirección de sede cambiada |  |
| Administrador | Dar de baja la sede | Permite al administrador dar de baja una sede para que deje de operar | Sede | Barbero | Permite verificar que ningún barbero trabaje actualmente en la sede. | P-SED-0004 | Asegurar que la sede no tenga barberos trabajando actualmente en ella antes de darla de baja |  | Sede dada de baja |  |
|  |  |  |  | Cita | Permite verificar que no existan citas futuras agendadas en la sede. | P-SED-0005 | Asegurar que la sede no tenga citas futuras en estado Agendada antes de darla de baja; las citas pasadas se conservan como historial |  |  |  |
|  |  |  |  | Agenda | Permite conocer la fecha de cada cita para identificar cuáles son futuras (fecha y horaInicio posteriores al momento actual). |  |  |  |  |  |

### Políticas

| Número Política | Descripción Política | Objeto Responsable |
|---|---|---|
| P-SED-0001 | Asegurar que los datos requeridos de la sede (barbería, ciudad, nombre, dirección) sean válidos en tipo de dato, longitud, obligatoriedad, formato y rango | [Sede](#sede) |
| P-SED-0002 | Asegurar que no exista otra sede con el mismo nombre en la misma barbería | [Sede](#sede) |
| P-SED-0003 | Asegurar que exista la sede con el id enviado | [Sede](#sede) |
| P-SED-0004 | Asegurar que la sede no tenga barberos trabajando actualmente en ella antes de darla de baja | [Barbero](#barbero) |
| P-SED-0005 | Asegurar que la sede no tenga citas futuras en estado Agendada antes de darla de baja; las citas pasadas se conservan como historial | [Cita](#cita) |
| P-SED-0006 | Asegurar que los datos requeridos de la sede (barbería, nombre) sean válidos en tipo de dato, longitud, obligatoriedad, formato y rango | [Sede](#sede) |
| P-SED-0007 | Asegurar que los datos requeridos de la sede (barbería, ciudad, dirección) sean válidos en tipo de dato, longitud, obligatoriedad, formato y rango | [Sede](#sede) |
| P-SED-0008 | Asegurar que no exista otro objeto de tipo Sede con el mismo id; el id solo debe ser único entre los objetos de tipo Sede | [Sede](#sede) |

[↑ Volver al índice](#objetos-de-dominio)

---

## Barbero

**Descripción:** Representa a un trabajador de la barbería que atiende clientes según los servicios que sabe realizar, organiza su propio horario y tiene su agenda personal para atender todas las citas que valla teniendo.  
**Línea de vida:** 4

### Muestreo de datos

- **id**: Representa un identificador que hará unico cada objeto de dominio de este tipo, no se puede repetir
- **primerNombre**: Representa el primer nombre del barbero que trabaja en barbería
- **segundoNombre**: Representa el segundo nombre del barbero que trabaja en barbería
- **primerApellido**: Representa el primer apellido del barbero que trabaja en la barbería
- **segundoApellido**: Representa el segundo apellido del barbero que trabaja en la barbería
- **prefijo**: Representa cual es el prefijo del numero de celular del barbero
- **celular**: Representa el número de celular del barbero, es el dato que el cliente necesita en caso de que tenga que contactarse con el
- **elNumeroCelularEsCorrecto**: Representa si el numero que ingreso el cliente es correcto o no
- **vigente**: Representa si el barbero sigue o no trabajando en la barberia
- **sedeDeTrabajo**: Representa cual es la sede y la barberia donde trabaja el barbero
- **Combinación única  1**: Combinacion única que indica que no puede existir más de un barbero con el mismo prefijo de celular y número de celular

| id | primerNombre | segundoNombre | primerApellido | segundoApellido | prefijo | celular | elNumeroCelularEsCorrecto | vigente | sedeDeTrabajo | Combinación única  1 |
|---|---|---|---|---|---|---|---|---|---|---|
| 1 | Juan | Fernando | García | Lopez | +57 | 3245627890 | Si | si | BarberClub Colombia-Sede Poblado | +57-3245627890 |
| 2 | Juan | David | Ortiz | Sanchez | +57 | 3124518923 | Si | si | BarberClub Colombia-Sede Poblado | +57-3124518923 |
| 3 | Carlos |  | Arbeladez |  | +57 | 3214533321 | Si | si | BarberClub Colombia-Sede Poblado | +57-3214533321 |
| 4 | Andres |  | Ramirez | Patiño | +91 | 9876543210 | Si | no | BarberClub Colombia-Sede Poblado | +91-9876543210 |
| 5 | Juan | Carlos | Zuluaga | Perez | +593 | 998765432 | Si | no | BarberClub Colombia-Sede Poblado | +593-998765432 |

**Combinaciones únicas y datos tomados de otros objetos:**

- **prefijo**: referencia a [PrefijoCelular](#prefijocelular); en los datos de ejemplo se muestra con su combinación única.
- **sedeDeTrabajo**: referencia a [Sede](#sede); en los datos de ejemplo se muestra con su combinación única.
- **Combinación única  1**: formada por `prefijo` + `celular`.

**Clasificación de las columnas del muestreo:**

- Corresponde al identificador unico del objeto de dominio: id
- Corresponde a las referencias de otros objetos de dominio: prefijo, sedeDeTrabajo
- Corresponde a los datos auto generados por el sistema: vigente
- Corresponde a los datos que ingresa el usuario: primerNombre, segundoNombre, primerApellido, segundoApellido, celular, elNumeroCelularEsCorrecto
- Corresponde a la combinacion única: Combinación única  1

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Rendondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | registrarBarbero | editarContactoBarbero | editarContactoBarbero | consultarDatosBarbero | desactivarBarbero | desactivarBarbero | reactivarBarbero | reactivarBarbero | cambiarSedeDeTrabajoBarbero | cambiarSedeDeTrabajoBarbero | consultarServiciosSedeBarbero | eliminarBarbero |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| id | Representa un identificador que hará unico cada objeto de dominio de este tipo, no se puede repetir | Si | Identificador único universal | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No | No aplica | No aplica | No | No | No | UUID vacio | Si | No requerido | Requerido | No modificable | No mostrar | Requerido | No modificable | Requerido | No modificable | Requerido | No modificable | Requerido | Requerido |
| primerNombre | Representa el primer nombre del barbero que trabaja en barbería | No | Alfanumérico | Si | 3 | 50 | No aplica | No aplica | No aplica | No aplica | No aplica | Solo se aceptan caracteres de letras de la 'a' a la 'z', caracteres con tilde y numeros del 0 al 9  | No | No | No | Si | Si | No | vacío | No | Requerido | No requerido | No modificable | Mostrar | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No mostrar | No requerido |
| segundoNombre | Representa el segundo nombre del barbero que trabaja en barbería | No | Alfanumérico | No | 0 | 50 | No aplica | No aplica | No aplica | No aplica | No aplica | Solo se aceptan caracteres de letras de la 'a' a la 'z', caracteres con tilde y numeros del 0 al 9  | No | No | No | Si | Si | No | vacío | No | No requerido | No requerido | No modificable | Mostrar | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No mostrar | No requerido |
| primerApellido | Representa el primer apellido del barbero que trabaja en la barbería | No | Alfanumérico | Si | 3 | 50 | No aplica | No aplica | No aplica | No aplica | No aplica | Solo se aceptan caracteres de letras de la 'a' a la 'z', caracteres con tilde y numeros del 0 al 9 | No | No | No | Si | Si | No | vacío | No | Requerido | No requerido | No modificable | Mostrar | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No mostrar | No requerido |
| segundoApellido | Representa el segundo apellido del barbero que trabaja en la barbería | No | Alfanumérico | No | 0 | 50 | No aplica | No aplica | No aplica | No aplica | No aplica | Solo se aceptan caracteres de letras de la 'a' a la 'z', caracteres con tilde y numeros del 0 al 9 | No | No | No | Si | Si | No | vacío | No | No requerido | No requerido | No modificable | Mostrar | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No mostrar | No requerido |
| prefijo | Representa cual es el prefijo del numero de celular del barbero | No | [PrefijoCelular](#prefijocelular) | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | Aplican las reglas del objeto referenciado | No | No aplica | No aplica | No aplica | No aplica | No | UUID vacio | No | Requerido | Requerido | Modificable | Mostrar | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No mostrar | No requerido |
| celular | Representa el número de celular del barbero, es el dato que el cliente necesita en caso de que tenga que contactarse con el | No | Alfanumérico | Si | 6 | 15 | No aplica | No aplica | No aplica | No aplica | No aplica | Solo se aceptan caracteres de numeros del '0' al '9' | No | No aplica | No aplica | Si | Si | Si | 0 | No | Requerido | Requerido | Modificable | Mostrar | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No mostrar | No requerido |
| elNumeroCelularEsCorrecto | Representa si el numero que ingreso el cliente es correcto o no | No | Lógico | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | El barbero debe de poner un si en este atributo | No | No aplica | No aplica | No aplica | No aplica | No | No | No | Requerido | No requerido | No modificable | No mostrar | Requerido | Modificable | Requerido | Modificable | No requerido | No modificable | No mostrar | No requerido |
| vigente | Representa si el barbero sigue o no trabajando en la barberia | No | Lógico | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | Si | No aplica | No aplica | No aplica | No aplica | No | Si | Si | No requerido | No requerido | No modificable | Mostrar | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No mostrar | No requerido |
| sedeDeTrabajo | Representa cual es la sede y la barberia donde trabaja el barbero | No | [Sede](#sede) | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | Aplican las reglas del objeto referenciado | No | No aplica | No aplica | No aplica | No aplica | No | UUID vacio | No | Requerido | No requerido | No modificable | Mostrar | No requerido | No modificable | No requerido | No modificable | Requerido | Modificable | No mostrar | No requerido |

| Nombre combinación única | Descripción | Atributos involucrados |
|---|---|---|
| Combinación única  1 | Combinacion única que indica que no puede existir más de un barbero con el mismo prefijo de celular y número de celular | prefijo, celular |

| Responsabilidad | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Salida / Descripción | Políticas (Reglas de Negocio) / Política | Políticas (Reglas de Negocio) / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |
|---|---|---|---|---|---|---|---|---|---|---|
| registrarBarbero | Comando que permite el ingreso de un nuevo barbero a trabajar en la barbería | datos{primerNombre, segundoNombre, primerApellido, segundoApellido, prefijoCelular, celular, elNumeroCelularEsCorrecto, sedeDeTrabajo} | Barbero | Contiene la información requerida para registrar un nuevo barbero en la barbería | Barbero | Contiene la información del barbero registrado | P-BAR-0001 | Asegurar que los datos requeridos del barbero (nombre, apellido, prefijo de celular, celular, sede de trabajo) sean válidos en tipo de dato, longitud, obligatoriedad, formato y rango | Generar una excepción indicándole al administrador que los datos ingresados no son válidos | Detener operación |
|  |  |  |  |  |  |  | P-BAR-0002 | Asegurar que el número de celular y prefijo de celular no esté siendo utilizado por otro barbero | Generar una excepción indicándole al usuario que ya existe otro barbero registrado con ese prefijo y número de celular | Detener operación |
|  |  |  |  |  |  |  | P-BAR-0006 | Asegurar que el barbero halla puesto un si en el atributo elNumeroCelularEsCorrecto | Generar una excepción indicándole al administrador que ponga si en elNumeroCelularEsCorrecto | Detener operación |
|  |  |  |  |  |  |  | P-BAR-0013 | Asegurar que no exista otro objeto de tipo Barbero con el mismo id; el id solo debe ser único entre los objetos de tipo Barbero | Generar un nuevo id para el Barbero y volver a validar que no lo tenga otro Barbero | Continuar operación |
| editarContactoBarbero | Permite al barbero actualizar su número de celular y su prefijo | id | UUID | Corresponde al identificador del barbero que va a editar su contacto | Barbero | Contiene la información del barbero con su contacto actualizado | P-BAR-0007 | Asegurar que exista el barbero con el id enviado | Informar con un mensaje que no existe un barbero con el identificador enviado y por lo tanto no es posible editar el contacto del barbero | Detener operación |
|  |  | datos{prefijoCelular, celular} | Barbero | Contiene el nuevo prefijo y número de celular del barbero |  |  | P-BAR-0004 | Asegurar que los datos requeridos del barbero para editar su contacto (prefijo de celular, celular) sean válidos en tipo de dato, longitud, obligatoriedad, formato y rango | Generar una excepción indicándole al usuario cuáles datos de contacto del barbero no cumplen con las reglas definidas | Detener operación |
|  |  |  |  |  |  |  | P-BAR-0002 | Asegurar que el número de celular y prefijo de celular no esté siendo utilizado por otro barbero | Generar una excepción indicándole al usuario que ya existe otro barbero registrado con ese prefijo y número de celular | Detener operación |
| consultarDatosBarbero | Permite al cliente, al barbero y al administrador ver los datos públicos de un barbero, como sus nombres, apellidos y su contacto | id | UUID | Corresponde al identificador del barbero que se va a consultar | Barbero | Contiene la información del barbero consultado por su identificador | P-BAR-0007 | Asegurar que exista el barbero con el id enviado | Informar con un mensaje que no existe un barbero con el identificador enviado y por lo tanto no es posible consultar los datos | Detener operación |
| desactivarBarbero | Permite desactivar a un barbero, ya sea porque deja de trabajar o porque el administrador lo despide, para que ya no pueda recibir nuevas citas, siempre que no tenga citas agendadas pendientes el día de hoy; se eliminan sus agendas futuras con sus citas y todas las multas originadas en sus citas, y se conservan la agenda de hoy y las anteriores | id | UUID | Corresponde al identificador del barbero que va a dejar de trabajar | No retorna ningún valor. En caso de error genera una excepción. |  | P-BAR-0007 | Asegurar que exista el barbero con el id enviado | Informar con un mensaje que no existe un barbero con el identificador enviado y por lo tanto no es posible desactivar el barbero | Detener operación |
|  |  |  |  |  |  |  | P-BAR-0011 | Asegurar que el barbero esté vigente (vigente=sí) | Generar una excepción indicándole al usuario que el barbero ya no se encuentra vigente | Detener operación |
|  |  |  |  |  |  |  | P-BAR-0016 | Asegurar que el barbero no tenga citas en estado Agendada en el día de hoy antes de dejar de trabajar o de ser despedido; las citas de hoy deben quedar finalizadas, registradas con lo que ocurrió o canceladas | Generar una excepción indicándole al usuario que el barbero todavía tiene citas en estado Agendada el día de hoy y cuáles son | Detener operación |
|  |  |  |  |  |  |  | P-BAR-0014 | Al dejar de trabajar el barbero, eliminar todas sus agendas futuras (fecha posterior al día de hoy) junto con sus citas y los servicios de esas citas (CitaServicio); la agenda del día de hoy y las anteriores se conservan como historial | Si alguna de las agendas futuras o de sus citas no se puede eliminar, revertir toda la operación e informar el error | Detener operación |
|  |  |  |  |  |  |  | P-BAR-0015 | Al dejar de trabajar el barbero, eliminar todas las multas originadas en sus citas, pagadas o no; con ellas desaparece el veto que esas multas le generaban al cliente | Si alguna de las multas no se puede eliminar, revertir toda la operación e informar el error | Detener operación |
| reactivarBarbero | Permite al administrador volver a contratar a un barbero para que pueda volver a recibir nuevas citas | id | UUID | Corresponde al identificador del barbero que va a dejar de trabajar | No retorna ningún valor. En caso de error genera una excepción. |  | P-BAR-0007 | Asegurar que exista el barbero con el id enviado | Informar con un mensaje que no existe un barbero con el identificador enviado y por lo tanto no es posible reactivar el barbero | Detener operación |
|  |  |  |  |  |  |  | P-BAR-0012 | Asegurar que el barbero no esté vigente (vigente=no) | Generar una excepción indicándole al administrador que el barbero ya se encuentra vigente | Detener operación |
| cambiarSedeDeTrabajoBarbero | Permite al administrador cambiar la sede en la que trabaja un barbero | id | UUID | Corresponde al identificador del barbero que va a cambiar de sede | Barbero | Contiene la información del barbero con su nueva sede de trabajo | P-BAR-0007 | Asegurar que exista el barbero con el id enviado | Informar con un mensaje que no existe un barbero con el identificador enviado | Detener operación |
|  |  | datos{sedeDeTrabajo} | Barbero | Contiene la nueva sede en la que va a trabajar el barbero |  |  | P-BAR-0009 | Asegurar que los datos requeridos del barbero (sede de trabajo) sean válidos en tipo de dato, longitud, obligatoriedad, formato y rango | Generar una excepción indicándole al administrador cuáles datos de la sede de trabajo no cumplen con las reglas definidas | Detener operación |
|  |  |  |  |  |  |  | P-BAR-0010 | Asegurar que la sede exista en la barberia | Generar una excepción indicándole al administrador que la sede no existe en la barbería | Detener operación |
|  |  |  |  |  |  |  | P-BAR-0008 | Asegurar que el barbero no tenga citas futuras en estado Agendada antes de cambiar de sede | Generar una excepción indicándole al administrador que el barbero no puede cambiar de sede porque tiene citas futuras agendadas | Detener operación |
| consultarServiciosSedeBarbero | Permite al barbero consultar únicamente los servicios disponibles de la sede en la que trabaja | id | UUID | Corresponde al identificador del barbero que consulta los servicios | Lista<Servicio> | Contiene los servicios disponibles de la sede de trabajo del barbero | P-BAR-0007 | Asegurar que exista el barbero con el id enviado | Informar con un mensaje que no existe un barbero con el identificador enviado y por lo tanto no se puede realizar la operación | Detener operación |
|  |  |  |  |  |  |  | P-SER-0014 | Asegurar que el barbero solo pueda consultar los servicios disponibles de la sede en la que trabaja actualmente | Generar una excepción indicándole al barbero que solo puede consultar los servicios de su sede de trabajo | Detener operación |
| eliminarBarbero | Permite al administrador eliminar al barbero de la barbería | id | UUID | Corresponde al identificador del barbero que se va a eliminar | No retorna ningún valor. En caso de error genera una excepción. |  | P-BAR-0007 | Asegurar que exista el barbero con el id enviado | Informar con un mensaje que no existe un barbero con el identificador enviado | Detener operación |
|  |  |  |  |  |  |  | P-BAR-0003 | Asegurar que el barbero no tenga citas futuras pendientes antes de dejar de trabajar en la barbería | Generar una excepción indicándole al administrador que el barbero tiene citas futuras pendientes | Detener operación |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Administrador | Registrar barbero a la barbería | Comando que permite el ingreso de un nuevo barbero a trabajar en la barbería | Barbero |  |  | P-BAR-0001 | Asegurar que los datos requeridos del barbero (nombre, apellido, prefijo de celular, celular, sede de trabajo) sean válidos en tipo de dato, longitud, obligatoriedad, formato y rango |  | Barbero registrado |  |
|  |  |  |  |  |  | P-BAR-0002 | Asegurar que el número de celular y prefijo de celular no esté siendo utilizado por otro barbero |  |  |  |
| Barbero | Editar contacto | Permite al barbero actualizar su número de celular y su prefijo | Barbero |  |  | P-BAR-0004 | Asegurar que los datos requeridos del barbero para editar su contacto (prefijo de celular, celular) sean válidos en tipo de dato, longitud, obligatoriedad, formato y rango |  | Contacto de barbero actualizado |  |
|  |  |  |  |  |  | P-BAR-0002 | Asegurar que el número de celular y prefijo de celular no esté siendo utilizado por otro barbero |  |  |  |
| Cliente | Ver datos de un barbero | Permite a un cliente ver los datos públicos de un barbero, como sus nombres,  apellidos y su contacto | Barbero |  |  |  |  |  | Datos de barbero visto |  |
| Barbero | Ver datos de un barbero | Permite a un barbero ver los datos públicos de otro barbero, como sus nombres,  apellidos y su contacto | Barbero |  |  |  |  |  | Datos de barbero visto |  |
| Administrador | Ver datos de un barbero | Permite a un barbero ver los datos públicos de otro barbero, como sus nombres,  apellidos y su contacto | Barbero |  |  |  |  |  | Datos de barbero visto |  |
| Barbero | Dejar de trabajar en la barbería | Permite desactivar a un barbero para que ya no pueda recibir nuevas citas, siempre que no tenga citas agendadas pendientes el día de hoy; se eliminan sus agendas futuras con sus citas y todas las multas originadas en sus citas, y se conservan la agenda de hoy y las anteriores | Barbero | HorarioBarbero | Permite llegar a las agendas del barbero. | P-BAR-0011 | Asegurar que el barbero esté vigente (vigente=sí) |  | Barbero desactivado |  |
|  |  |  |  | Agenda | Permite identificar la agenda del día de hoy y las agendas futuras (fecha posterior a hoy) que se van a eliminar. | P-BAR-0016 | Asegurar que el barbero no tenga citas en estado Agendada en el día de hoy antes de dejar de trabajar o de ser despedido; las citas de hoy deben quedar finalizadas, registradas con lo que ocurrió o canceladas |  |  |  |
|  |  |  |  | Cita | Permite revisar las citas de hoy del barbero e identificar las citas de sus agendas futuras y las citas de donde salieron sus multas. | P-BAR-0014 | Al dejar de trabajar el barbero, eliminar todas sus agendas futuras (fecha posterior al día de hoy) junto con sus citas y los servicios de esas citas (CitaServicio); la agenda del día de hoy y las anteriores se conservan como historial |  |  |  |
|  |  |  |  | Estado | Permite saber si alguna cita de hoy sigue en estado Agendada. | P-BAR-0015 | Al dejar de trabajar el barbero, eliminar todas las multas originadas en sus citas, pagadas o no; con ellas desaparece el veto que esas multas le generaban al cliente |  |  |  |
|  |  |  |  | CitaServicio | Permite eliminar los servicios de las citas de las agendas futuras que se eliminan. |  |  |  |  |  |
|  |  |  |  | Multa | Permite eliminar todas las multas originadas en las citas del barbero. |  |  |  |  |  |
| Administrador | Volver a contratar al barbero en la barbería | Permite reactivar a un barbero para que pueda volver a recibir nuevas citas | Barbero |  |  | P-BAR-0012 | Asegurar que el barbero no esté vigente (vigente=no) |  | Barbero activado |  |
| Administrador | Cambiar de sede de trabajo | Permite al administrador cambiar la sede en la que trabaja un barbero | Barbero | Sede | Permite identificar la nueva sede de trabajo y la barbería a la que pertenece. | P-BAR-0009 | Asegurar que los datos requeridos del barbero (sede de trabajo) sean válidos en tipo de dato, longitud, obligatoriedad, formato y rango |  | Sede de trabajo del barbero cambiada |  |
|  |  |  |  | Agenda | Permite conocer la fecha de cada cita para identificar cuáles son futuras (fecha y horaInicio posteriores al momento actual). | P-BAR-0008 | Asegurar que el barbero no tenga citas futuras en estado Agendada antes de cambiar de sede |  |  |  |
|  |  |  |  | Cita | Permite identificar las citas del barbero que siguen en estado Agendada | P-BAR-0010 | Asegurar que la sede exista en la barberia |  |  |  |
| Administrador | Despedir al barbero de la barberia | Permite desactivar a un barbero para que ya no pueda recibir nuevas citas, siempre que no tenga citas agendadas pendientes el día de hoy; se eliminan sus agendas futuras con sus citas y todas las multas originadas en sus citas, y se conservan la agenda de hoy y las anteriores | Barbero | HorarioBarbero | Permite llegar a las agendas del barbero. | P-BAR-0011 | Asegurar que el barbero esté vigente (vigente=sí) |  | Barbero desactivado |  |
|  |  |  |  | Agenda | Permite identificar la agenda del día de hoy y las agendas futuras (fecha posterior a hoy) que se van a eliminar. | P-BAR-0016 | Asegurar que el barbero no tenga citas en estado Agendada en el día de hoy antes de dejar de trabajar o de ser despedido; las citas de hoy deben quedar finalizadas, registradas con lo que ocurrió o canceladas |  |  |  |
|  |  |  |  | Cita | Permite revisar las citas de hoy del barbero e identificar las citas de sus agendas futuras y las citas de donde salieron sus multas. | P-BAR-0014 | Al dejar de trabajar el barbero, eliminar todas sus agendas futuras (fecha posterior al día de hoy) junto con sus citas y los servicios de esas citas (CitaServicio); la agenda del día de hoy y las anteriores se conservan como historial |  |  |  |
|  |  |  |  | Estado | Permite saber si alguna cita de hoy sigue en estado Agendada. | P-BAR-0015 | Al dejar de trabajar el barbero, eliminar todas las multas originadas en sus citas, pagadas o no; con ellas desaparece el veto que esas multas le generaban al cliente |  |  |  |
|  |  |  |  | CitaServicio | Permite eliminar los servicios de las citas de las agendas futuras que se eliminan. |  |  |  |  |  |
|  |  |  |  | Multa | Permite eliminar todas las multas originadas en las citas del barbero. |  |  |  |  |  |
| Administrador | Borrar barbero de la barberia | Permite al administrador eliminar al barbero de la barbería | Barbero |  |  | P-BAR-0003 | Asegurar que el barbero no tenga citas futuras pendientes antes de dejar de trabajar en la barbería |  | Barbero eliminado |  |

### Políticas

| Número Política | Descripción Política | Objeto Responsable |
|---|---|---|
| P-BAR-0001 | Asegurar que los datos requeridos del barbero (nombre, apellido, prefijo de celular, celular, sede de trabajo) sean válidos en tipo de dato, longitud, obligatoriedad, formato y rango | [Barbero](#barbero) |
| P-BAR-0002 | Asegurar que el número de celular y prefijo de celular no esté siendo utilizado por otro barbero | [Barbero](#barbero) |
| P-BAR-0003 | Asegurar que el barbero no tenga citas futuras pendientes antes de dejar de trabajar en la barbería | [Cita](#cita) |
| P-BAR-0004 | Asegurar que los datos requeridos del barbero para editar su contacto (prefijo de celular, celular) sean válidos en tipo de dato, longitud, obligatoriedad, formato y rango | [Barbero](#barbero) |
| P-BAR-0006 | Asegurar que el barbero halla puesto un si en el atributo elNumeroCelularEsCorrecto | [Barbero](#barbero) |
| P-BAR-0007 | Asegurar que exista el barbero con el id enviado | [Barbero](#barbero) |
| P-BAR-0008 | Asegurar que el barbero no tenga citas futuras en estado Agendada antes de cambiar de sede | [Cita](#cita) |
| P-BAR-0009 | Asegurar que los datos requeridos del barbero (sede de trabajo) sean válidos en tipo de dato, longitud, obligatoriedad, formato y rango | [Barbero](#barbero) |
| P-BAR-0010 | Asegurar que la sede exista en la barberia | [Sede](#sede) |
| P-BAR-0011 | Asegurar que el barbero esté vigente (vigente=sí) | [Barbero](#barbero) |
| P-BAR-0012 | Asegurar que el barbero no esté vigente (vigente=no) | [Barbero](#barbero) |
| P-BAR-0013 | Asegurar que no exista otro objeto de tipo Barbero con el mismo id; el id solo debe ser único entre los objetos de tipo Barbero | [Barbero](#barbero) |
| P-BAR-0014 | Al dejar de trabajar el barbero, eliminar todas sus agendas futuras (fecha posterior al día de hoy) junto con sus citas y los servicios de esas citas (CitaServicio); la agenda del día de hoy y las anteriores se conservan como historial | [Agenda](#agenda) |
| P-BAR-0015 | Al dejar de trabajar el barbero, eliminar todas las multas originadas en sus citas, pagadas o no; con ellas desaparece el veto que esas multas le generaban al cliente | [Multa](#multa) |
| P-BAR-0016 | Asegurar que el barbero no tenga citas en estado Agendada en el día de hoy antes de dejar de trabajar o de ser despedido; las citas de hoy deben quedar finalizadas, registradas con lo que ocurrió o canceladas | [Cita](#cita) |

[↑ Volver al índice](#objetos-de-dominio)

---

## HorarioSede

**Descripción:** Representa los horarios de apertura y cierre de una sede de la barbería para cada día de la semana; una sede puede tener varios horarios el mismo día (jornada partida) si no se cruzan. El administrador puede definirlos para todas las sedes a la vez o para una sede en particular, y son el límite dentro del cual debe caber el horario de cualquier barbero de esa sede.  
**Línea de vida:** 4

### Muestreo de datos

- **id**: Representa un identificador que hará unico cada objeto de dominio de este tipo, no se puede repetir
- **sede**: Representa la sede de la barbería a la que pertenece el horario de apertura y cierre
- **diaDeLaSemana**: Representa el día de la semana en el que la sede abre
- **horaApertura**: Representa la hora a la que abre la sede en este horario
- **horaCierre**: Representa la hora a la que cierra la sede en este horario
- **fechaCreacion**: Representa la fecha en el que el administrador definio el horario de la sede. Es un dato calculado que toma la fecha del sistema en ese momento
- **fechaDesactivacion**: Representa la fecha en la que este horario dejó de estar vigente. Es un dato calculado que toma la fecha del sistema en ese momento
- **vigente**: Representa si este horario sigue o no vigente en la sede. Una vez que el administrador desactive el horario, no se puede volver a activar
- **Combinación única 1**: Combinación única que indica que no puede existir más de un horario de la misma sede, el mismo día de la semana, con las mismas horas de apertura y cierre y el mismo periodo de vigencia

| id | sede | diaDeLaSemana | horaApertura | horaCierre | fechaCreacion | fechaDesactivacion | vigente | Combinación única 1 |
|---|---|---|---|---|---|---|---|---|
| 1 | BarberClub Colombia-Sede Poblado | Lunes | 09:00 | 19:00 | 12/11/2023 | 1/01/1000 | Si | BarberClub Colombia-Sede Poblado-Lunes-09:00-19:00-12/11/2023-1/01/1000 |
| 2 | BarberClub Colombia-Sede Poblado | Martes | 09:00 | 19:00 | 12/11/2023 | 1/01/1000 | Si | BarberClub Colombia-Sede Poblado-Martes-09:00-19:00-12/11/2023-1/01/1000 |
| 3 | BarberClub Colombia-Sede Poblado | Miércoles | 09:00 | 19:00 | 12/11/2023 | 1/01/1000 | Si | BarberClub Colombia-Sede Poblado-Miércoles-09:00-19:00-12/11/2023-1/01/1000 |
| 4 | BarberClub Colombia-Sede Poblado | Jueves | 09:00 | 19:00 | 12/11/2023 | 1/01/1000 | Si | BarberClub Colombia-Sede Poblado-Jueves-09:00-19:00-12/11/2023-1/01/1000 |
| 5 | BarberClub Colombia-Sede Poblado | Viernes | 09:00 | 19:00 | 12/11/2023 | 1/01/1000 | Si | BarberClub Colombia-Sede Poblado-Viernes-09:00-19:00-12/11/2023-1/01/1000 |
| 6 | BarberClub Colombia-Sede Poblado | Sábado | 08:00 | 21:00 | 12/12/2024 | 1/01/1000 | Si | BarberClub Colombia-Sede Poblado-Sábado-08:00-21:00-12/12/2024-1/01/1000 |
| 7 | BarberClub Colombia-Sede Laureles | Lunes | 08:00 | 20:00 | 15/01/2025 | 1/01/1000 | Si | BarberClub Colombia-Sede Laureles-Lunes-08:00-20:00-15/01/2025-1/01/1000 |
| 8 | BarberClub Colombia-Sede Laureles | Martes | 08:00 | 20:00 | 15/01/2025 | 1/01/1000 | Si | BarberClub Colombia-Sede Laureles-Martes-08:00-20:00-15/01/2025-1/01/1000 |
| 9 | BarberClub Colombia-Sede Laureles | Miércoles | 08:00 | 20:00 | 15/01/2025 | 1/01/1000 | Si | BarberClub Colombia-Sede Laureles-Miércoles-08:00-20:00-15/01/2025-1/01/1000 |
| 10 | BarberClub Colombia-Sede Laureles | Jueves | 08:00 | 20:00 | 15/01/2025 | 1/01/1000 | Si | BarberClub Colombia-Sede Laureles-Jueves-08:00-20:00-15/01/2025-1/01/1000 |
| 11 | BarberClub Colombia-Sede Laureles | Viernes | 08:00 | 20:00 | 15/01/2025 | 1/01/1000 | Si | BarberClub Colombia-Sede Laureles-Viernes-08:00-20:00-15/01/2025-1/01/1000 |
| 12 | BarberClub Colombia-Sede Rionegro | Lunes | 08:00 | 20:00 | 15/01/2025 | 1/01/1000 | Si | BarberClub Colombia-Sede Rionegro-Lunes-08:00-20:00-15/01/2025-1/01/1000 |
| 13 | BarberClub Colombia-Sede Rionegro | Martes | 08:00 | 20:00 | 15/01/2025 | 1/01/1000 | Si | BarberClub Colombia-Sede Rionegro-Martes-08:00-20:00-15/01/2025-1/01/1000 |
| 14 | BarberClub Colombia-Sede Rionegro | Miércoles | 08:00 | 20:00 | 15/01/2025 | 1/01/1000 | Si | BarberClub Colombia-Sede Rionegro-Miércoles-08:00-20:00-15/01/2025-1/01/1000 |
| 15 | BarberClub Colombia-Sede Rionegro | Jueves | 08:00 | 20:00 | 15/01/2025 | 1/01/1000 | Si | BarberClub Colombia-Sede Rionegro-Jueves-08:00-20:00-15/01/2025-1/01/1000 |
| 16 | BarberClub Colombia-Sede Rionegro | Viernes | 08:00 | 20:00 | 15/01/2025 | 1/01/1000 | Si | BarberClub Colombia-Sede Rionegro-Viernes-08:00-20:00-15/01/2025-1/01/1000 |
| 17 | BarberClub Colombia-Sede Laureles | Sábado | 08:00 | 18:00 | 15/01/2025 | 1/01/1000 | Si | BarberClub Colombia-Sede Laureles-Sábado-08:00-18:00-15/01/2025-1/01/1000 |
| 18 | BarberClub Colombia-Sede Rionegro | Sábado | 09:00 | 14:00 | 01/06/2025 | 1/01/1000 | Si | BarberClub Colombia-Sede Rionegro-Sábado-09:00-14:00-01/06/2025-1/01/1000 |
| 19 | BarberClub Colombia-Sede Laureles | Domingo | 10:00 | 14:00 | 01/06/2025 | 1/01/1000 | Si | BarberClub Colombia-Sede Laureles-Domingo-10:00-14:00-01/06/2025-1/01/1000 |
| 20 | Corte y Estilo Barberías-Sede Centro | Lunes | 07:00 | 19:00 | 10/03/2025 | 1/01/1000 | Si | Corte y Estilo Barberías-Sede Centro-Lunes-07:00-19:00-10/03/2025-1/01/1000 |
| 21 | Corte y Estilo Barberías-Sede Centro | Martes | 07:00 | 19:00 | 10/03/2025 | 1/01/1000 | Si | Corte y Estilo Barberías-Sede Centro-Martes-07:00-19:00-10/03/2025-1/01/1000 |
| 22 | Corte y Estilo Barberías-Sede Centro | Miércoles | 07:00 | 19:00 | 10/03/2025 | 1/01/1000 | Si | Corte y Estilo Barberías-Sede Centro-Miércoles-07:00-19:00-10/03/2025-1/01/1000 |
| 23 | BarberClub Colombia-Sede Poblado | Domingo | 09:00 | 13:00 | 04/08/2025 | 1/01/1000 | Si | BarberClub Colombia-Sede Poblado-Domingo-09:00-13:00-04/08/2025-1/01/1000 |
| 24 | BarberClub Colombia-Sede Poblado | Domingo | 15:00 | 18:00 | 04/08/2025 | 1/01/1000 | Si | BarberClub Colombia-Sede Poblado-Domingo-15:00-18:00-04/08/2025-1/01/1000 |
| 25 | Corte y Estilo Barberías-Sede Centro | Jueves | 08:00 | 12:00 | 04/08/2025 | 1/01/1000 | Si | Corte y Estilo Barberías-Sede Centro-Jueves-08:00-12:00-04/08/2025-1/01/1000 |
| 26 | Corte y Estilo Barberías-Sede Centro | Jueves | 14:00 | 18:00 | 04/08/2025 | 1/01/1000 | Si | Corte y Estilo Barberías-Sede Centro-Jueves-14:00-18:00-04/08/2025-1/01/1000 |

**Combinaciones únicas y datos tomados de otros objetos:**

- **sede**: referencia a [Sede](#sede); en los datos de ejemplo se muestra con su combinación única.
- **diaDeLaSemana**: referencia a [DiaSemana](#diasemana); en los datos de ejemplo se muestra con su combinación única.
- **Combinación única 1**: formada por `sede` + `diaDeLaSemana` + `horaApertura` + `horaCierre` + `fechaCreacion` + `fechaDesactivacion`.

**Clasificación de las columnas del muestreo:**

- Corresponde al identificador unico del objeto de dominio: id
- Corresponde a las referencias de otros objetos de dominio: sede, diaDeLaSemana
- Corresponde a los datos auto generados por el sistema: fechaCreacion, fechaDesactivacion, vigente
- Corresponde a los datos que ingresa el usuario: horaApertura, horaCierre
- Corresponde a la combinacion única: Combinación única 1

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Rendondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | definirHorarioTodasLasSedes | definirHorarioSede | cambiarHorasHorarioTodasLasSedes | cambiarHorasHorarioTodasLasSedes | cambiarHorasHorarioSede | cambiarHorasHorarioSede | consultarHorariosSede | consultarHorariosTodasLasSedes | desactivarHorarioTodasLasSedes | desactivarHorarioTodasLasSedes | desactivarHorarioSede | desactivarHorarioSede |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| id | Representa un identificador que hará unico cada objeto de dominio de este tipo, no se puede repetir | Si | Identificador único universal | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No | No aplica | No aplica | No aplica | No aplica | No | UUID vacio | Si | No requerido | No requerido | No requerido | No modificable | Requerido | No modificable | No mostrar | No mostrar | No requerido | No modificable | Requerido | No modificable |
| sede | Representa la sede de la barbería a la que pertenece el horario de apertura y cierre | No | [Sede](#sede) | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | Aplican las reglas del objeto referenciado | No | No aplica | No aplica | No aplica | No aplica | No | UUID vacio | No | No requerido | Requerido | No requerido | No modificable | No requerido | No modificable | No mostrar | Mostrar | No requerido | No modificable | No requerido | No modificable |
| diaDeLaSemana | Representa el día de la semana en el que la sede abre | No | [DiaSemana](#diasemana) | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | Aplican las reglas del objeto referenciado | No | No aplica | No aplica | No aplica | No aplica | No | UUID vacio | No | Requerido | Requerido | Requerido | No modificable | No requerido | No modificable | Mostrar | Mostrar | Requerido | No modificable | No requerido | No modificable |
| horaApertura | Representa la hora a la que abre la sede en este horario | No | Hora | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No | No | No aplica | No aplica | No aplica | No | 00:00 | No | Requerido | Requerido | Requerido | Modificable | Requerido | Modificable | Mostrar | Mostrar | Requerido | No modificable | No requerido | No modificable |
| horaCierre | Representa la hora a la que cierra la sede en este horario | No | Hora | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | Debe ser mayor a horaApertura | No | No | No aplica | No aplica | No aplica | No | 00:00 | No | Requerido | Requerido | Requerido | Modificable | Requerido | Modificable | Mostrar | Mostrar | Requerido | No modificable | No requerido | No modificable |
| fechaCreacion | Representa la fecha en el que el administrador definio el horario de la sede. Es un dato calculado que toma la fecha del sistema en ese momento | No | Fecha | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No | No | No aplica | No aplica | No aplica | No | 1/01/1000 | Si | No requerido | No requerido | No requerido | No modificable | No requerido | No modificable | No mostrar | No mostrar | No requerido | No modificable | No requerido | No modificable |
| fechaDesactivacion | Representa la fecha en la que este horario dejó de estar vigente. Es un dato calculado que toma la fecha del sistema en ese momento | No | Fecha | No | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No | No | No aplica | No aplica | No aplica | No | 1/01/1000 | Si | No requerido | No requerido | No requerido | No modificable | No requerido | No modificable | No mostrar | No mostrar | No requerido | Modificable | No requerido | Modificable |
| vigente | Representa si este horario sigue o no vigente en la sede. Una vez que el administrador desactive el horario, no se puede volver a activar | No | Lógico | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | Una vez que vigente se ponga como no, no se puede volver a cambiar | No | No | No aplica | No aplica | No aplica | No | Si | Si | No requerido | No requerido | No requerido | No modificable | No requerido | No modificable | No mostrar | No mostrar | No requerido | Modificable | No requerido | Modificable |

| Nombre combinación única | Descripción | Atributos involucrados |
|---|---|---|
| Combinación única 1 | Combinación única que indica que no puede existir más de un horario de la misma sede, el mismo día de la semana, con las mismas horas de apertura y cierre y el mismo periodo de vigencia | sede, diaDeLaSemana, horaApertura, horaCierre, fechaCreacion, fechaDesactivacion |

| Responsabilidad | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Salida / Descripción | Políticas (Reglas de Negocio) / Política | Políticas (Reglas de Negocio) / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |
|---|---|---|---|---|---|---|---|---|---|---|
| definirHorarioTodasLasSedes | Comando que permite al administrador registrar un horario de apertura y cierre de un día de la semana en todas las sedes de la barbería con una sola operación; se crea un horario por cada sede. Para una jornada partida se define cada horario del día por separado | datos{barberia, diaDeLaSemana, horaApertura, horaCierre} | HorarioSede | Contiene la barbería y la información del horario que se va a crear en cada una de sus sedes | Lista<HorarioSede> | Contiene los horarios creados, uno por cada sede de la barbería | P-HSE-0001 | Asegurar que los datos requeridos para definir el horario en todas las sedes (barbería, día de la semana, hora de apertura, hora de cierre) sean válidos en tipo de dato, longitud, obligatoriedad, formato y rango | Generar una excepción indicándole al administrador que los datos no cumplen con las reglas definidas | Detener operación |
|  |  |  |  |  |  |  | P-HSE-0002 | Asegurar que existan las sedes en las que se va a crear el horario | Generar una excepción indicándole al administrador que la barbería no tiene sedes registradas | Detener operación |
|  |  |  |  |  |  |  | P-HSE-0004 | Asegurar que la hora de cierre sea mayor a la hora de apertura | Generar una excepción indicandole al administrador que la hora de cierre debe de ser mayor a la hora de apertura | Detener operación |
|  |  |  |  |  |  |  | P-HSE-0006 | Crear el horario solo en las sedes en las que no se cruce con otro horario vigente de ese día; si en todas se cruza, informar que no se creó ningún horario | Informar al administrador en cuáles sedes no se creó el horario porque se cruzaba con otro horario vigente de ese día | Continuar operación |
|  |  |  |  |  |  |  | P-HSE-0016 | Cuando el administrador defina un horario para todas las sedes, los horarios se crean como una sola operación: si alguno no se puede crear, no se crea ninguno. Las sedes omitidas por cruce de horas no cuentan como fallo | Si alguno de los horarios no pudo ser creado, revertir toda la operación e informar el error | Detener operación |
|  |  |  |  |  |  |  | P-HSE-0017 | Asegurar que no exista otro objeto de tipo HorarioSede con el mismo id; el id solo debe ser único entre los objetos de tipo HorarioSede | Generar un nuevo id para el HorarioSede y volver a validar que no lo tenga otro HorarioSede | Continuar operación |
| definirHorarioSede | Comando que permite al administrador registrar un horario de apertura y cierre de un día de la semana solo para una sede; la sede puede tener varios horarios el mismo día si no se cruzan | datos{sede, diaDeLaSemana, horaApertura, horaCierre} | HorarioSede | Contiene la información requerida para registrar el horario de la sede para un día | HorarioSede | Contiene la información del horario de la sede registrado | P-HSE-0003 | Asegurar que los datos requeridos para definir el horario en una sede (sede, día de la semana, hora de apertura, hora de cierre) sean válidos en tipo de dato, longitud, obligatoriedad, formato y rango | Generar una excepción indicándole al administrador que los datos no cumplen con las reglas definidas | Detener operación |
|  |  |  |  |  |  |  | P-HSE-0002 | Asegurar que existan las sedes en las que se va a crear el horario | Generar una excepción indicándole al administrador que la sede no existe | Detener operación |
|  |  |  |  |  |  |  | P-HSE-0004 | Asegurar que la hora de cierre sea mayor a la hora de apertura | Generar una excepción indicandole al administrador que la hora de cierre debe de ser mayor a la hora de apertura | Detener operación |
|  |  |  |  |  |  |  | P-HSE-0005 | Asegurar que el horario no se cruce en horas con otro horario vigente de la misma sede el mismo día de la semana; un horario que termina a la hora en que empieza otro no se considera cruzado | Generar una excepción indicándole al administrador con cuál horario vigente de ese día se cruza el horario que quiere definir | Detener operación |
|  |  |  |  |  |  |  | P-HSE-0017 | Asegurar que no exista otro objeto de tipo HorarioSede con el mismo id; el id solo debe ser único entre los objetos de tipo HorarioSede | Generar un nuevo id para el HorarioSede y volver a validar que no lo tenga otro HorarioSede | Continuar operación |
| cambiarHorasHorarioTodasLasSedes | Permite al administrador cambiar la hora de apertura y de cierre de un horario en todas las sedes de la barbería que lo tienen vigente con ese día y esas horas | filtro{barberia, diaDeLaSemana, horaApertura, horaCierre} | HorarioSede | Contiene la barbería, el día de la semana y las horas actuales del horario que se va a actualizar en todas las sedes | Lista<HorarioSede> | Contiene los horarios de cada sede con sus horas actualizadas | P-HSE-0012 | Asegurar que exista al menos un horario vigente con ese día de la semana y esas horas de apertura y cierre en las sedes de la barbería | Informar con un mensaje que ninguna sede de la barbería tiene un horario vigente con ese día y esas horas | Detener operación |
|  |  | datos{horaApertura, horaCierre} | HorarioSede | Contiene las nuevas horas de apertura y cierre |  |  | P-HSE-0009 | Asegurar que los datos requeridos para cambiar las horas (hora de apertura, hora de cierre) sean válidos en tipo de dato, obligatoriedad, formato y rango | Generar una excepción indicándole al administrador que las horas no cumplen con las reglas definidas | Detener operación |
|  |  |  |  |  |  |  | P-HSE-0004 | Asegurar que la hora de cierre sea mayor a la hora de apertura | Generar una excepción indicandole al administrador que la hora de cierre debe de ser mayor a la hora de apertura | Detener operación |
|  |  |  |  |  |  |  | P-HSE-0010 | Asegurar que las nuevas horas no se crucen con otro horario vigente de la misma sede el mismo día de la semana, sin contar el horario que se está modificando | Generar una excepción indicándole al administrador en cuáles sedes las nuevas horas se cruzarían con otro horario vigente de ese día | Detener operación |
|  |  |  |  |  |  |  | P-HSE-0011 | Asegurar que todos los horarios de barbero vigentes que dependen del horario que se modifica queden dentro de las nuevas horas de apertura y cierre | Generar una excepción indicándole al administrador qué horarios de barbero quedarían por fuera de las nuevas horas | Detener operación |
|  |  |  |  |  |  |  | P-HSE-0013 | Cuando el administrador actualice o desactive un horario en todas las sedes, se modifican todos los horarios vigentes de las sedes de la barbería con ese día y esas horas; si alguno no se puede modificar, se revierte toda la operación | Si alguno de los horarios no pudo ser modificado, revertir toda la operación e informar el error | Detener operación |
| cambiarHorasHorarioSede | Permite al administrador cambiar la hora de apertura y de cierre de un horario de una sede; las demás sedes no se ven afectadas | id | UUID | Corresponde al identificador del horario de la sede que se va a actualizar | HorarioSede | Contiene el horario de la sede con sus horas actualizadas | P-HSE-0007 | Asegurar que exista el horario de la sede con el id enviado | Informar con un mensaje que no existe un horario de la sede con el identificador enviado y por lo tanto no es posible llevar a cabo la operación | Detener operación |
|  |  | datos{horaApertura, horaCierre} | HorarioSede | Contiene las nuevas horas de apertura y cierre |  |  | P-HSE-0008 | Asegurar que el horario de la sede que se va a modificar o desactivar se encuentre vigente | Informar con un mensaje que ese horario ya se encuentra desactivado y por lo tanto no puede modificarse ni volver a desactivarse | Detener operación |
|  |  |  |  |  |  |  | P-HSE-0009 | Asegurar que los datos requeridos para cambiar las horas (hora de apertura, hora de cierre) sean válidos en tipo de dato, obligatoriedad, formato y rango | Generar una excepción indicándole al administrador que las horas no cumplen con las reglas definidas | Detener operación |
|  |  |  |  |  |  |  | P-HSE-0004 | Asegurar que la hora de cierre sea mayor a la hora de apertura | Generar una excepción indicandole al administrador que la hora de cierre debe de ser mayor a la hora de apertura | Detener operación |
|  |  |  |  |  |  |  | P-HSE-0010 | Asegurar que las nuevas horas no se crucen con otro horario vigente de la misma sede el mismo día de la semana, sin contar el horario que se está modificando | Generar una excepción indicándole al administrador con cuál horario vigente de ese día se cruzarían las nuevas horas | Detener operación |
|  |  |  |  |  |  |  | P-HSE-0011 | Asegurar que todos los horarios de barbero vigentes que dependen del horario que se modifica queden dentro de las nuevas horas de apertura y cierre | Generar una excepción indicándole al administrador qué horarios de barbero quedarían por fuera de las nuevas horas | Detener operación |
| consultarHorariosSede | Permite consultar los horarios de apertura y cierre vigentes de una sede para cada día de la semana; un mismo día puede mostrar varios horarios | filtro{sede} | Sede | Contiene la sede de la que se van a consultar los horarios | Lista<HorarioSede> | Contiene todos los horarios vigentes de la sede ordenados por día de la semana y hora de apertura |  |  |  |  |
| consultarHorariosTodasLasSedes | Permite al administrador consultar los horarios de apertura y cierre vigentes de todas las sedes de la barbería | filtro{barberia} | Barberia | Contiene la barbería de la que se van a consultar los horarios | Lista<HorarioSede> | Contiene los horarios vigentes de cada una de las sedes de la barbería |  |  |  |  |
| desactivarHorarioTodasLasSedes | Permite desactivar un horario en todas las sedes de la barbería que lo tienen vigente con ese día y esas horas; los demás horarios del día no se ven afectados | filtro{barberia, diaDeLaSemana, horaApertura, horaCierre} | HorarioSede | Contiene la barbería, el día de la semana y las horas actuales del horario que se va a desactivar en todas las sedes | No retorna ningún valor. En caso de error genera una excepción. |  | P-HSE-0012 | Asegurar que exista al menos un horario vigente con ese día de la semana y esas horas de apertura y cierre en las sedes de la barbería | Informar con un mensaje que ninguna sede de la barbería tiene un horario vigente con ese día y esas horas | Detener operación |
|  |  |  |  |  |  |  | P-HSE-0014 | Asegurar que queden desactivados todos los horarios de barbero que dependen del horario de la sede que se está desactivando | Si alguno de los horarios de barbero no pudo ser desactivado, revertir toda la operación e informar el error | Detener operación |
|  |  |  |  |  |  |  | P-HSE-0015 | Asegurar que queden canceladas, en el estado Cancelación por cambio de políticas de la barbería, todas las citas futuras asociadas a las agendas de los horarios de barbero desactivados. Se consideran futuras las citas cuya agenda tenga una fecha posterior a la fecha actual | Si alguna de las citas futuras no pudo ser cancelada, revertir toda la operación e informar el error | Detener operación |
|  |  |  |  |  |  |  | P-HSE-0013 | Cuando el administrador actualice o desactive un horario en todas las sedes, se modifican todos los horarios vigentes de las sedes de la barbería con ese día y esas horas; si alguno no se puede modificar, se revierte toda la operación | Si alguno de los horarios no pudo ser modificado, revertir toda la operación e informar el error | Detener operación |
| desactivarHorarioSede | Permite desactivar un horario de una sede en el que ya no abrirá; los demás horarios y las demás sedes no se ven afectados | id | UUID | Corresponde al identificador del horario de la sede que se va a desactivar | No retorna ningún valor. En caso de error genera una excepción. |  | P-HSE-0007 | Asegurar que exista el horario de la sede con el id enviado | Informar con un mensaje que no existe un horario de la sede con el identificador enviado y por lo tanto no es posible llevar a cabo la operación | Detener operación |
|  |  |  |  |  |  |  | P-HSE-0008 | Asegurar que el horario de la sede que se va a modificar o desactivar se encuentre vigente | Informar con un mensaje que ese horario ya se encuentra desactivado y por lo tanto no puede modificarse ni volver a desactivarse | Detener operación |
|  |  |  |  |  |  |  | P-HSE-0014 | Asegurar que queden desactivados todos los horarios de barbero que dependen del horario de la sede que se está desactivando | Si alguno de los horarios de barbero no pudo ser desactivado, revertir toda la operación e informar el error | Detener operación |
|  |  |  |  |  |  |  | P-HSE-0015 | Asegurar que queden canceladas, en el estado Cancelación por cambio de políticas de la barbería, todas las citas futuras asociadas a las agendas de los horarios de barbero desactivados. Se consideran futuras las citas cuya agenda tenga una fecha posterior a la fecha actual | Si alguna de las citas futuras no pudo ser cancelada, revertir toda la operación e informar el error | Detener operación |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Administrador | Definir un horario para todas las sedes | Comando que permite registrar un horario de apertura y cierre de un día de la semana en todas las sedes de la barbería con una sola operación. Para una jornada partida se define cada horario del día | HorarioSede | Sede | Permite obtener las sedes de la barbería en las que se va a crear el horario. | P-HSE-0001 | Asegurar que los datos requeridos para definir el horario en todas las sedes (barbería, día de la semana, hora de apertura, hora de cierre) sean válidos en tipo de dato, longitud, obligatoriedad, formato y rango |  | Horario definido para todas las sedes |  |
|  |  |  |  | DiaSemana | Permite asignar el día de la semana en el que abre la sede. | P-HSE-0002 | Asegurar que existan las sedes en las que se va a crear el horario |  |  |  |
|  |  |  |  |  |  | P-HSE-0004 | Asegurar que la hora de cierre sea mayor a la hora de apertura |  |  |  |
|  |  |  |  |  |  | P-HSE-0006 | Crear el horario solo en las sedes en las que no se cruce con otro horario vigente de ese día; si en todas se cruza, informar que no se creó ningún horario |  |  |  |
|  |  |  |  |  |  | P-HSE-0016 | Cuando el administrador defina un horario para todas las sedes, los horarios se crean como una sola operación: si alguno no se puede crear, no se crea ninguno. Las sedes omitidas por cruce de horas no cuentan como fallo |  |  |  |
| Administrador | Definir un horario para una sede | Comando que permite registrar un horario de apertura y cierre de un día de la semana solo para una sede; la sede puede tener varios horarios el mismo día si no se cruzan | HorarioSede | Sede | Permite verificar que la sede exista. | P-HSE-0003 | Asegurar que los datos requeridos para definir el horario en una sede (sede, día de la semana, hora de apertura, hora de cierre) sean válidos en tipo de dato, longitud, obligatoriedad, formato y rango |  | Horario de sede definido |  |
|  |  |  |  | DiaSemana | Permite asignar el día de la semana en el que abre la sede. | P-HSE-0002 | Asegurar que existan las sedes en las que se va a crear el horario |  |  |  |
|  |  |  |  |  |  | P-HSE-0004 | Asegurar que la hora de cierre sea mayor a la hora de apertura |  |  |  |
|  |  |  |  |  |  | P-HSE-0005 | Asegurar que el horario no se cruce en horas con otro horario vigente de la misma sede el mismo día de la semana; un horario que termina a la hora en que empieza otro no se considera cruzado |  |  |  |
| Administrador | Actualizar el horario de todas las sedes | Permite cambiar la hora de apertura y cierre de un horario en todas las sedes de la barbería que lo tienen con ese día y esas horas | HorarioSede | Sede | Permite obtener las sedes de la barbería. | P-HSE-0012 | Asegurar que exista al menos un horario vigente con ese día de la semana y esas horas de apertura y cierre en las sedes de la barbería |  | Horario de todas las sedes actualizado |  |
|  |  |  |  | HorarioBarbero | Permite verificar que los horarios de barbero que dependen de ese horario queden dentro de las nuevas horas. | P-HSE-0009 | Asegurar que los datos requeridos para cambiar las horas (hora de apertura, hora de cierre) sean válidos en tipo de dato, obligatoriedad, formato y rango |  |  |  |
|  |  |  |  |  |  | P-HSE-0004 | Asegurar que la hora de cierre sea mayor a la hora de apertura |  |  |  |
|  |  |  |  |  |  | P-HSE-0010 | Asegurar que las nuevas horas no se crucen con otro horario vigente de la misma sede el mismo día de la semana, sin contar el horario que se está modificando |  |  |  |
|  |  |  |  |  |  | P-HSE-0011 | Asegurar que todos los horarios de barbero vigentes que dependen del horario que se modifica queden dentro de las nuevas horas de apertura y cierre |  |  |  |
|  |  |  |  |  |  | P-HSE-0013 | Cuando el administrador actualice o desactive un horario en todas las sedes, se modifican todos los horarios vigentes de las sedes de la barbería con ese día y esas horas; si alguno no se puede modificar, se revierte toda la operación |  |  |  |
| Administrador | Actualizar el horario de una sede | Permite cambiar la hora de apertura y cierre de un horario de una sede | HorarioSede | HorarioBarbero | Permite verificar que los horarios de barbero que dependen de ese horario queden dentro de las nuevas horas. | P-HSE-0008 | Asegurar que el horario de la sede que se va a modificar o desactivar se encuentre vigente |  | Horario de sede actualizado |  |
|  |  |  |  |  |  | P-HSE-0009 | Asegurar que los datos requeridos para cambiar las horas (hora de apertura, hora de cierre) sean válidos en tipo de dato, obligatoriedad, formato y rango |  |  |  |
|  |  |  |  |  |  | P-HSE-0004 | Asegurar que la hora de cierre sea mayor a la hora de apertura |  |  |  |
|  |  |  |  |  |  | P-HSE-0010 | Asegurar que las nuevas horas no se crucen con otro horario vigente de la misma sede el mismo día de la semana, sin contar el horario que se está modificando |  |  |  |
|  |  |  |  |  |  | P-HSE-0011 | Asegurar que todos los horarios de barbero vigentes que dependen del horario que se modifica queden dentro de las nuevas horas de apertura y cierre |  |  |  |
| Administrador | Ver horario de una sede | Permite al administrador consultar los horarios de apertura y cierre de una sede para cada día de la semana | HorarioSede | DiaSemana | Permite mostrar el día de la semana de cada horario. |  |  |  | Horario de sede consultado |  |
| Barbero | Ver horario de una sede | Permite al barbero consultar los horarios de apertura y cierre de una sede para cada día de la semana | HorarioSede | DiaSemana | Permite mostrar el día de la semana de cada horario. |  |  |  | Horario de sede consultado |  |
| Cliente | Ver horario de una sede | Permite al cliente consultar los horarios de apertura y cierre de una sede para cada día de la semana | HorarioSede | DiaSemana | Permite mostrar el día de la semana de cada horario. |  |  |  | Horario de sede consultado |  |
| Administrador | Ver horarios de todas las sedes | Permite al administrador consultar los horarios de apertura y cierre de todas las sedes de la barbería | HorarioSede | Sede | Permite identificar a qué sede pertenece cada horario. |  |  |  | Horarios de todas las sedes consultados |  |
|  |  |  |  | DiaSemana | Permite mostrar el día de la semana de cada horario. |  |  |  |  |  |
| Administrador | Desactivar el horario de todas las sedes | Permite desactivar un horario en todas las sedes de la barbería que lo tienen con ese día y esas horas | HorarioSede | Sede | Permite obtener las sedes de la barbería. | P-HSE-0012 | Asegurar que exista al menos un horario vigente con ese día de la semana y esas horas de apertura y cierre en las sedes de la barbería |  | Horario de todas las sedes desactivado |  |
|  |  |  |  | HorarioBarbero | Permite identificar los horarios de barbero que dependen de ese horario para desactivarlos. | P-HSE-0014 | Asegurar que queden desactivados todos los horarios de barbero que dependen del horario de la sede que se está desactivando |  |  |  |
|  |  |  |  | Agenda | Permite identificar las citas futuras que quedaron en las agendas de los horarios de barbero desactivados. La agenda no se modifica: solo se recorre para llegar a las citas. | P-HSE-0015 | Asegurar que queden canceladas, en el estado Cancelación por cambio de políticas de la barbería, todas las citas futuras asociadas a las agendas de los horarios de barbero desactivados. Se consideran futuras las citas cuya agenda tenga una fecha posterior a la fecha actual |  |  |  |
|  |  |  |  | Cita | Permite identificar las citas futuras que se deben cancelar. | P-HSE-0013 | Cuando el administrador actualice o desactive un horario en todas las sedes, se modifican todos los horarios vigentes de las sedes de la barbería con ese día y esas horas; si alguno no se puede modificar, se revierte toda la operación |  |  |  |
|  |  |  |  | Estado | Permite dejar esas citas en el estado Cancelación. |  |  |  |  |  |
| Administrador | Desactivar el horario de una sede | Permite desactivar un horario de una sede en el que ya no abrirá | HorarioSede | HorarioBarbero | Permite identificar los horarios de barbero que dependen de ese horario para desactivarlos. | P-HSE-0008 | Asegurar que el horario de la sede que se va a modificar o desactivar se encuentre vigente |  | Horario de sede desactivado |  |
|  |  |  |  | Agenda | Permite identificar las citas futuras que quedaron en las agendas de los horarios de barbero desactivados. La agenda no se modifica: solo se recorre para llegar a las citas. | P-HSE-0014 | Asegurar que queden desactivados todos los horarios de barbero que dependen del horario de la sede que se está desactivando |  |  |  |
|  |  |  |  | Cita | Permite identificar las citas futuras que se deben cancelar. | P-HSE-0015 | Asegurar que queden canceladas, en el estado Cancelación por cambio de políticas de la barbería, todas las citas futuras asociadas a las agendas de los horarios de barbero desactivados. Se consideran futuras las citas cuya agenda tenga una fecha posterior a la fecha actual |  |  |  |
|  |  |  |  | Estado | Permite dejar esas citas en el estado Cancelación. |  |  |  |  |  |

### Políticas

| Número Política | Descripción Política | Objeto Responsable |
|---|---|---|
| P-HSE-0001 | Asegurar que los datos requeridos para definir el horario en todas las sedes (barbería, día de la semana, hora de apertura, hora de cierre) sean válidos en tipo de dato, longitud, obligatoriedad, formato y rango | [HorarioSede](#horariosede) |
| P-HSE-0002 | Asegurar que existan las sedes en las que se va a crear el horario | [Sede](#sede) |
| P-HSE-0003 | Asegurar que los datos requeridos para definir el horario en una sede (sede, día de la semana, hora de apertura, hora de cierre) sean válidos en tipo de dato, longitud, obligatoriedad, formato y rango | [HorarioSede](#horariosede) |
| P-HSE-0004 | Asegurar que la hora de cierre sea mayor a la hora de apertura | [HorarioSede](#horariosede) |
| P-HSE-0005 | Asegurar que el horario no se cruce en horas con otro horario vigente de la misma sede el mismo día de la semana; un horario que termina a la hora en que empieza otro no se considera cruzado | [HorarioSede](#horariosede) |
| P-HSE-0006 | Crear el horario solo en las sedes en las que no se cruce con otro horario vigente de ese día; si en todas se cruza, informar que no se creó ningún horario | [HorarioSede](#horariosede) |
| P-HSE-0007 | Asegurar que exista el horario de la sede con el id enviado | [HorarioSede](#horariosede) |
| P-HSE-0008 | Asegurar que el horario de la sede que se va a modificar o desactivar se encuentre vigente | [HorarioSede](#horariosede) |
| P-HSE-0009 | Asegurar que los datos requeridos para cambiar las horas (hora de apertura, hora de cierre) sean válidos en tipo de dato, obligatoriedad, formato y rango | [HorarioSede](#horariosede) |
| P-HSE-0010 | Asegurar que las nuevas horas no se crucen con otro horario vigente de la misma sede el mismo día de la semana, sin contar el horario que se está modificando | [HorarioSede](#horariosede) |
| P-HSE-0011 | Asegurar que todos los horarios de barbero vigentes que dependen del horario que se modifica queden dentro de las nuevas horas de apertura y cierre | [HorarioBarbero](#horariobarbero) |
| P-HSE-0012 | Asegurar que exista al menos un horario vigente con ese día de la semana y esas horas de apertura y cierre en las sedes de la barbería | [HorarioSede](#horariosede) |
| P-HSE-0013 | Cuando el administrador actualice o desactive un horario en todas las sedes, se modifican todos los horarios vigentes de las sedes de la barbería con ese día y esas horas; si alguno no se puede modificar, se revierte toda la operación | [HorarioSede](#horariosede) |
| P-HSE-0014 | Asegurar que queden desactivados todos los horarios de barbero que dependen del horario de la sede que se está desactivando | [HorarioBarbero](#horariobarbero) |
| P-HSE-0015 | Asegurar que queden canceladas, en el estado Cancelación por cambio de políticas de la barbería, todas las citas futuras asociadas a las agendas de los horarios de barbero desactivados. Se consideran futuras las citas cuya agenda tenga una fecha posterior a la fecha actual | [Cita](#cita) |
| P-HSE-0016 | Cuando el administrador defina un horario para todas las sedes, los horarios se crean como una sola operación: si alguno no se puede crear, no se crea ninguno. Las sedes omitidas por cruce de horas no cuentan como fallo | [HorarioSede](#horariosede) |
| P-HSE-0017 | Asegurar que no exista otro objeto de tipo HorarioSede con el mismo id; el id solo debe ser único entre los objetos de tipo HorarioSede | [HorarioSede](#horariosede) |

[↑ Volver al índice](#objetos-de-dominio)

---

## Servicio

**Descripción:** Representa cada tipo de corte o arreglo que ofrece una sede de la barbería; el administrador puede definirlo para todas las sedes a la vez o para una sede en particular, y cada barbero decide cuáles sabe hacer.  
**Línea de vida:** 4

### Muestreo de datos

- **id**: Representa un identificador que hará unico cada objeto de dominio de este tipo, no se puede repetir
- **sede**: Representa la sede de la barbería a la que pertenece el servicio
- **nombre**: Representa el nombre del servicio, para que el barbero elija los servicios que él sabe hacer
- **descripcion**: Representa una descripcion de que va a hacer cada servicio en la barberia, para que el barbero sepa que hace el servicio
- **precio**: Representa cuanto vale el servicio en pesos colombianos en esa sede
- **disponible**: Representa si el servicio sigue o no disponible en la sede
- **Combinación única 1**: Combinación única que indica que no puede existir más de un servicio con el mismo nombre en la misma sede de la barbería

| id | sede | nombre | descripcion | precio | disponible | Combinación única 1 |
|---|---|---|---|---|---|---|
| 1 | BarberClub Colombia-Sede Poblado | Motilada | Corte de cabello completo con máquina y tijera, incluye lavado y secado | 22000 | si | BarberClub Colombia-Sede Poblado-Motilada |
| 2 | BarberClub Colombia-Sede Poblado | Corte de barba | Recorte de la barba con máquina para dejarla pareja y a la medida que pide el cliente | 12000 | si | BarberClub Colombia-Sede Poblado-Corte de barba |
| 3 | BarberClub Colombia-Sede Poblado | Perfilada de barba | Delineado de los bordes de la barba y el bigote con navaja, sin recortar el largo | 15000 | si | BarberClub Colombia-Sede Poblado-Perfilada de barba |
| 4 | BarberClub Colombia-Sede Poblado | Arreglo completo de barba con toalla caliente | Recorte, perfilado con navaja, toalla caliente, exfoliación y aceite para la barba | 35000 | si | BarberClub Colombia-Sede Poblado-Arreglo completo de barba con toalla caliente |
| 5 | BarberClub Colombia-Sede Poblado | Tinte de barba | Aplicación de tinte para cubrir canas o unificar el color de la barba | 25000 | si | BarberClub Colombia-Sede Poblado-Tinte de barba |
| 6 | BarberClub Colombia-Sede Poblado | Mascarilla facial | Limpieza facial con mascarilla negra para retirar impurezas de la piel | 18000 | no | BarberClub Colombia-Sede Poblado-Mascarilla facial |
| 7 | BarberClub Colombia-Sede Laureles | Motilada | Corte de cabello completo con máquina y tijera, incluye lavado y secado | 24000 | si | BarberClub Colombia-Sede Laureles-Motilada |
| 8 | BarberClub Colombia-Sede Laureles | Corte de barba | Recorte de la barba con máquina para dejarla pareja y a la medida que pide el cliente | 12000 | si | BarberClub Colombia-Sede Laureles-Corte de barba |
| 9 | BarberClub Colombia-Sede Laureles | Perfilada de barba | Delineado de los bordes de la barba y el bigote con navaja, sin recortar el largo | 15000 | si | BarberClub Colombia-Sede Laureles-Perfilada de barba |
| 10 | BarberClub Colombia-Sede Laureles | Tinte de barba | Aplicación de tinte para cubrir canas o unificar el color de la barba | 25000 | no | BarberClub Colombia-Sede Laureles-Tinte de barba |
| 11 | BarberClub Colombia-Sede Rionegro | Motilada | Corte de cabello completo con máquina y tijera, incluye lavado y secado | 18000 | si | BarberClub Colombia-Sede Rionegro-Motilada |
| 12 | BarberClub Colombia-Sede Rionegro | Corte de barba | Recorte de la barba con máquina para dejarla pareja y a la medida que pide el cliente | 12000 | si | BarberClub Colombia-Sede Rionegro-Corte de barba |
| 13 | BarberClub Colombia-Sede Rionegro | Perfilada de barba | Delineado de los bordes de la barba y el bigote con navaja, sin recortar el largo | 15000 | si | BarberClub Colombia-Sede Rionegro-Perfilada de barba |
| 14 | BarberClub Colombia-Sede Rionegro | Tinte de barba | Aplicación de tinte para cubrir canas o unificar el color de la barba | 25000 | si | BarberClub Colombia-Sede Rionegro-Tinte de barba |
| 15 | BarberClub Colombia-Sede Rionegro | Mascarilla facial | Limpieza facial con mascarilla negra para retirar impurezas de la piel | 18000 | si | BarberClub Colombia-Sede Rionegro-Mascarilla facial |
| 16 | Corte y Estilo Barberías-Sede Centro | Motilada | Corte de cabello con máquina y tijera, sin lavado | 25000 | si | Corte y Estilo Barberías-Sede Centro-Motilada |
| 17 | Corte y Estilo Barberías-Sede Centro | Afeitado clásico | Afeitado completo con navaja, espuma caliente y loción | 20000 | si | Corte y Estilo Barberías-Sede Centro-Afeitado clásico |

**Combinaciones únicas y datos tomados de otros objetos:**

- **sede**: referencia a [Sede](#sede); en los datos de ejemplo se muestra con su combinación única.
- **Combinación única 1**: formada por `sede` + `nombre`.

**Clasificación de las columnas del muestreo:**

- Corresponde al identificador unico del objeto de dominio: id
- Corresponde a las referencias de otros objetos de dominio: sede
- Corresponde a los datos auto generados por el sistema: disponible
- Corresponde a los datos que ingresa el usuario: nombre, descripcion, precio
- Corresponde a la combinacion única: Combinación única 1

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Rendondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | definirServicioTodasLasSedes | definirServicioSede | editarServicioTodasLasSedes | editarServicioTodasLasSedes | editarServicioSede | editarServicioSede | consultarServiciosSede | consultarServiciosTodasLasSedes | retirarServicioTodasLasSedes | retirarServicioTodasLasSedes | retirarServicioSede | retirarServicioSede | reactivarServicioTodasLasSedes | reactivarServicioTodasLasSedes | reactivarServicioSede | reactivarServicioSede | consultarServiciosNoDisponiblesSede |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| id | Representa un identificador que hará unico cada objeto de dominio de este tipo, no se puede repetir | Si | Identificador único universal | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No | No aplica | No aplica | No aplica | No aplica | No | UUID vacio | Si | No requerido | No requerido | No requerido | No modificable | Requerido | No modificable | No mostrar | No mostrar | No requerido | No modificable | Requerido | No modificable | No requerido | No modificable | Requerido | No modificable | No mostrar |
| sede | Representa la sede de la barbería a la que pertenece el servicio | No | [Sede](#sede) | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | Aplican las reglas del objeto referenciado | No | No aplica | No aplica | No aplica | No aplica | No | UUID vacio | No | No requerido | Requerido | No requerido | No modificable | No requerido | No modificable | No mostrar | Mostrar | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No mostrar |
| nombre | Representa el nombre del servicio, para que el barbero elija los servicios que él sabe hacer | No | Alfanumérico | Si | 3 | 50 | No aplica | No aplica | No aplica | No aplica | No aplica | Solo se aceptan caracteres de letras de la 'a' a la 'z' y caracteres con tilde | No | No aplica | No aplica | Si | Si | No | Vacio | No | Requerido | Requerido | Requerido | Modificable | Requerido | Modificable | Mostrar | Mostrar | Requerido | No modificable | No requerido | No modificable | Requerido | No modificable | No requerido | No modificable | Mostrar |
| descripcion | Representa una descripcion de que va a hacer cada servicio en la barberia, para que el barbero sepa que hace el servicio | No | Alfanumérico | No | 0 | 200 | No aplica | No aplica | No aplica | No aplica | No aplica | Solo se aceptan caracteres de letras de la 'a' a la 'z', caracteres con tilde y espacios en blanco | No | No aplica | No aplica | Si | Si | No | Vacio | No | Requerido | Requerido | Requerido | Modificable | Requerido | Modificable | Mostrar | Mostrar | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | Mostrar |
| precio | Representa cuanto vale el servicio en pesos colombianos en esa sede | No | Entero | Si | No aplica | No aplica | No aplica | No aplica | 0 | 2000000 | No aplica | No aplica | No | No aplica | No aplica | No aplica | No aplica | No | 0 | No | Requerido | Requerido | Requerido | Modificable | Requerido | Modificable | Mostrar | Mostrar | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | Mostrar |
| disponible | Representa si el servicio sigue o no disponible en la sede | No | Lógico | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No | No aplica | No aplica | No aplica | No aplica | No | Si | Si | No requerido | No requerido | No requerido | No modificable | No requerido | No modificable | No mostrar | No mostrar | No requerido | Modificable | No requerido | Modificable | No requerido | Modificable | No requerido | Modificable | No mostrar |

| Nombre combinación única | Descripción | Atributos involucrados |
|---|---|---|
| Combinación única 1 | Combinación única que indica que no puede existir más de un servicio con el mismo nombre en la misma sede de la barbería | sede, nombre |

| Responsabilidad | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Salida / Descripción | Políticas (Reglas de Negocio) / Política | Políticas (Reglas de Negocio) / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |
|---|---|---|---|---|---|---|---|---|---|---|
| definirServicioTodasLasSedes | Comando que permite al administrador registrar un mismo servicio en todas las sedes de la barbería con una sola operación; se crea un servicio por cada sede | datos{barberia, nombre, descripcion, precio} | Servicio | Contiene la barbería y la información del servicio que se va a crear en cada una de sus sedes | Lista<Servicio> | Contiene los servicios creados, uno por cada sede de la barbería | P-SER-0001 | Asegurar que los datos requeridos para definir el servicio en todas las sedes (barbería, nombre, descripción, precio) sean válidos | Generar una excepción indicándole al administrador cuáles datos del servicio no cumplen con las reglas definidas | Detener operación |
|  |  |  |  |  |  |  | P-SER-0002 | Asegurar que existan las sedes en las que se va a crear el servicio | Generar una excepción indicándole al administrador que la barbería no tiene sedes registradas | Detener operación |
|  |  |  |  |  |  |  | P-SER-0003 | Crear el servicio solo en las sedes de la barbería que no tengan ya un servicio con el mismo nombre; si todas lo tienen, informar que no se creó ningún servicio | Informar al administrador en cuáles sedes no se creó el servicio porque ya existía | Continuar operación |
|  |  |  |  |  |  |  | P-SER-0015 | Cuando el administrador defina un servicio para todas las sedes, los servicios se crean como una sola operación: si alguno no se puede crear, no se crea ninguno. Las sedes omitidas porque ya tenían el servicio no cuentan como fallo | Si alguno de los servicios no pudo ser creado, revertir toda la operación e informar el error | Detener operación |
|  |  |  |  |  |  |  | P-SER-0016 | Asegurar que no exista otro objeto de tipo Servicio con el mismo id; el id solo debe ser único entre los objetos de tipo Servicio | Generar un nuevo id para el Servicio y volver a validar que no lo tenga otro Servicio | Continuar operación |
| definirServicioSede | Comando que permite al administrador registrar un servicio solo en una sede de la barbería | datos{sede, nombre, descripcion, precio} | Servicio | Contiene la información requerida para registrar el servicio en la sede | Servicio | Contiene la información del servicio registrado en la sede | P-SER-0004 | Asegurar que los datos requeridos para definir el servicio en una sede (sede, nombre, descripción, precio) sean válidos | Generar una excepción indicándole al administrador cuáles datos del servicio no cumplen con las reglas definidas | Detener operación |
|  |  |  |  |  |  |  | P-SER-0002 | Asegurar que existan las sedes en las que se va a crear el servicio | Generar una excepción indicándole al administrador que la sede no existe | Detener operación |
|  |  |  |  |  |  |  | P-SER-0005 | Asegurar que no exista otro servicio registrado con el mismo nombre en la misma sede | Generar una excepción indicándole al administrador que ya existe un servicio registrado con ese mismo nombre en la sede | Detener operación |
|  |  |  |  |  |  |  | P-SER-0016 | Asegurar que no exista otro objeto de tipo Servicio con el mismo id; el id solo debe ser único entre los objetos de tipo Servicio | Generar un nuevo id para el Servicio y volver a validar que no lo tenga otro Servicio | Continuar operación |
| editarServicioTodasLasSedes | Permite al administrador modificar el nombre, la descripción y el precio de un servicio en todas las sedes de la barbería que lo tienen | filtro{barberia, nombre} | Servicio | Contiene la barbería y el nombre del servicio que se va a actualizar en todas las sedes | Lista<Servicio> | Contiene los servicios de cada sede con sus datos actualizados | P-SER-0008 | Asegurar que exista al menos un servicio con ese nombre en las sedes de la barbería | Informar con un mensaje que no existe ningún servicio con ese nombre en las sedes de la barbería | Detener operación |
|  |  | datos{nombre, descripcion, precio} | Servicio | Contiene los datos con los que se van a modificar los servicios |  |  | P-SER-0007 | Asegurar que los datos requeridos del servicio (nombre, descripción, precio) sean válidos | Generar una excepción indicándole al administrador cuáles datos del servicio no cumplen con las reglas definidas | Detener operación |
|  |  |  |  |  |  |  | P-SER-0005 | Asegurar que no exista otro servicio registrado con el mismo nombre en la misma sede | Generar una excepción indicándole al administrador en cuáles sedes ya existe un servicio con el nuevo nombre | Detener operación |
|  |  |  |  |  |  |  | P-SER-0009 | Cuando el administrador actualice un servicio en todas las sedes, se modifican todos los servicios de las sedes de la barbería que tengan ese nombre, incluido el precio de las sedes que tenían un precio diferente | Si alguno de los servicios no pudo ser actualizado, revertir toda la operación e informar el error | Detener operación |
| editarServicioSede | Permite al administrador modificar el nombre, la descripción y el precio de un servicio de una sede; las demás sedes no se ven afectadas | id | UUID | Corresponde al identificador del servicio de la sede que se va a editar | Servicio | Contiene la información del servicio con sus datos actualizados | P-SER-0006 | Asegurar que exista el servicio con el id enviado | Informar con un mensaje que no existe un servicio con el identificador enviado y por lo tanto no es posible llevar a cabo la operación | Detener operación |
|  |  | datos{nombre, descripcion, precio} | Servicio | Contiene los datos con los que se va a modificar el servicio |  |  | P-SER-0007 | Asegurar que los datos requeridos del servicio (nombre, descripción, precio) sean válidos | Generar una excepción indicándole al administrador cuáles datos del servicio no cumplen con las reglas definidas | Detener operación |
|  |  |  |  |  |  |  | P-SER-0005 | Asegurar que no exista otro servicio registrado con el mismo nombre en la misma sede | Generar una excepción indicándole al administrador que ya existe un servicio registrado con ese mismo nombre en la sede | Detener operación |
| consultarServiciosSede | Permite consultar los servicios disponibles de una sede de la barbería | filtro{sede} | Sede | Contiene la sede de la que se van a consultar los servicios | Lista<Servicio> | Contiene todos los servicios disponibles en la sede | P-SER-0014 | Asegurar que el barbero solo pueda consultar los servicios disponibles de la sede en la que trabaja actualmente | Generar una excepción indicándole al barbero que solo puede consultar los servicios de su sede de trabajo | Detener operación |
| consultarServiciosTodasLasSedes | Permite al administrador consultar los servicios disponibles de todas las sedes de la barbería | filtro{barberia} | Barberia | Contiene la barbería de la que se van a consultar los servicios | Lista<Servicio> | Contiene los servicios disponibles de cada una de las sedes de la barbería |  |  |  |  |
| retirarServicioTodasLasSedes | Permite retirar un servicio de todas las sedes de la barbería que lo tienen, para que deje de ofrecerse a nuevos clientes y cancelar sus citas futuras | filtro{barberia, nombre} | Servicio | Contiene la barbería y el nombre del servicio que se va a retirar en todas las sedes | No retorna ningún valor. En caso de error genera una excepción. |  | P-SER-0008 | Asegurar que exista al menos un servicio con ese nombre en las sedes de la barbería | Informar con un mensaje que no existe ningún servicio con ese nombre en las sedes de la barbería | Detener operación |
|  |  |  |  |  |  |  | P-SER-0010 | Asegurar que el servicio que se va a retirar no esté siendo ofrecido actualmente por ningún barbero vigente de su sede | Generar una excepción indicándole al administrador que el servicio no se puede retirar porque todavía lo ofrece al menos un barbero vigente de la sede | Detener operación |
|  |  |  |  |  |  |  | P-SER-0011 | Asegurar que el servicio que se va a retirar no se encuentre retirado (disponible = si); al retirar en todas las sedes solo se retiran los que estén disponibles | Informar al administrador que el servicio ya se encuentra retirado en todas las sedes | Detener operación |
|  |  |  |  |  |  |  | P-SER-0013 | Cuando el administrador retire uno o varios servicios, las citas futuras en estado Agendada que incluyan esos servicios deben quedar canceladas en el estado Cancelación; las citas pasadas no se modifican | Si alguna de las citas futuras no pudo ser cancelada, revertir el retiro del servicio | Detener operación |
| retirarServicioSede | Permite retirar un servicio de una sede para que deje de ofrecerse en ella a nuevos clientes y cancelar sus citas futuras; las demás sedes no se ven afectadas | id | UUID | Corresponde al identificador del servicio de la sede que se va a retirar | No retorna ningún valor. En caso de error genera una excepción. |  | P-SER-0006 | Asegurar que exista el servicio con el id enviado | Informar con un mensaje que no existe un servicio con el identificador enviado y por lo tanto no es posible llevar a cabo la operación | Detener operación |
|  |  |  |  |  |  |  | P-SER-0010 | Asegurar que el servicio que se va a retirar no esté siendo ofrecido actualmente por ningún barbero vigente de su sede | Generar una excepción indicándole al administrador que el servicio no se puede retirar porque todavía lo ofrece al menos un barbero vigente de la sede | Detener operación |
|  |  |  |  |  |  |  | P-SER-0011 | Asegurar que el servicio que se va a retirar no se encuentre retirado (disponible = si); al retirar en todas las sedes solo se retiran los que estén disponibles | Generar una excepción indicándole al administrador que el servicio ya se encuentra retirado | Detener operación |
|  |  |  |  |  |  |  | P-SER-0013 | Cuando el administrador retire uno o varios servicios, las citas futuras en estado Agendada que incluyan esos servicios deben quedar canceladas en el estado Cancelación; las citas pasadas no se modifican | Si alguna de las citas futuras no pudo ser cancelada, revertir el retiro del servicio | Detener operación |
| reactivarServicioTodasLasSedes | Permite volver a ofrecer un servicio en todas las sedes de la barbería en las que estaba retirado | filtro{barberia, nombre} | Servicio | Contiene la barbería y el nombre del servicio que se va a volver a ofrecer en todas las sedes | No retorna ningún valor. En caso de error genera una excepción. |  | P-SER-0008 | Asegurar que exista al menos un servicio con ese nombre en las sedes de la barbería | Informar con un mensaje que no existe ningún servicio con ese nombre en las sedes de la barbería | Detener operación |
|  |  |  |  |  |  |  | P-SER-0012 | Asegurar que el servicio que se va a volver a ofrecer se encuentre retirado (disponible = no); al volver a ofrecer en todas las sedes solo se reactivan los que estén retirados | Informar al administrador que el servicio ya se encuentra disponible en todas las sedes | Detener operación |
| reactivarServicioSede | Permite volver a ofrecer un servicio que había sido retirado de una sede, para que vuelva a estar disponible para nuevos clientes de esa sede | id | UUID | Corresponde al identificador del servicio de la sede que se va a volver a ofrecer | No retorna ningún valor. En caso de error genera una excepción. |  | P-SER-0006 | Asegurar que exista el servicio con el id enviado | Informar con un mensaje que no existe un servicio con el identificador enviado y por lo tanto no es posible llevar a cabo la operación | Detener operación |
|  |  |  |  |  |  |  | P-SER-0012 | Asegurar que el servicio que se va a volver a ofrecer se encuentre retirado (disponible = no); al volver a ofrecer en todas las sedes solo se reactivan los que estén retirados | Generar una excepción indicándole al administrador que el servicio ya se encuentra disponible | Detener operación |
| consultarServiciosNoDisponiblesSede | Permite al administrador consultar los servicios retirados de una sede de la barbería | filtro{sede} | Sede | Contiene la sede de la que se van a consultar los servicios retirados | Lista<Servicio> | Contiene todos los servicios retirados en la sede |  |  |  |  |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Administrador | Definir un servicio para todas las sedes | Comando que permite registrar un mismo servicio en todas las sedes de la barbería con una sola operación | Servicio | Sede | Permite obtener las sedes de la barbería en las que se va a crear el servicio. | P-SER-0001 | Asegurar que los datos requeridos para definir el servicio en todas las sedes (barbería, nombre, descripción, precio) sean válidos |  | Servicio definido para todas las sedes |  |
|  |  |  |  |  |  | P-SER-0002 | Asegurar que existan las sedes en las que se va a crear el servicio |  |  |  |
|  |  |  |  |  |  | P-SER-0003 | Crear el servicio solo en las sedes de la barbería que no tengan ya un servicio con el mismo nombre; si todas lo tienen, informar que no se creó ningún servicio |  |  |  |
|  |  |  |  |  |  | P-SER-0015 | Cuando el administrador defina un servicio para todas las sedes, los servicios se crean como una sola operación: si alguno no se puede crear, no se crea ninguno. Las sedes omitidas porque ya tenían el servicio no cuentan como fallo |  |  |  |
| Administrador | Definir un servicio para una sede | Comando que permite registrar un servicio solo en una sede de la barbería | Servicio | Sede | Permite verificar que la sede exista. | P-SER-0004 | Asegurar que los datos requeridos para definir el servicio en una sede (sede, nombre, descripción, precio) sean válidos |  | Servicio definido para la sede |  |
|  |  |  |  |  |  | P-SER-0002 | Asegurar que existan las sedes en las que se va a crear el servicio |  |  |  |
|  |  |  |  |  |  | P-SER-0005 | Asegurar que no exista otro servicio registrado con el mismo nombre en la misma sede |  |  |  |
| Administrador | Actualizar un servicio en todas las sedes | Permite modificar el nombre, la descripción y el precio de un servicio en todas las sedes de la barbería que lo tienen | Servicio | Sede | Permite obtener las sedes de la barbería. | P-SER-0008 | Asegurar que exista al menos un servicio con ese nombre en las sedes de la barbería |  | Servicio actualizado en todas las sedes |  |
|  |  |  |  |  |  | P-SER-0007 | Asegurar que los datos requeridos del servicio (nombre, descripción, precio) sean válidos |  |  |  |
|  |  |  |  |  |  | P-SER-0005 | Asegurar que no exista otro servicio registrado con el mismo nombre en la misma sede |  |  |  |
|  |  |  |  |  |  | P-SER-0009 | Cuando el administrador actualice un servicio en todas las sedes, se modifican todos los servicios de las sedes de la barbería que tengan ese nombre, incluido el precio de las sedes que tenían un precio diferente |  |  |  |
| Administrador | Actualizar un servicio de una sede | Permite modificar el nombre, la descripción y el precio de un servicio de una sede | Servicio |  |  | P-SER-0007 | Asegurar que los datos requeridos del servicio (nombre, descripción, precio) sean válidos |  | Servicio de la sede actualizado |  |
|  |  |  |  |  |  | P-SER-0005 | Asegurar que no exista otro servicio registrado con el mismo nombre en la misma sede |  |  |  |
| Administrador | Ver servicios de una sede | Permite al administrador consultar los servicios disponibles de una sede | Servicio |  |  |  |  |  | Servicios de la sede consultados |  |
| Barbero | Ver servicios de una sede | Permite al barbero consultar los servicios disponibles de la sede en la que trabaja | Servicio | Barbero | Permite conocer la sede en la que trabaja actualmente el barbero. | P-SER-0014 | Asegurar que el barbero solo pueda consultar los servicios disponibles de la sede en la que trabaja actualmente |  | Servicios de la sede consultados |  |
| Cliente | Ver servicios de una sede | Permite al cliente consultar los servicios disponibles de una sede | Servicio |  |  |  |  |  | Servicios de la sede consultados |  |
| Administrador | Ver servicios de todas las sedes | Permite al administrador consultar los servicios disponibles de todas las sedes de la barbería | Servicio | Sede | Permite obtener las sedes de la barbería. |  |  |  | Servicios de todas las sedes consultados |  |
| Administrador | Retirar un servicio de todas las sedes | Permite retirar un servicio de todas las sedes de la barbería que lo tienen, para que deje de ofrecerse a nuevos clientes | Servicio | Sede | Permite obtener las sedes de la barbería. | P-SER-0008 | Asegurar que exista al menos un servicio con ese nombre en las sedes de la barbería |  | Servicio retirado de todas las sedes |  |
|  |  |  |  | BarberoServicio | Permite verificar que ningún barbero vigente de la sede ofrezca el servicio. | P-SER-0010 | Asegurar que el servicio que se va a retirar no esté siendo ofrecido actualmente por ningún barbero vigente de su sede |  |  |  |
|  |  |  |  | CitaServicio | Permite identificar las citas que incluyen el servicio que se va a retirar. | P-SER-0011 | Asegurar que el servicio que se va a retirar no se encuentre retirado (disponible = si); al retirar en todas las sedes solo se retiran los que estén disponibles |  |  |  |
|  |  |  |  | Cita | Permite identificar cuáles de esas citas son futuras y siguen en estado Agendada. | P-SER-0013 | Cuando el administrador retire uno o varios servicios, las citas futuras en estado Agendada que incluyan esos servicios deben quedar canceladas en el estado Cancelación; las citas pasadas no se modifican |  |  |  |
|  |  |  |  | Agenda | Permite conocer la fecha de cada cita para identificar cuáles son futuras (fecha y hora de inicio posteriores al momento actual). |  |  |  |  |  |
|  |  |  |  | Estado | Permite dejar esas citas en el estado Cancelación. |  |  |  |  |  |
| Administrador | Retirar un servicio de una sede | Permite retirar un servicio de una sede para que deje de ofrecerse en ella a nuevos clientes | Servicio | BarberoServicio | Permite verificar que ningún barbero vigente de la sede ofrezca el servicio. | P-SER-0010 | Asegurar que el servicio que se va a retirar no esté siendo ofrecido actualmente por ningún barbero vigente de su sede |  | Servicio retirado de la sede |  |
|  |  |  |  | CitaServicio | Permite identificar las citas que incluyen el servicio que se va a retirar. | P-SER-0011 | Asegurar que el servicio que se va a retirar no se encuentre retirado (disponible = si); al retirar en todas las sedes solo se retiran los que estén disponibles |  |  |  |
|  |  |  |  | Cita | Permite identificar cuáles de esas citas son futuras y siguen en estado Agendada. | P-SER-0013 | Cuando el administrador retire uno o varios servicios, las citas futuras en estado Agendada que incluyan esos servicios deben quedar canceladas en el estado Cancelación; las citas pasadas no se modifican |  |  |  |
|  |  |  |  | Agenda | Permite conocer la fecha de cada cita para identificar cuáles son futuras (fecha y hora de inicio posteriores al momento actual). |  |  |  |  |  |
|  |  |  |  | Estado | Permite dejar esas citas en el estado Cancelación. |  |  |  |  |  |
| Administrador | Volver a ofrecer un servicio en todas las sedes | Permite volver a habilitar un servicio en todas las sedes de la barbería en las que estaba retirado | Servicio | Sede | Permite obtener las sedes de la barbería. | P-SER-0008 | Asegurar que exista al menos un servicio con ese nombre en las sedes de la barbería |  | Servicio reactivado en todas las sedes |  |
|  |  |  |  |  |  | P-SER-0012 | Asegurar que el servicio que se va a volver a ofrecer se encuentre retirado (disponible = no); al volver a ofrecer en todas las sedes solo se reactivan los que estén retirados |  |  |  |
| Administrador | Volver a ofrecer un servicio en una sede | Permite volver a habilitar un servicio que había sido retirado de una sede | Servicio |  |  | P-SER-0012 | Asegurar que el servicio que se va a volver a ofrecer se encuentre retirado (disponible = no); al volver a ofrecer en todas las sedes solo se reactivan los que estén retirados |  | Servicio reactivado en la sede |  |
| Administrador | Ver servicios no disponibles de una sede | Permite consultar los servicios retirados de una sede de la barbería | Servicio |  |  |  |  |  | Servicios no disponibles de la sede consultados |  |

### Políticas

| Número Política | Descripción Política | Objeto Responsable |
|---|---|---|
| P-SER-0001 | Asegurar que los datos requeridos para definir el servicio en todas las sedes (barbería, nombre, descripción, precio) sean válidos | [Servicio](#servicio) |
| P-SER-0002 | Asegurar que existan las sedes en las que se va a crear el servicio | [Sede](#sede) |
| P-SER-0003 | Crear el servicio solo en las sedes de la barbería que no tengan ya un servicio con el mismo nombre; si todas lo tienen, informar que no se creó ningún servicio | [Servicio](#servicio) |
| P-SER-0004 | Asegurar que los datos requeridos para definir el servicio en una sede (sede, nombre, descripción, precio) sean válidos | [Servicio](#servicio) |
| P-SER-0005 | Asegurar que no exista otro servicio registrado con el mismo nombre en la misma sede | [Servicio](#servicio) |
| P-SER-0006 | Asegurar que exista el servicio con el id enviado | [Servicio](#servicio) |
| P-SER-0007 | Asegurar que los datos requeridos del servicio (nombre, descripción, precio) sean válidos | [Servicio](#servicio) |
| P-SER-0008 | Asegurar que exista al menos un servicio con ese nombre en las sedes de la barbería | [Servicio](#servicio) |
| P-SER-0009 | Cuando el administrador actualice un servicio en todas las sedes, se modifican todos los servicios de las sedes de la barbería que tengan ese nombre, incluido el precio de las sedes que tenían un precio diferente | [Servicio](#servicio) |
| P-SER-0010 | Asegurar que el servicio que se va a retirar no esté siendo ofrecido actualmente por ningún barbero vigente de su sede | [BarberoServicio](#barberoservicio) |
| P-SER-0011 | Asegurar que el servicio que se va a retirar no se encuentre retirado (disponible = si); al retirar en todas las sedes solo se retiran los que estén disponibles | [Servicio](#servicio) |
| P-SER-0012 | Asegurar que el servicio que se va a volver a ofrecer se encuentre retirado (disponible = no); al volver a ofrecer en todas las sedes solo se reactivan los que estén retirados | [Servicio](#servicio) |
| P-SER-0013 | Cuando el administrador retire uno o varios servicios, las citas futuras en estado Agendada que incluyan esos servicios deben quedar canceladas en el estado Cancelación; las citas pasadas no se modifican | [Cita](#cita) |
| P-SER-0014 | Asegurar que el barbero solo pueda consultar los servicios disponibles de la sede en la que trabaja actualmente | [Barbero](#barbero) |
| P-SER-0015 | Cuando el administrador defina un servicio para todas las sedes, los servicios se crean como una sola operación: si alguno no se puede crear, no se crea ninguno. Las sedes omitidas porque ya tenían el servicio no cuentan como fallo | [Servicio](#servicio) |
| P-SER-0016 | Asegurar que no exista otro objeto de tipo Servicio con el mismo id; el id solo debe ser único entre los objetos de tipo Servicio | [Servicio](#servicio) |

[↑ Volver al índice](#objetos-de-dominio)

---

## PeriodoCierre

**Descripción:** Representa un intervalo de fecha y hora durante el cual una sede de la barbería permanece cerrada por una decisión de la barbería (por ejemplo vacaciones, mantenimiento o remodelación): mientras dura no se atiende a clientes ni se pueden agendar citas que se crucen con él. El administrador puede registrarlo para todas las sedes de la barbería a la vez o para una sede en particular.  
**Línea de vida:** 4

### Muestreo de datos

- **id**: Representa un identificador que hará unico cada objeto de dominio de este tipo, no se puede repetir
- **sede**: Representa la sede de la barbería que permanece cerrada durante este periodo. A través de la sede se conoce la barbería, por eso el periodo no guarda la barbería
- **fechaHoraInicio**: Representa la fecha y hora en la que la sede empieza a estar cerrada; desde ese momento no se atiende a clientes ni se pueden agendar citas
- **fechaHoraFinal**: Representa la fecha y hora en la que la sede vuelve a abrir; una cita puede empezar justo en este momento
- **motivo**: Representa por qué la sede permanece cerrada (por ejemplo vacaciones, mantenimiento o remodelación); se le muestra al administrador, al barbero y al cliente
- **Combinación única 1**: Combinación única que indica que una misma sede no puede tener dos periodos de cierre con la misma fecha y hora de inicio y la misma fecha y hora final

| id | sede | fechaHoraInicio | fechaHoraFinal | motivo | Combinación única 1 |
|---|---|---|---|---|---|
| 1 | BarberClub Colombia-Sede Poblado | 19/10/2026 08:00 | 21/10/2026 20:00 | Remodelación del área de lavado y de las sillas | BarberClub Colombia-Sede Poblado-19/10/2026 08:00-21/10/2026 20:00 |
| 2 | BarberClub Colombia-Sede Laureles | 03/11/2026 14:00 | 03/11/2026 18:00 | Mantenimiento de la red eléctrica del local | BarberClub Colombia-Sede Laureles-03/11/2026 14:00-03/11/2026 18:00 |
| 3 | BarberClub Colombia-Sede Poblado | 24/12/2026 00:00 | 02/01/2027 00:00 | Vacaciones colectivas de fin de año | BarberClub Colombia-Sede Poblado-24/12/2026 00:00-02/01/2027 00:00 |
| 4 | BarberClub Colombia-Sede Laureles | 24/12/2026 00:00 | 02/01/2027 00:00 | Vacaciones colectivas de fin de año | BarberClub Colombia-Sede Laureles-24/12/2026 00:00-02/01/2027 00:00 |
| 5 | BarberClub Colombia-Sede Rionegro | 24/12/2026 00:00 | 02/01/2027 00:00 | Vacaciones colectivas de fin de año | BarberClub Colombia-Sede Rionegro-24/12/2026 00:00-02/01/2027 00:00 |
| 6 | BarberClub Colombia-Sede Rionegro | 28/09/2026 08:00 | 30/09/2026 20:00 | Fumigación del local | BarberClub Colombia-Sede Rionegro-28/09/2026 08:00-30/09/2026 20:00 |
| 7 | Corte y Estilo Barberías-Sede Centro | 16/11/2026 00:00 | 17/11/2026 00:00 | Inventario anual de productos | Corte y Estilo Barberías-Sede Centro-16/11/2026 00:00-17/11/2026 00:00 |
| 8 | Corte y Estilo Barberías-Sede Centro | 31/12/2026 15:00 | 01/01/2027 00:00 | Cierre anticipado por fin de año | Corte y Estilo Barberías-Sede Centro-31/12/2026 15:00-01/01/2027 00:00 |

**Combinaciones únicas y datos tomados de otros objetos:**

- **sede**: referencia a [Sede](#sede); en los datos de ejemplo se muestra con su combinación única.
- **Combinación única 1**: formada por `sede` + `fechaHoraInicio` + `fechaHoraFinal`.

**Clasificación de las columnas del muestreo:**

- Corresponde al identificador unico del objeto de dominio: id
- Corresponde a las referencias de otros objetos de dominio: sede
- Corresponde a los datos que ingresa el usuario: fechaHoraInicio, fechaHoraFinal, motivo
- Corresponde a la combinacion única: Combinación única 1

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Rendondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | definirPeriodoCierreTodasLasSedes | definirPeriodoCierreSede | cambiarPeriodoCierreTodasLasSedes | cambiarPeriodoCierreTodasLasSedes | cambiarPeriodoCierreSede | cambiarPeriodoCierreSede | consultarPeriodosCierreSede | consultarPeriodosCierreTodasLasSedes | consultarPeriodosCierrePorSedeYRango | eliminarPeriodoCierreTodasLasSedes | eliminarPeriodoCierreSede |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| id | Representa un identificador que hará unico cada objeto de dominio de este tipo, no se puede repetir | Si | Identificador único universal | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No | No aplica | No aplica | No aplica | No aplica | No | UUID vacio | Si | No requerido | No requerido | No requerido | No modificable | Requerido | No modificable | No mostrar | No mostrar | No mostrar | No requerido | Requerido |
| sede | Representa la sede de la barbería que permanece cerrada durante este periodo. A través de la sede se conoce la barbería, por eso el periodo no guarda la barbería | No | [Sede](#sede) | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | Aplican las reglas del objeto referenciado | No | No aplica | No aplica | No aplica | No aplica | No | UUID vacio | No | No requerido | Requerido | No requerido | No modificable | No requerido | No modificable | No mostrar | Mostrar | No mostrar | No requerido | No requerido |
| fechaHoraInicio | Representa la fecha y hora en la que la sede empieza a estar cerrada; desde ese momento no se atiende a clientes ni se pueden agendar citas | No | Fecha hora | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | Debe ser posterior al momento actual al registrar el periodo de cierre; no se puede cambiar cuando el periodo ya empezó | No | No aplica | No aplica | No aplica | No aplica | No | 01/01/1000 00:00 | No | Requerido | Requerido | Requerido | Modificable | Requerido | Modificable | Mostrar | Mostrar | Mostrar | Requerido | No requerido |
| fechaHoraFinal | Representa la fecha y hora en la que la sede vuelve a abrir; una cita puede empezar justo en este momento | No | Fecha hora | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | Debe ser posterior a fechaHoraInicio. El intervalo se toma desde fechaHoraInicio (incluida) hasta fechaHoraFinal (excluida): una cita puede empezar justo en fechaHoraFinal | No | No aplica | No aplica | No aplica | No aplica | No | 01/01/1000 00:00 | No | Requerido | Requerido | Requerido | Modificable | Requerido | Modificable | Mostrar | Mostrar | Mostrar | Requerido | No requerido |
| motivo | Representa por qué la sede permanece cerrada (por ejemplo vacaciones, mantenimiento o remodelación); se le muestra al administrador, al barbero y al cliente | No | Alfanumérico | Si | 5 | 100 | No aplica | No aplica | No aplica | No aplica | No aplica | Describe por qué la sede permanece cerrada; se le informa al cliente cuando intenta agendar una cita que se cruza con el periodo | No | No aplica | No aplica | Si | Si | No | Vacio | No | Requerido | Requerido | Requerido | Modificable | Requerido | Modificable | Mostrar | Mostrar | Mostrar | No requerido | No requerido |

| Nombre combinación única | Descripción | Atributos involucrados |
|---|---|---|
| Combinación única 1 | Combinación única que indica que una misma sede no puede tener dos periodos de cierre con la misma fecha y hora de inicio y la misma fecha y hora final | sede, fechaHoraInicio, fechaHoraFinal |

| Responsabilidad | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Salida / Descripción | Políticas (Reglas de Negocio) / Política | Políticas (Reglas de Negocio) / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |
|---|---|---|---|---|---|---|---|---|---|---|
| definirPeriodoCierreTodasLasSedes | Comando que permite al administrador registrar con una sola operación un periodo en el que todas las sedes de la barbería permanecen cerradas; se crea un periodo de cierre por cada sede; las citas agendadas que se crucen con el periodo de cierre se cancelan | datos{barberia, fechaHoraInicio, fechaHoraFinal, motivo} | PeriodoCierre | Contiene la barbería, la fecha y hora en que empieza y termina el cierre y su motivo | Lista<PeriodoCierre> | Contiene los periodos de cierre registrados, uno por cada sede de la barbería | P-PCI-0001 | Asegurar que los datos requeridos para definir el periodo de cierre en todas las sedes (barbería, fecha y hora de inicio, fecha y hora final, motivo) sean válidos en tipo de dato, longitud, obligatoriedad, formato y rango | Generar una excepción indicándole al administrador cuáles datos no cumplen con las reglas definidas | Detener operación |
|  |  |  |  |  |  |  | P-PCI-0002 | Asegurar que existan las sedes en las que se va a registrar el periodo de cierre | Generar una excepción indicándole al administrador que la barbería no tiene sedes registradas | Detener operación |
|  |  |  |  |  |  |  | P-PCI-0003 | Asegurar que la fecha y hora final del periodo de cierre sea mayor a su fecha y hora de inicio | Generar una excepción indicándole al administrador que la fecha y hora final debe ser mayor a la fecha y hora de inicio | Detener operación |
|  |  |  |  |  |  |  | P-PCI-0004 | Asegurar que la fecha y hora de inicio del periodo de cierre sea posterior al momento actual; no se puede registrar un cierre que empiece en un momento que ya pasó | Generar una excepción indicándole al administrador que el periodo de cierre no puede empezar en un momento que ya pasó | Detener operación |
|  |  |  |  |  |  |  | P-PCI-0005 | Registrar el periodo de cierre solo en las sedes de la barbería en las que no se cruce con otro periodo de cierre de esa sede; si en todas se cruza, informar que no se registró en ninguna sede | Informar al administrador en cuáles sedes no se registró el periodo de cierre porque se cruza con otro periodo de cierre que ya tenían | Continuar operación |
|  |  |  |  |  |  |  | P-PCI-0006 | Cuando se registre o se cambie un periodo de cierre, cancelar en el estado Cancelación todas las citas en estado Agendada de la sede que se crucen con él. Cada cita ocupa desde la fecha de su agenda con su horaInicio hasta esa misma fecha con su horaFinEstimada, y se cruza con el cierre cuando empieza antes de la fecha y hora final del cierre y termina después de su fecha y hora de inicio. No aplica el límite de 2 horas para cancelar, las citas que no están en estado Agendada no se modifican y las agendas ya creadas se conservan | Si alguna de las citas que se cruzan con el periodo de cierre no se puede cancelar, revertir toda la operación e informar el error | Detener operación |
|  |  |  |  |  |  |  | P-PCI-0007 | Cuando el administrador registre, cambie o elimine un periodo de cierre en todas las sedes, la operación se realiza como una sola: si no se puede aplicar en alguna sede, no se aplica en ninguna. Las sedes omitidas porque el periodo se cruza con otro periodo de cierre que ya tenían no cuentan como fallo | Si el periodo de cierre no se pudo registrar en alguna sede, revertir toda la operación e informar el error | Detener operación |
|  |  |  |  |  |  |  | P-PCI-0016 | Asegurar que no exista otro objeto de tipo PeriodoCierre con el mismo id; el id solo debe ser único entre los objetos de tipo PeriodoCierre | Generar un nuevo id para el PeriodoCierre y volver a validar que no lo tenga otro PeriodoCierre | Continuar operación |
| definirPeriodoCierreSede | Comando que permite al administrador registrar un periodo en el que solo una sede de la barbería permanece cerrada; las demás sedes siguen atendiendo; las citas agendadas que se crucen con el periodo de cierre se cancelan | datos{sede, fechaHoraInicio, fechaHoraFinal, motivo} | PeriodoCierre | Contiene la sede, la fecha y hora en que empieza y termina el cierre y su motivo | PeriodoCierre | Contiene la información del periodo de cierre registrado para la sede | P-PCI-0008 | Asegurar que los datos requeridos para definir el periodo de cierre en una sede (sede, fecha y hora de inicio, fecha y hora final, motivo) sean válidos en tipo de dato, longitud, obligatoriedad, formato y rango | Generar una excepción indicándole al administrador cuáles datos no cumplen con las reglas definidas | Detener operación |
|  |  |  |  |  |  |  | P-PCI-0002 | Asegurar que existan las sedes en las que se va a registrar el periodo de cierre | Generar una excepción indicándole al administrador que la sede no existe | Detener operación |
|  |  |  |  |  |  |  | P-PCI-0003 | Asegurar que la fecha y hora final del periodo de cierre sea mayor a su fecha y hora de inicio | Generar una excepción indicándole al administrador que la fecha y hora final debe ser mayor a la fecha y hora de inicio | Detener operación |
|  |  |  |  |  |  |  | P-PCI-0004 | Asegurar que la fecha y hora de inicio del periodo de cierre sea posterior al momento actual; no se puede registrar un cierre que empiece en un momento que ya pasó | Generar una excepción indicándole al administrador que el periodo de cierre no puede empezar en un momento que ya pasó | Detener operación |
|  |  |  |  |  |  |  | P-PCI-0009 | Asegurar que el periodo de cierre no se cruce con otro periodo de cierre de la misma sede; un periodo que termina en la fecha y hora en que empieza otro no se considera cruzado | Generar una excepción indicándole al administrador que la sede ya tiene un periodo de cierre que se cruza con el que se quiere registrar | Detener operación |
|  |  |  |  |  |  |  | P-PCI-0006 | Cuando se registre o se cambie un periodo de cierre, cancelar en el estado Cancelación todas las citas en estado Agendada de la sede que se crucen con él. Cada cita ocupa desde la fecha de su agenda con su horaInicio hasta esa misma fecha con su horaFinEstimada, y se cruza con el cierre cuando empieza antes de la fecha y hora final del cierre y termina después de su fecha y hora de inicio. No aplica el límite de 2 horas para cancelar, las citas que no están en estado Agendada no se modifican y las agendas ya creadas se conservan | Si alguna de las citas que se cruzan con el periodo de cierre no se puede cancelar, revertir toda la operación e informar el error | Detener operación |
|  |  |  |  |  |  |  | P-PCI-0016 | Asegurar que no exista otro objeto de tipo PeriodoCierre con el mismo id; el id solo debe ser único entre los objetos de tipo PeriodoCierre | Generar un nuevo id para el PeriodoCierre y volver a validar que no lo tenga otro PeriodoCierre | Continuar operación |
| cambiarPeriodoCierreTodasLasSedes | Permite al administrador cambiar el intervalo o el motivo de un periodo de cierre en todas las sedes de la barbería que lo tienen registrado; las citas agendadas que se crucen con el periodo de cierre se cancelan | filtro{barberia, fechaHoraInicio, fechaHoraFinal} | PeriodoCierre | Contiene la barbería y la fecha y hora de inicio y final del periodo de cierre que se va a cambiar en todas las sedes | Lista<PeriodoCierre> | Contiene los periodos de cierre de cada sede con el intervalo y el motivo actualizados | P-PCI-0010 | Asegurar que exista al menos un periodo de cierre con esa fecha y hora de inicio y esa fecha y hora final en las sedes de la barbería | Informar con un mensaje que ninguna sede de la barbería tiene un periodo de cierre con esa fecha y hora de inicio y esa fecha y hora final | Detener operación |
|  |  | datos{fechaHoraInicio, fechaHoraFinal, motivo} | PeriodoCierre | Contiene el nuevo intervalo y el motivo del periodo de cierre |  |  | P-PCI-0011 | Asegurar que los datos requeridos para cambiar el periodo de cierre (fecha y hora de inicio, fecha y hora final, motivo) sean válidos en tipo de dato, longitud, obligatoriedad, formato y rango | Generar una excepción indicándole al administrador cuáles datos no cumplen con las reglas definidas | Detener operación |
|  |  |  |  |  |  |  | P-PCI-0003 | Asegurar que la fecha y hora final del periodo de cierre sea mayor a su fecha y hora de inicio | Generar una excepción indicándole al administrador que la fecha y hora final debe ser mayor a la fecha y hora de inicio | Detener operación |
|  |  |  |  |  |  |  | P-PCI-0012 | Asegurar que el periodo de cierre que se va a cambiar no haya terminado (fecha y hora final posterior al momento actual); los periodos terminados se conservan como historial. Si todavía no ha empezado, la nueva fecha y hora de inicio debe ser posterior al momento actual; si ya empezó, su fecha y hora de inicio no se puede cambiar y la nueva fecha y hora final debe ser posterior al momento actual | Generar una excepción indicándole al administrador que el periodo de cierre ya terminó y se conserva como historial, o que su fecha y hora de inicio ya no se puede cambiar porque el periodo ya empezó | Detener operación |
|  |  |  |  |  |  |  | P-PCI-0013 | Asegurar que el nuevo intervalo del periodo de cierre no se cruce con otro periodo de cierre de la misma sede, sin contar el periodo que se está cambiando | Generar una excepción indicándole al administrador en cuáles sedes el nuevo intervalo se cruza con otro periodo de cierre | Detener operación |
|  |  |  |  |  |  |  | P-PCI-0006 | Cuando se registre o se cambie un periodo de cierre, cancelar en el estado Cancelación todas las citas en estado Agendada de la sede que se crucen con él. Cada cita ocupa desde la fecha de su agenda con su horaInicio hasta esa misma fecha con su horaFinEstimada, y se cruza con el cierre cuando empieza antes de la fecha y hora final del cierre y termina después de su fecha y hora de inicio. No aplica el límite de 2 horas para cancelar, las citas que no están en estado Agendada no se modifican y las agendas ya creadas se conservan | Si alguna de las citas que se cruzan con el periodo de cierre no se puede cancelar, revertir toda la operación e informar el error | Detener operación |
|  |  |  |  |  |  |  | P-PCI-0007 | Cuando el administrador registre, cambie o elimine un periodo de cierre en todas las sedes, la operación se realiza como una sola: si no se puede aplicar en alguna sede, no se aplica en ninguna. Las sedes omitidas porque el periodo se cruza con otro periodo de cierre que ya tenían no cuentan como fallo | Si en alguna sede no se pudo aplicar el cambio, revertir toda la operación e informar el error | Detener operación |
| cambiarPeriodoCierreSede | Permite al administrador cambiar el intervalo o el motivo de un periodo de cierre de una sede; las demás sedes no se ven afectadas; las citas agendadas que se crucen con el periodo de cierre se cancelan | id | UUID | Corresponde al identificador del periodo de cierre de la sede que se va a cambiar | PeriodoCierre | Contiene el periodo de cierre de la sede con el intervalo y el motivo actualizados | P-PCI-0015 | Asegurar que exista el periodo de cierre con el id enviado | Informar con un mensaje que no existe un periodo de cierre con el identificador enviado y por lo tanto no es posible llevar a cabo la operación | Detener operación |
|  |  | datos{fechaHoraInicio, fechaHoraFinal, motivo} | PeriodoCierre | Contiene el nuevo intervalo y el motivo del periodo de cierre |  |  | P-PCI-0011 | Asegurar que los datos requeridos para cambiar el periodo de cierre (fecha y hora de inicio, fecha y hora final, motivo) sean válidos en tipo de dato, longitud, obligatoriedad, formato y rango | Generar una excepción indicándole al administrador cuáles datos no cumplen con las reglas definidas | Detener operación |
|  |  |  |  |  |  |  | P-PCI-0003 | Asegurar que la fecha y hora final del periodo de cierre sea mayor a su fecha y hora de inicio | Generar una excepción indicándole al administrador que la fecha y hora final debe ser mayor a la fecha y hora de inicio | Detener operación |
|  |  |  |  |  |  |  | P-PCI-0012 | Asegurar que el periodo de cierre que se va a cambiar no haya terminado (fecha y hora final posterior al momento actual); los periodos terminados se conservan como historial. Si todavía no ha empezado, la nueva fecha y hora de inicio debe ser posterior al momento actual; si ya empezó, su fecha y hora de inicio no se puede cambiar y la nueva fecha y hora final debe ser posterior al momento actual | Generar una excepción indicándole al administrador que el periodo de cierre ya terminó y se conserva como historial, o que su fecha y hora de inicio ya no se puede cambiar porque el periodo ya empezó | Detener operación |
|  |  |  |  |  |  |  | P-PCI-0013 | Asegurar que el nuevo intervalo del periodo de cierre no se cruce con otro periodo de cierre de la misma sede, sin contar el periodo que se está cambiando | Generar una excepción indicándole al administrador que el nuevo intervalo se cruza con otro periodo de cierre de la sede | Detener operación |
|  |  |  |  |  |  |  | P-PCI-0006 | Cuando se registre o se cambie un periodo de cierre, cancelar en el estado Cancelación todas las citas en estado Agendada de la sede que se crucen con él. Cada cita ocupa desde la fecha de su agenda con su horaInicio hasta esa misma fecha con su horaFinEstimada, y se cruza con el cierre cuando empieza antes de la fecha y hora final del cierre y termina después de su fecha y hora de inicio. No aplica el límite de 2 horas para cancelar, las citas que no están en estado Agendada no se modifican y las agendas ya creadas se conservan | Si alguna de las citas que se cruzan con el periodo de cierre no se puede cancelar, revertir toda la operación e informar el error | Detener operación |
| consultarPeriodosCierreSede | Permite consultar los periodos en los que una sede permanece cerrada y el motivo de cada uno | filtro{sede} | Sede | Contiene la sede de la que se van a consultar los periodos de cierre | Lista<PeriodoCierre> | Contiene los periodos de cierre de la sede con su intervalo y su motivo |  |  |  |  |
| consultarPeriodosCierreTodasLasSedes | Permite al administrador consultar los periodos de cierre registrados en todas las sedes de la barbería | filtro{barberia} | Barberia | Contiene la barbería de la que se van a consultar los periodos de cierre | Lista<PeriodoCierre> | Contiene los periodos de cierre de cada sede de la barbería con su intervalo y su motivo |  |  |  |  |
| consultarPeriodosCierrePorSedeYRango | Permite al sistema consultar los periodos de cierre de una sede que se cruzan con un rango de fecha y hora, para saber si se puede abrir una agenda o agendar una cita en ese rango | filtro{sede, fechaHoraInicio, fechaHoraFinal} | PeriodoCierre | Contiene la sede y el rango de fecha y hora que se quiere revisar | Lista<PeriodoCierre> | Contiene los periodos de cierre de la sede que empiezan antes del final del rango y terminan después de su inicio; si la lista está vacía, la sede no está cerrada en ningún momento del rango |  |  |  |  |
| eliminarPeriodoCierreTodasLasSedes | Permite al administrador eliminar un periodo de cierre que todavía no ha empezado en todas las sedes de la barbería que lo tienen; esas sedes vuelven a atender en ese periodo según su horario | filtro{barberia, fechaHoraInicio, fechaHoraFinal} | PeriodoCierre | Contiene la barbería y la fecha y hora de inicio y final del periodo de cierre que se va a eliminar en todas las sedes | No retorna ningún valor. En caso de error genera una excepción. |  | P-PCI-0010 | Asegurar que exista al menos un periodo de cierre con esa fecha y hora de inicio y esa fecha y hora final en las sedes de la barbería | Informar con un mensaje que ninguna sede de la barbería tiene un periodo de cierre con esa fecha y hora de inicio y esa fecha y hora final | Detener operación |
|  |  |  |  |  |  |  | P-PCI-0014 | Asegurar que el periodo de cierre que se va a eliminar todavía no haya empezado (fecha y hora de inicio posterior al momento actual); un periodo que ya empezó o terminó se conserva como historial, y si ya empezó solo se puede acortar cambiando su fecha y hora final | Generar una excepción indicándole al administrador que el periodo de cierre ya empezó o terminó y no se puede eliminar; si ya empezó, puede acortarlo cambiando su fecha y hora final | Detener operación |
|  |  |  |  |  |  |  | P-PCI-0007 | Cuando el administrador registre, cambie o elimine un periodo de cierre en todas las sedes, la operación se realiza como una sola: si no se puede aplicar en alguna sede, no se aplica en ninguna. Las sedes omitidas porque el periodo se cruza con otro periodo de cierre que ya tenían no cuentan como fallo | Si en alguna sede no se pudo aplicar el cambio, revertir toda la operación e informar el error | Detener operación |
| eliminarPeriodoCierreSede | Permite al administrador eliminar un periodo de cierre de una sede que todavía no ha empezado; la sede vuelve a atender en ese periodo según su horario | id | UUID | Corresponde al identificador del periodo de cierre de la sede que se va a eliminar | No retorna ningún valor. En caso de error genera una excepción. |  | P-PCI-0015 | Asegurar que exista el periodo de cierre con el id enviado | Informar con un mensaje que no existe un periodo de cierre con el identificador enviado y por lo tanto no es posible llevar a cabo la operación | Detener operación |
|  |  |  |  |  |  |  | P-PCI-0014 | Asegurar que el periodo de cierre que se va a eliminar todavía no haya empezado (fecha y hora de inicio posterior al momento actual); un periodo que ya empezó o terminó se conserva como historial, y si ya empezó solo se puede acortar cambiando su fecha y hora final | Generar una excepción indicándole al administrador que el periodo de cierre ya empezó o terminó y no se puede eliminar; si ya empezó, puede acortarlo cambiando su fecha y hora final | Detener operación |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Administrador | Definir un periodo de cierre para todas las sedes | Comando que permite registrar con una sola operación un periodo en el que todas las sedes de la barbería permanecen cerradas, indicando cuándo empieza, cuándo termina y el motivo; las citas agendadas que se crucen con el cierre se cancelan | PeriodoCierre | Sede | Permite obtener las sedes de la barbería en las que se va a registrar el periodo de cierre. | P-PCI-0001 | Asegurar que los datos requeridos para definir el periodo de cierre en todas las sedes (barbería, fecha y hora de inicio, fecha y hora final, motivo) sean válidos en tipo de dato, longitud, obligatoriedad, formato y rango |  | Periodo de cierre definido para todas las sedes |  |
|  |  |  |  | Agenda | Permite conocer la fecha de cada cita, ya que la cita solo almacena horas. Es lo que hace comparable el periodo de cierre contra las citas existentes. | P-PCI-0002 | Asegurar que existan las sedes en las que se va a registrar el periodo de cierre |  |  |  |
|  |  |  |  | HorarioBarbero | Permite llegar desde cada agenda al horario de la sede al que pertenece. | P-PCI-0003 | Asegurar que la fecha y hora final del periodo de cierre sea mayor a su fecha y hora de inicio |  |  |  |
|  |  |  |  | HorarioSede | Permite saber a qué sede pertenece cada agenda. | P-PCI-0004 | Asegurar que la fecha y hora de inicio del periodo de cierre sea posterior al momento actual; no se puede registrar un cierre que empiece en un momento que ya pasó |  |  |  |
|  |  |  |  | Cita | Permite identificar las citas de la sede que se cruzan con el periodo de cierre para cancelarlas. | P-PCI-0005 | Registrar el periodo de cierre solo en las sedes de la barbería en las que no se cruce con otro periodo de cierre de esa sede; si en todas se cruza, informar que no se registró en ninguna sede |  |  |  |
|  |  |  |  | Estado | Permite tener en cuenta solo las citas que siguen en estado Agendada y dejarlas en Cancelación. | P-PCI-0006 | Cuando se registre o se cambie un periodo de cierre, cancelar en el estado Cancelación todas las citas en estado Agendada de la sede que se crucen con él. Cada cita ocupa desde la fecha de su agenda con su horaInicio hasta esa misma fecha con su horaFinEstimada, y se cruza con el cierre cuando empieza antes de la fecha y hora final del cierre y termina después de su fecha y hora de inicio. No aplica el límite de 2 horas para cancelar, las citas que no están en estado Agendada no se modifican y las agendas ya creadas se conservan |  |  |  |
|  |  |  |  |  |  | P-PCI-0007 | Cuando el administrador registre, cambie o elimine un periodo de cierre en todas las sedes, la operación se realiza como una sola: si no se puede aplicar en alguna sede, no se aplica en ninguna. Las sedes omitidas porque el periodo se cruza con otro periodo de cierre que ya tenían no cuentan como fallo |  |  |  |
| Administrador | Definir un periodo de cierre para una sede | Comando que permite registrar un periodo en el que solo una sede de la barbería permanece cerrada, indicando cuándo empieza, cuándo termina y el motivo; las demás sedes siguen atendiendo; las citas agendadas que se crucen con el cierre se cancelan | PeriodoCierre | Sede | Permite verificar que la sede exista. | P-PCI-0008 | Asegurar que los datos requeridos para definir el periodo de cierre en una sede (sede, fecha y hora de inicio, fecha y hora final, motivo) sean válidos en tipo de dato, longitud, obligatoriedad, formato y rango |  | Periodo de cierre de sede definido |  |
|  |  |  |  | Agenda | Permite conocer la fecha de cada cita, ya que la cita solo almacena horas. Es lo que hace comparable el periodo de cierre contra las citas existentes. | P-PCI-0002 | Asegurar que existan las sedes en las que se va a registrar el periodo de cierre |  |  |  |
|  |  |  |  | HorarioBarbero | Permite llegar desde cada agenda al horario de la sede al que pertenece. | P-PCI-0003 | Asegurar que la fecha y hora final del periodo de cierre sea mayor a su fecha y hora de inicio |  |  |  |
|  |  |  |  | HorarioSede | Permite saber a qué sede pertenece cada agenda. | P-PCI-0004 | Asegurar que la fecha y hora de inicio del periodo de cierre sea posterior al momento actual; no se puede registrar un cierre que empiece en un momento que ya pasó |  |  |  |
|  |  |  |  | Cita | Permite identificar las citas de la sede que se cruzan con el periodo de cierre para cancelarlas. | P-PCI-0009 | Asegurar que el periodo de cierre no se cruce con otro periodo de cierre de la misma sede; un periodo que termina en la fecha y hora en que empieza otro no se considera cruzado |  |  |  |
|  |  |  |  | Estado | Permite tener en cuenta solo las citas que siguen en estado Agendada y dejarlas en Cancelación. | P-PCI-0006 | Cuando se registre o se cambie un periodo de cierre, cancelar en el estado Cancelación todas las citas en estado Agendada de la sede que se crucen con él. Cada cita ocupa desde la fecha de su agenda con su horaInicio hasta esa misma fecha con su horaFinEstimada, y se cruza con el cierre cuando empieza antes de la fecha y hora final del cierre y termina después de su fecha y hora de inicio. No aplica el límite de 2 horas para cancelar, las citas que no están en estado Agendada no se modifican y las agendas ya creadas se conservan |  |  |  |
| Administrador | Cambiar un periodo de cierre de todas las sedes | Permite cambiar cuándo empieza, cuándo termina o el motivo de un periodo de cierre que tienen registrado las sedes de la barbería; las citas agendadas que se crucen con el cierre se cancelan | PeriodoCierre | Sede | Permite obtener las sedes de la barbería. | P-PCI-0010 | Asegurar que exista al menos un periodo de cierre con esa fecha y hora de inicio y esa fecha y hora final en las sedes de la barbería |  | Periodo de cierre cambiado en todas las sedes |  |
|  |  |  |  | Agenda | Permite conocer la fecha de cada cita, ya que la cita solo almacena horas. Es lo que hace comparable el periodo de cierre contra las citas existentes. | P-PCI-0011 | Asegurar que los datos requeridos para cambiar el periodo de cierre (fecha y hora de inicio, fecha y hora final, motivo) sean válidos en tipo de dato, longitud, obligatoriedad, formato y rango |  |  |  |
|  |  |  |  | HorarioBarbero | Permite llegar desde cada agenda al horario de la sede al que pertenece. | P-PCI-0003 | Asegurar que la fecha y hora final del periodo de cierre sea mayor a su fecha y hora de inicio |  |  |  |
|  |  |  |  | HorarioSede | Permite saber a qué sede pertenece cada agenda. | P-PCI-0012 | Asegurar que el periodo de cierre que se va a cambiar no haya terminado (fecha y hora final posterior al momento actual); los periodos terminados se conservan como historial. Si todavía no ha empezado, la nueva fecha y hora de inicio debe ser posterior al momento actual; si ya empezó, su fecha y hora de inicio no se puede cambiar y la nueva fecha y hora final debe ser posterior al momento actual |  |  |  |
|  |  |  |  | Cita | Permite identificar las citas de la sede que se cruzan con el periodo de cierre para cancelarlas. | P-PCI-0013 | Asegurar que el nuevo intervalo del periodo de cierre no se cruce con otro periodo de cierre de la misma sede, sin contar el periodo que se está cambiando |  |  |  |
|  |  |  |  | Estado | Permite tener en cuenta solo las citas que siguen en estado Agendada y dejarlas en Cancelación. | P-PCI-0006 | Cuando se registre o se cambie un periodo de cierre, cancelar en el estado Cancelación todas las citas en estado Agendada de la sede que se crucen con él. Cada cita ocupa desde la fecha de su agenda con su horaInicio hasta esa misma fecha con su horaFinEstimada, y se cruza con el cierre cuando empieza antes de la fecha y hora final del cierre y termina después de su fecha y hora de inicio. No aplica el límite de 2 horas para cancelar, las citas que no están en estado Agendada no se modifican y las agendas ya creadas se conservan |  |  |  |
|  |  |  |  |  |  | P-PCI-0007 | Cuando el administrador registre, cambie o elimine un periodo de cierre en todas las sedes, la operación se realiza como una sola: si no se puede aplicar en alguna sede, no se aplica en ninguna. Las sedes omitidas porque el periodo se cruza con otro periodo de cierre que ya tenían no cuentan como fallo |  |  |  |
| Administrador | Cambiar un periodo de cierre de una sede | Permite cambiar cuándo empieza, cuándo termina o el motivo de un periodo de cierre de una sede; las demás sedes no se ven afectadas; las citas agendadas que se crucen con el cierre se cancelan | PeriodoCierre | Agenda | Permite conocer la fecha de cada cita, ya que la cita solo almacena horas. Es lo que hace comparable el periodo de cierre contra las citas existentes. | P-PCI-0011 | Asegurar que los datos requeridos para cambiar el periodo de cierre (fecha y hora de inicio, fecha y hora final, motivo) sean válidos en tipo de dato, longitud, obligatoriedad, formato y rango |  | Periodo de cierre de sede cambiado |  |
|  |  |  |  | HorarioBarbero | Permite llegar desde cada agenda al horario de la sede al que pertenece. | P-PCI-0003 | Asegurar que la fecha y hora final del periodo de cierre sea mayor a su fecha y hora de inicio |  |  |  |
|  |  |  |  | HorarioSede | Permite saber a qué sede pertenece cada agenda. | P-PCI-0012 | Asegurar que el periodo de cierre que se va a cambiar no haya terminado (fecha y hora final posterior al momento actual); los periodos terminados se conservan como historial. Si todavía no ha empezado, la nueva fecha y hora de inicio debe ser posterior al momento actual; si ya empezó, su fecha y hora de inicio no se puede cambiar y la nueva fecha y hora final debe ser posterior al momento actual |  |  |  |
|  |  |  |  | Cita | Permite identificar las citas de la sede que se cruzan con el periodo de cierre para cancelarlas. | P-PCI-0013 | Asegurar que el nuevo intervalo del periodo de cierre no se cruce con otro periodo de cierre de la misma sede, sin contar el periodo que se está cambiando |  |  |  |
|  |  |  |  | Estado | Permite tener en cuenta solo las citas que siguen en estado Agendada y dejarlas en Cancelación. | P-PCI-0006 | Cuando se registre o se cambie un periodo de cierre, cancelar en el estado Cancelación todas las citas en estado Agendada de la sede que se crucen con él. Cada cita ocupa desde la fecha de su agenda con su horaInicio hasta esa misma fecha con su horaFinEstimada, y se cruza con el cierre cuando empieza antes de la fecha y hora final del cierre y termina después de su fecha y hora de inicio. No aplica el límite de 2 horas para cancelar, las citas que no están en estado Agendada no se modifican y las agendas ya creadas se conservan |  |  |  |
| Administrador | Ver periodos de cierre de una sede | Permite al administrador consultar los periodos en los que una sede permanece cerrada y el motivo de cada uno | PeriodoCierre |  |  |  |  |  | Periodos de cierre de sede consultados |  |
| Barbero | Ver periodos de cierre de una sede | Permite al barbero consultar los periodos en los que una sede permanece cerrada y el motivo de cada uno | PeriodoCierre |  |  |  |  |  | Periodos de cierre de sede consultados |  |
| Cliente | Ver periodos de cierre de una sede | Permite al cliente consultar los periodos en los que una sede permanece cerrada y el motivo de cada uno | PeriodoCierre |  |  |  |  |  | Periodos de cierre de sede consultados |  |
| Administrador | Ver periodos de cierre de todas las sedes | Permite al administrador consultar los periodos de cierre registrados en todas las sedes de la barbería | PeriodoCierre | Sede | Permite identificar a qué sede pertenece cada periodo de cierre. |  |  |  | Periodos de cierre de todas las sedes consultados |  |
| Sistema | Ver periodos de cierre de una sede en un rango de fecha y hora | Permite al sistema saber si una sede está cerrada en algún momento de un rango de fecha y hora, para que luego determine si se puede abrir una agenda o agendar una cita en ese rango | PeriodoCierre |  |  |  |  |  | Periodos de cierre de sede por rango consultados |  |
| Administrador | Eliminar un periodo de cierre de todas las sedes | Permite eliminar un periodo de cierre que todavía no ha empezado en todas las sedes de la barbería que lo tienen; esas sedes vuelven a atender en ese periodo según su horario | PeriodoCierre | Sede | Permite obtener las sedes de la barbería. | P-PCI-0010 | Asegurar que exista al menos un periodo de cierre con esa fecha y hora de inicio y esa fecha y hora final en las sedes de la barbería |  | Periodo de cierre eliminado de todas las sedes |  |
|  |  |  |  |  |  | P-PCI-0014 | Asegurar que el periodo de cierre que se va a eliminar todavía no haya empezado (fecha y hora de inicio posterior al momento actual); un periodo que ya empezó o terminó se conserva como historial, y si ya empezó solo se puede acortar cambiando su fecha y hora final |  |  |  |
|  |  |  |  |  |  | P-PCI-0007 | Cuando el administrador registre, cambie o elimine un periodo de cierre en todas las sedes, la operación se realiza como una sola: si no se puede aplicar en alguna sede, no se aplica en ninguna. Las sedes omitidas porque el periodo se cruza con otro periodo de cierre que ya tenían no cuentan como fallo |  |  |  |
| Administrador | Eliminar un periodo de cierre de una sede | Permite eliminar un periodo de cierre de una sede que todavía no ha empezado; la sede vuelve a atender en ese periodo según su horario | PeriodoCierre |  |  | P-PCI-0014 | Asegurar que el periodo de cierre que se va a eliminar todavía no haya empezado (fecha y hora de inicio posterior al momento actual); un periodo que ya empezó o terminó se conserva como historial, y si ya empezó solo se puede acortar cambiando su fecha y hora final |  | Periodo de cierre de sede eliminado |  |

### Políticas

| Número Política | Descripción Política | Objeto Responsable |
|---|---|---|
| P-PCI-0001 | Asegurar que los datos requeridos para definir el periodo de cierre en todas las sedes (barbería, fecha y hora de inicio, fecha y hora final, motivo) sean válidos en tipo de dato, longitud, obligatoriedad, formato y rango | [PeriodoCierre](#periodocierre) |
| P-PCI-0002 | Asegurar que existan las sedes en las que se va a registrar el periodo de cierre | [Sede](#sede) |
| P-PCI-0003 | Asegurar que la fecha y hora final del periodo de cierre sea mayor a su fecha y hora de inicio | [PeriodoCierre](#periodocierre) |
| P-PCI-0004 | Asegurar que la fecha y hora de inicio del periodo de cierre sea posterior al momento actual; no se puede registrar un cierre que empiece en un momento que ya pasó | [PeriodoCierre](#periodocierre) |
| P-PCI-0005 | Registrar el periodo de cierre solo en las sedes de la barbería en las que no se cruce con otro periodo de cierre de esa sede; si en todas se cruza, informar que no se registró en ninguna sede | [PeriodoCierre](#periodocierre) |
| P-PCI-0006 | Cuando se registre o se cambie un periodo de cierre, cancelar en el estado Cancelación todas las citas en estado Agendada de la sede que se crucen con él. Cada cita ocupa desde la fecha de su agenda con su horaInicio hasta esa misma fecha con su horaFinEstimada, y se cruza con el cierre cuando empieza antes de la fecha y hora final del cierre y termina después de su fecha y hora de inicio. No aplica el límite de 2 horas para cancelar, las citas que no están en estado Agendada no se modifican y las agendas ya creadas se conservan | [Cita](#cita) |
| P-PCI-0007 | Cuando el administrador registre, cambie o elimine un periodo de cierre en todas las sedes, la operación se realiza como una sola: si no se puede aplicar en alguna sede, no se aplica en ninguna. Las sedes omitidas porque el periodo se cruza con otro periodo de cierre que ya tenían no cuentan como fallo | [PeriodoCierre](#periodocierre) |
| P-PCI-0008 | Asegurar que los datos requeridos para definir el periodo de cierre en una sede (sede, fecha y hora de inicio, fecha y hora final, motivo) sean válidos en tipo de dato, longitud, obligatoriedad, formato y rango | [PeriodoCierre](#periodocierre) |
| P-PCI-0009 | Asegurar que el periodo de cierre no se cruce con otro periodo de cierre de la misma sede; un periodo que termina en la fecha y hora en que empieza otro no se considera cruzado | [PeriodoCierre](#periodocierre) |
| P-PCI-0010 | Asegurar que exista al menos un periodo de cierre con esa fecha y hora de inicio y esa fecha y hora final en las sedes de la barbería | [PeriodoCierre](#periodocierre) |
| P-PCI-0011 | Asegurar que los datos requeridos para cambiar el periodo de cierre (fecha y hora de inicio, fecha y hora final, motivo) sean válidos en tipo de dato, longitud, obligatoriedad, formato y rango | [PeriodoCierre](#periodocierre) |
| P-PCI-0012 | Asegurar que el periodo de cierre que se va a cambiar no haya terminado (fecha y hora final posterior al momento actual); los periodos terminados se conservan como historial. Si todavía no ha empezado, la nueva fecha y hora de inicio debe ser posterior al momento actual; si ya empezó, su fecha y hora de inicio no se puede cambiar y la nueva fecha y hora final debe ser posterior al momento actual | [PeriodoCierre](#periodocierre) |
| P-PCI-0013 | Asegurar que el nuevo intervalo del periodo de cierre no se cruce con otro periodo de cierre de la misma sede, sin contar el periodo que se está cambiando | [PeriodoCierre](#periodocierre) |
| P-PCI-0014 | Asegurar que el periodo de cierre que se va a eliminar todavía no haya empezado (fecha y hora de inicio posterior al momento actual); un periodo que ya empezó o terminó se conserva como historial, y si ya empezó solo se puede acortar cambiando su fecha y hora final | [PeriodoCierre](#periodocierre) |
| P-PCI-0015 | Asegurar que exista el periodo de cierre con el id enviado | [PeriodoCierre](#periodocierre) |
| P-PCI-0016 | Asegurar que no exista otro objeto de tipo PeriodoCierre con el mismo id; el id solo debe ser único entre los objetos de tipo PeriodoCierre | [PeriodoCierre](#periodocierre) |

[↑ Volver al índice](#objetos-de-dominio)

---

## SedeFestivo

**Descripción:** Representa la decisión de una sede de abrir en un festivo puntual. Por defecto ninguna sede abre en los festivos; si la sede tiene registrado el festivo, ese día atiende con su horario habitual del día de la semana en que cae. El administrador puede definirla para todas las sedes a la vez o para una sede en particular.  
**Línea de vida:** 4

### Muestreo de datos

- **id**: Representa un identificador que hará unico cada objeto de dominio de este tipo, no se puede repetir
- **sede**: Representa la sede de la barbería que abre en el festivo. A través de la sede se conoce la barbería, por eso no se guarda la barbería
- **festivo**: Representa el festivo en el que la sede abre; ese día la sede atiende con su horario habitual del día de la semana en que cae el festivo
- **Combinación única 1**: Combinación única que indica que una misma sede no puede tener registrada dos veces la apertura del mismo festivo

| id | sede | festivo | Combinación única 1 |
|---|---|---|---|
| 1 | BarberClub Colombia-Sede Poblado | 12/10/2026 | BarberClub Colombia-Sede Poblado-12/10/2026 |
| 2 | BarberClub Colombia-Sede Laureles | 12/10/2026 | BarberClub Colombia-Sede Laureles-12/10/2026 |
| 3 | BarberClub Colombia-Sede Rionegro | 12/10/2026 | BarberClub Colombia-Sede Rionegro-12/10/2026 |
| 4 | BarberClub Colombia-Sede Laureles | 13/07/2026 | BarberClub Colombia-Sede Laureles-13/07/2026 |
| 5 | Corte y Estilo Barberías-Sede Centro | 02/11/2026 | Corte y Estilo Barberías-Sede Centro-02/11/2026 |
| 6 | BarberClub Colombia-Sede Poblado | 16/11/2026 | BarberClub Colombia-Sede Poblado-16/11/2026 |
| 7 | BarberClub Colombia-Sede Laureles | 16/11/2026 | BarberClub Colombia-Sede Laureles-16/11/2026 |
| 8 | BarberClub Colombia-Sede Poblado | 08/12/2026 | BarberClub Colombia-Sede Poblado-08/12/2026 |

**Combinaciones únicas y datos tomados de otros objetos:**

- **sede**: referencia a [Sede](#sede); en los datos de ejemplo se muestra con su combinación única.
- **festivo**: referencia a [Festivo](#festivo); en los datos de ejemplo se muestra con su combinación única.
- **Combinación única 1**: formada por `sede` + `festivo`.

**Clasificación de las columnas del muestreo:**

- Corresponde al identificador unico del objeto de dominio: id
- Corresponde a las referencias de otros objetos de dominio: sede, festivo
- Corresponde a la combinacion única: Combinación única 1

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Rendondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | definirSedeFestivoTodasLasSedes | definirSedeFestivoSede | consultarFechasFestivoSede | consultarFechasFestivoTodasLasSedes | consultarSedeFestivoPorSedeYFecha | eliminarSedeFestivoTodasLasSedes | eliminarSedeFestivoSede |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| id | Representa un identificador que hará unico cada objeto de dominio de este tipo, no se puede repetir | Si | Identificador único universal | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No | No aplica | No aplica | No aplica | No aplica | No | UUID vacio | Si | No requerido | No requerido | No mostrar | No mostrar | No mostrar | No requerido | Requerido |
| sede | Representa la sede de la barbería que abre en el festivo. A través de la sede se conoce la barbería, por eso no se guarda la barbería | No | [Sede](#sede) | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | Aplican las reglas del objeto referenciado | No | No aplica | No aplica | No aplica | No aplica | No | UUID vacio | No | No requerido | Requerido | No mostrar | Mostrar | No mostrar | No requerido | No requerido |
| festivo | Representa el festivo en el que la sede abre; ese día la sede atiende con su horario habitual del día de la semana en que cae el festivo | No | [Festivo](#festivo) | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | Aplican las reglas del objeto referenciado. Al registrar la apertura el festivo no debe haber pasado, y la sede debe tener al menos un horario vigente el día de la semana en que cae el festivo | No | No aplica | No aplica | No aplica | No aplica | No | UUID vacio | No | Requerido | Requerido | Mostrar | Mostrar | Mostrar | Requerido | No requerido |

| Nombre combinación única | Descripción | Atributos involucrados |
|---|---|---|
| Combinación única 1 | Combinación única que indica que una misma sede no puede tener registrada dos veces la apertura del mismo festivo | sede, festivo |

| Responsabilidad | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Salida / Descripción | Políticas (Reglas de Negocio) / Política | Políticas (Reglas de Negocio) / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |
|---|---|---|---|---|---|---|---|---|---|---|
| definirSedeFestivoTodasLasSedes | Comando que permite al administrador registrar con una sola operación que todas las sedes de la barbería abren en un festivo; se crea una apertura por cada sede. Ese día cada sede atiende con su horario habitual del día de la semana en que cae el festivo | datos{barberia, festivo} | SedeFestivo | Contiene la barbería y el festivo en el que van a abrir sus sedes | Lista<SedeFestivo> | Contiene las aperturas registradas, una por cada sede de la barbería que abre en el festivo | P-FFE-0001 | Asegurar que los datos requeridos para definir la apertura de un festivo en todas las sedes (barbería, festivo) sean válidos en tipo de dato, obligatoriedad, formato y rango | Generar una excepción indicándole al administrador cuáles datos no cumplen con las reglas definidas | Detener operación |
|  |  |  |  |  |  |  | P-FFE-0002 | Asegurar que existan las sedes en las que se va a registrar la apertura del festivo | Generar una excepción indicándole al administrador que la barbería no tiene sedes registradas | Detener operación |
|  |  |  |  |  |  |  | P-FFE-0003 | Asegurar que exista el festivo en el que se quiere abrir | Generar una excepción indicándole al administrador que la fecha elegida no es un festivo registrado | Detener operación |
|  |  |  |  |  |  |  | P-FFE-0004 | Asegurar que el festivo no haya pasado: su fecha debe ser igual o posterior al día actual | Generar una excepción indicándole al administrador que no se puede abrir en un festivo que ya pasó | Detener operación |
|  |  |  |  |  |  |  | P-FFE-0005 | Registrar la apertura solo en las sedes de la barbería que todavía no la tienen registrada para ese festivo y que tienen al menos un horario vigente el día de la semana en que cae el festivo; si ninguna sede cumple, informar que no se registró en ninguna sede | Informar al administrador en cuáles sedes no se registró la apertura y por qué: ya abrían ese festivo o no tienen horario ese día de la semana | Continuar operación |
|  |  |  |  |  |  |  | P-FFE-0006 | Si la sede tiene un periodo de cierre que cubre total o parcialmente la fecha del festivo, registrar la apertura de todas formas: mientras dure el cierre la sede no atiende, porque el periodo de cierre prevalece sobre la apertura | Informar al administrador en cuáles sedes hay un periodo de cierre que cubre el festivo y que durante ese cierre la sede no atiende | Continuar operación |
|  |  |  |  |  |  |  | P-FFE-0007 | Cuando el administrador registre o elimine la apertura de un festivo en todas las sedes, la operación se realiza como una sola: si no se puede aplicar en alguna sede, no se aplica en ninguna. Las sedes omitidas porque ya abrían ese festivo o no tienen horario ese día de la semana no cuentan como fallo | Si la apertura no se pudo registrar en alguna sede, revertir toda la operación e informar el error | Detener operación |
|  |  |  |  |  |  |  | P-FFE-0015 | Asegurar que no exista otro objeto de tipo SedeFestivo con el mismo id; el id solo debe ser único entre los objetos de tipo SedeFestivo | Generar un nuevo id para la SedeFestivo y volver a validar que no lo tenga otra SedeFestivo | Continuar operación |
| definirSedeFestivoSede | Comando que permite al administrador registrar que una sola sede de la barbería abre en un festivo; las demás sedes siguen sin abrir ese día. La sede atiende con su horario habitual del día de la semana en que cae el festivo | datos{sede, festivo} | SedeFestivo | Contiene la sede y el festivo en el que va a abrir | SedeFestivo | Contiene la apertura de festivo registrada para la sede | P-FFE-0008 | Asegurar que los datos requeridos para definir la apertura de un festivo en una sede (sede, festivo) sean válidos en tipo de dato, obligatoriedad, formato y rango | Generar una excepción indicándole al administrador cuáles datos no cumplen con las reglas definidas | Detener operación |
|  |  |  |  |  |  |  | P-FFE-0002 | Asegurar que existan las sedes en las que se va a registrar la apertura del festivo | Generar una excepción indicándole al administrador que la sede no existe | Detener operación |
|  |  |  |  |  |  |  | P-FFE-0003 | Asegurar que exista el festivo en el que se quiere abrir | Generar una excepción indicándole al administrador que la fecha elegida no es un festivo registrado | Detener operación |
|  |  |  |  |  |  |  | P-FFE-0004 | Asegurar que el festivo no haya pasado: su fecha debe ser igual o posterior al día actual | Generar una excepción indicándole al administrador que no se puede abrir en un festivo que ya pasó | Detener operación |
|  |  |  |  |  |  |  | P-FFE-0009 | Asegurar que la sede tenga al menos un horario vigente el día de la semana en que cae el festivo, ya que ese día atiende con su horario habitual | Generar una excepción indicándole al administrador que la sede no tiene horario el día de la semana en que cae el festivo | Detener operación |
|  |  |  |  |  |  |  | P-FFE-0010 | Asegurar que la sede no tenga registrada ya la apertura de ese festivo | Informar con un mensaje que la sede ya tiene registrada la apertura de ese festivo | Detener operación |
|  |  |  |  |  |  |  | P-FFE-0006 | Si la sede tiene un periodo de cierre que cubre total o parcialmente la fecha del festivo, registrar la apertura de todas formas: mientras dure el cierre la sede no atiende, porque el periodo de cierre prevalece sobre la apertura | Informar al administrador que la sede tiene un periodo de cierre que cubre el festivo y que durante ese cierre no atiende | Continuar operación |
|  |  |  |  |  |  |  | P-FFE-0015 | Asegurar que no exista otro objeto de tipo SedeFestivo con el mismo id; el id solo debe ser único entre los objetos de tipo SedeFestivo | Generar un nuevo id para la SedeFestivo y volver a validar que no lo tenga otra SedeFestivo | Continuar operación |
| consultarFechasFestivoSede | Permite consultar los festivos en los que una sede abre | filtro{sede} | Sede | Contiene la sede de la que se van a consultar los festivos en los que abre | Lista<SedeFestivo> | Contiene los festivos en los que abre la sede; los festivos que no aparecen son días en los que la sede no atiende |  |  |  |  |
| consultarFechasFestivoTodasLasSedes | Permite al administrador consultar en qué festivos abre cada una de las sedes de la barbería | filtro{barberia} | Barberia | Contiene la barbería de la que se van a consultar las aperturas de festivo | Lista<SedeFestivo> | Contiene las aperturas de festivo de cada sede de la barbería |  |  |  |  |
| consultarSedeFestivoPorSedeYFecha | Permite al sistema saber si una sede abre en una fecha festiva, para que luego determine si se puede abrir una agenda o agendar una cita ese día | filtro{sede, fecha} | SedeFestivo | Contiene la sede y la fecha que se quiere revisar | SedeFestivo | Contiene la apertura de la sede en el festivo de esa fecha; si no hay ninguna, la sede no abre ese festivo |  |  |  |  |
| eliminarSedeFestivoTodasLasSedes | Permite al administrador eliminar la apertura de un festivo que todavía no ha llegado en todas las sedes de la barbería que la tienen; esas sedes vuelven a no atender ese día y sus citas agendadas para esa fecha se cancelan | filtro{barberia, festivo} | SedeFestivo | Contiene la barbería y el festivo cuya apertura se va a eliminar en todas las sedes | No retorna ningún valor. En caso de error genera una excepción. |  | P-FFE-0011 | Asegurar que exista al menos una sede de la barbería con la apertura de ese festivo registrada | Informar con un mensaje que ninguna sede de la barbería tiene registrada la apertura de ese festivo | Detener operación |
|  |  |  |  |  |  |  | P-FFE-0012 | Asegurar que el festivo de la apertura que se va a eliminar todavía no haya llegado (fecha posterior al día actual); las aperturas de hoy y las pasadas se conservan como historial | Generar una excepción indicándole al administrador que el festivo ya llegó o pasó y su apertura se conserva como historial | Detener operación |
|  |  |  |  |  |  |  | P-FFE-0013 | Cuando se elimine la apertura de un festivo, cancelar en el estado Cancelación todas las citas en estado Agendada de esa fecha en las sedes afectadas, ya que ese día esas sedes vuelven a no atender. Las citas de otras fechas y de otras sedes no se modifican | Si alguna de las citas no pudo ser cancelada, revertir toda la operación e informar el error | Detener operación |
|  |  |  |  |  |  |  | P-FFE-0007 | Cuando el administrador registre o elimine la apertura de un festivo en todas las sedes, la operación se realiza como una sola: si no se puede aplicar en alguna sede, no se aplica en ninguna. Las sedes omitidas porque ya abrían ese festivo o no tienen horario ese día de la semana no cuentan como fallo | Si la apertura no se pudo eliminar en alguna sede, revertir toda la operación e informar el error | Detener operación |
| eliminarSedeFestivoSede | Permite al administrador eliminar la apertura de un festivo de una sede que todavía no ha llegado; la sede vuelve a no atender ese día y sus citas agendadas para esa fecha se cancelan | id | UUID | Corresponde al identificador de la apertura de festivo de la sede que se va a eliminar | No retorna ningún valor. En caso de error genera una excepción. |  | P-FFE-0014 | Asegurar que exista la apertura de festivo con el id enviado | Informar con un mensaje que no existe una apertura de festivo con el identificador enviado y por lo tanto no es posible llevar a cabo la operación | Detener operación |
|  |  |  |  |  |  |  | P-FFE-0012 | Asegurar que el festivo de la apertura que se va a eliminar todavía no haya llegado (fecha posterior al día actual); las aperturas de hoy y las pasadas se conservan como historial | Generar una excepción indicándole al administrador que el festivo ya llegó o pasó y su apertura se conserva como historial | Detener operación |
|  |  |  |  |  |  |  | P-FFE-0013 | Cuando se elimine la apertura de un festivo, cancelar en el estado Cancelación todas las citas en estado Agendada de esa fecha en las sedes afectadas, ya que ese día esas sedes vuelven a no atender. Las citas de otras fechas y de otras sedes no se modifican | Si alguna de las citas no pudo ser cancelada, revertir toda la operación e informar el error | Detener operación |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Administrador | Definir la apertura de un festivo para todas las sedes | Comando que permite registrar con una sola operación que todas las sedes de la barbería abren en un festivo; ese día cada sede atiende con su horario habitual del día de la semana en que cae | SedeFestivo | Sede | Permite obtener las sedes de la barbería en las que se va a registrar la apertura. | P-FFE-0001 | Asegurar que los datos requeridos para definir la apertura de un festivo en todas las sedes (barbería, festivo) sean válidos en tipo de dato, obligatoriedad, formato y rango |  | Apertura de festivo definida para todas las sedes |  |
|  |  |  |  | Festivo | Permite verificar que la fecha elegida sea un festivo y que todavía no haya pasado. | P-FFE-0002 | Asegurar que existan las sedes en las que se va a registrar la apertura del festivo |  |  |  |
|  |  |  |  | DiaSemana | Permite conocer el día de la semana en que cae el festivo. | P-FFE-0003 | Asegurar que exista el festivo en el que se quiere abrir |  |  |  |
|  |  |  |  | HorarioSede | Permite saber si cada sede tiene horario el día de la semana en que cae el festivo. | P-FFE-0004 | Asegurar que el festivo no haya pasado: su fecha debe ser igual o posterior al día actual |  |  |  |
|  |  |  |  | PeriodoCierre | Permite saber si alguna sede tiene un periodo de cierre que cubre el festivo. | P-FFE-0005 | Registrar la apertura solo en las sedes de la barbería que todavía no la tienen registrada para ese festivo y que tienen al menos un horario vigente el día de la semana en que cae el festivo; si ninguna sede cumple, informar que no se registró en ninguna sede |  |  |  |
|  |  |  |  |  |  | P-FFE-0006 | Si la sede tiene un periodo de cierre que cubre total o parcialmente la fecha del festivo, registrar la apertura de todas formas: mientras dure el cierre la sede no atiende, porque el periodo de cierre prevalece sobre la apertura |  |  |  |
|  |  |  |  |  |  | P-FFE-0007 | Cuando el administrador registre o elimine la apertura de un festivo en todas las sedes, la operación se realiza como una sola: si no se puede aplicar en alguna sede, no se aplica en ninguna. Las sedes omitidas porque ya abrían ese festivo o no tienen horario ese día de la semana no cuentan como fallo |  |  |  |
| Administrador | Definir la apertura de un festivo para una sede | Comando que permite registrar que solo una sede de la barbería abre en un festivo; ese día atiende con su horario habitual del día de la semana en que cae y las demás sedes siguen sin abrir | SedeFestivo | Sede | Permite verificar que la sede exista. | P-FFE-0008 | Asegurar que los datos requeridos para definir la apertura de un festivo en una sede (sede, festivo) sean válidos en tipo de dato, obligatoriedad, formato y rango |  | Apertura de festivo de sede definida |  |
|  |  |  |  | Festivo | Permite verificar que la fecha elegida sea un festivo y que todavía no haya pasado. | P-FFE-0002 | Asegurar que existan las sedes en las que se va a registrar la apertura del festivo |  |  |  |
|  |  |  |  | DiaSemana | Permite conocer el día de la semana en que cae el festivo. | P-FFE-0003 | Asegurar que exista el festivo en el que se quiere abrir |  |  |  |
|  |  |  |  | HorarioSede | Permite verificar que la sede tenga horario el día de la semana en que cae el festivo. | P-FFE-0004 | Asegurar que el festivo no haya pasado: su fecha debe ser igual o posterior al día actual |  |  |  |
|  |  |  |  | PeriodoCierre | Permite saber si la sede tiene un periodo de cierre que cubre el festivo. | P-FFE-0009 | Asegurar que la sede tenga al menos un horario vigente el día de la semana en que cae el festivo, ya que ese día atiende con su horario habitual |  |  |  |
|  |  |  |  |  |  | P-FFE-0010 | Asegurar que la sede no tenga registrada ya la apertura de ese festivo |  |  |  |
|  |  |  |  |  |  | P-FFE-0006 | Si la sede tiene un periodo de cierre que cubre total o parcialmente la fecha del festivo, registrar la apertura de todas formas: mientras dure el cierre la sede no atiende, porque el periodo de cierre prevalece sobre la apertura |  |  |  |
| Administrador | Ver los festivos en los que abre una sede | Permite al administrador consultar los festivos en los que una sede abre | SedeFestivo | Festivo | Permite conocer la fecha y el nombre de cada festivo en el que abre la sede. |  |  |  | Festivos en los que abre la sede consultados |  |
| Barbero | Ver los festivos en los que abre una sede | Permite al barbero consultar los festivos en los que abre su sede y saber qué festivos debe trabajar | SedeFestivo | Festivo | Permite conocer la fecha y el nombre de cada festivo en el que abre la sede. |  |  |  | Festivos en los que abre la sede consultados |  |
| Cliente | Ver los festivos en los que abre una sede | Permite al cliente consultar los festivos en los que una sede abre y en los que puede agendar citas | SedeFestivo | Festivo | Permite conocer la fecha y el nombre de cada festivo en el que abre la sede. |  |  |  | Festivos en los que abre la sede consultados |  |
| Administrador | Ver los festivos en los que abren todas las sedes | Permite al administrador consultar en qué festivos abre cada una de las sedes de la barbería | SedeFestivo | Sede | Permite identificar a qué sede pertenece cada apertura. |  |  |  | Festivos en los que abren todas las sedes consultados |  |
|  |  |  |  | Festivo | Permite conocer la fecha y el nombre de cada festivo. |  |  |  |  |  |
| Sistema | Saber si una sede abre en una fecha festiva | Permite al sistema saber si una sede abre en el festivo de una fecha, para que luego determine si se puede abrir una agenda o agendar una cita ese día | SedeFestivo | Festivo | Permite encontrar el festivo de esa fecha. |  |  |  | Apertura de festivo de sede por fecha consultada |  |
| Administrador | Eliminar la apertura de un festivo de todas las sedes | Permite eliminar la apertura de un festivo que todavía no ha llegado en todas las sedes de la barbería que la tienen; esas sedes vuelven a no atender ese día y sus citas agendadas para esa fecha se cancelan | SedeFestivo | Sede | Permite obtener las sedes de la barbería. | P-FFE-0011 | Asegurar que exista al menos una sede de la barbería con la apertura de ese festivo registrada |  | Apertura de festivo eliminada en todas las sedes |  |
|  |  |  |  | Festivo | Permite verificar que el festivo todavía no haya llegado. | P-FFE-0012 | Asegurar que el festivo de la apertura que se va a eliminar todavía no haya llegado (fecha posterior al día actual); las aperturas de hoy y las pasadas se conservan como historial |  |  |  |
|  |  |  |  | Agenda | Permite conocer la fecha de cada cita, ya que la cita solo almacena horas. | P-FFE-0013 | Cuando se elimine la apertura de un festivo, cancelar en el estado Cancelación todas las citas en estado Agendada de esa fecha en las sedes afectadas, ya que ese día esas sedes vuelven a no atender. Las citas de otras fechas y de otras sedes no se modifican |  |  |  |
|  |  |  |  | HorarioBarbero | Permite llegar desde cada agenda al horario de la sede al que pertenece. | P-FFE-0007 | Cuando el administrador registre o elimine la apertura de un festivo en todas las sedes, la operación se realiza como una sola: si no se puede aplicar en alguna sede, no se aplica en ninguna. Las sedes omitidas porque ya abrían ese festivo o no tienen horario ese día de la semana no cuentan como fallo |  |  |  |
|  |  |  |  | HorarioSede | Permite saber a qué sede pertenece cada agenda. |  |  |  |  |  |
|  |  |  |  | Cita | Permite encontrar las citas agendadas para la fecha del festivo y cancelarlas. |  |  |  |  |  |
|  |  |  |  | Estado | Permite tener en cuenta solo las citas en estado Agendada y asignarles el estado Cancelación. |  |  |  |  |  |
| Administrador | Eliminar la apertura de un festivo de una sede | Permite eliminar la apertura de un festivo de una sede que todavía no ha llegado; la sede vuelve a no atender ese día y sus citas agendadas para esa fecha se cancelan | SedeFestivo | Festivo | Permite verificar que el festivo todavía no haya llegado. | P-FFE-0014 | Asegurar que exista la apertura de festivo con el id enviado |  | Apertura de festivo de sede eliminada |  |
|  |  |  |  | Agenda | Permite conocer la fecha de cada cita, ya que la cita solo almacena horas. | P-FFE-0012 | Asegurar que el festivo de la apertura que se va a eliminar todavía no haya llegado (fecha posterior al día actual); las aperturas de hoy y las pasadas se conservan como historial |  |  |  |
|  |  |  |  | HorarioBarbero | Permite llegar desde cada agenda al horario de la sede al que pertenece. | P-FFE-0013 | Cuando se elimine la apertura de un festivo, cancelar en el estado Cancelación todas las citas en estado Agendada de esa fecha en las sedes afectadas, ya que ese día esas sedes vuelven a no atender. Las citas de otras fechas y de otras sedes no se modifican |  |  |  |
|  |  |  |  | HorarioSede | Permite saber a qué sede pertenece cada agenda. |  |  |  |  |  |
|  |  |  |  | Cita | Permite encontrar las citas agendadas para la fecha del festivo y cancelarlas. |  |  |  |  |  |
|  |  |  |  | Estado | Permite tener en cuenta solo las citas en estado Agendada y asignarles el estado Cancelación. |  |  |  |  |  |

### Políticas

| Número Política | Descripción Política | Objeto Responsable |
|---|---|---|
| P-FFE-0001 | Asegurar que los datos requeridos para definir la apertura de un festivo en todas las sedes (barbería, festivo) sean válidos en tipo de dato, obligatoriedad, formato y rango | [SedeFestivo](#sedefestivo) |
| P-FFE-0002 | Asegurar que existan las sedes en las que se va a registrar la apertura del festivo | [Sede](#sede) |
| P-FFE-0003 | Asegurar que exista el festivo en el que se quiere abrir | [Festivo](#festivo) |
| P-FFE-0004 | Asegurar que el festivo no haya pasado: su fecha debe ser igual o posterior al día actual | [Festivo](#festivo) |
| P-FFE-0005 | Registrar la apertura solo en las sedes de la barbería que todavía no la tienen registrada para ese festivo y que tienen al menos un horario vigente el día de la semana en que cae el festivo; si ninguna sede cumple, informar que no se registró en ninguna sede | [SedeFestivo](#sedefestivo) |
| P-FFE-0006 | Si la sede tiene un periodo de cierre que cubre total o parcialmente la fecha del festivo, registrar la apertura de todas formas: mientras dure el cierre la sede no atiende, porque el periodo de cierre prevalece sobre la apertura | [PeriodoCierre](#periodocierre) |
| P-FFE-0007 | Cuando el administrador registre o elimine la apertura de un festivo en todas las sedes, la operación se realiza como una sola: si no se puede aplicar en alguna sede, no se aplica en ninguna. Las sedes omitidas porque ya abrían ese festivo o no tienen horario ese día de la semana no cuentan como fallo | [SedeFestivo](#sedefestivo) |
| P-FFE-0008 | Asegurar que los datos requeridos para definir la apertura de un festivo en una sede (sede, festivo) sean válidos en tipo de dato, obligatoriedad, formato y rango | [SedeFestivo](#sedefestivo) |
| P-FFE-0009 | Asegurar que la sede tenga al menos un horario vigente el día de la semana en que cae el festivo, ya que ese día atiende con su horario habitual | [HorarioSede](#horariosede) |
| P-FFE-0010 | Asegurar que la sede no tenga registrada ya la apertura de ese festivo | [SedeFestivo](#sedefestivo) |
| P-FFE-0011 | Asegurar que exista al menos una sede de la barbería con la apertura de ese festivo registrada | [SedeFestivo](#sedefestivo) |
| P-FFE-0012 | Asegurar que el festivo de la apertura que se va a eliminar todavía no haya llegado (fecha posterior al día actual); las aperturas de hoy y las pasadas se conservan como historial | [Festivo](#festivo) |
| P-FFE-0013 | Cuando se elimine la apertura de un festivo, cancelar en el estado Cancelación todas las citas en estado Agendada de esa fecha en las sedes afectadas, ya que ese día esas sedes vuelven a no atender. Las citas de otras fechas y de otras sedes no se modifican | [Cita](#cita) |
| P-FFE-0014 | Asegurar que exista la apertura de festivo con el id enviado | [SedeFestivo](#sedefestivo) |
| P-FFE-0015 | Asegurar que no exista otro objeto de tipo SedeFestivo con el mismo id; el id solo debe ser único entre los objetos de tipo SedeFestivo | [SedeFestivo](#sedefestivo) |

[↑ Volver al índice](#objetos-de-dominio)

---

## BarberoServicio

**Descripción:** Representa qué servicios sabe hacer cada barbero, cuánto se demora en realizarlos y cuánto tiempo extra usa de colchón, ya que no todos los barberos ofrecen los mismos servicios que están en la barbería.  
**Línea de vida:** 5

### Muestreo de datos

- **id**: Representa un identificador que hará unico cada objeto de dominio de este tipo, no se puede repetir
- **barbero**: Representa el nombre y apellidos del barbero (referencia a [Barbero](#barbero))
- **servicio**: Representa el nombre del servicio de la barberia  (referencia a [Servicio](#servicio))
- **duracionEnHoras**: Representa la cantidad de horas que un barbero tarda en realizar un servicio, esta duracion el barbero debe de ser consiente de cuanto se demora en realizarlo
- **duracionEnMinutos**: Representa la cantidad de minutos que un barbero tarda en realizar un servicio, esta duracion el barbero debe de ser consiente de cuanto se demora en realizarlo
- **tiempoExtra**: Representa la cantidad de minutos que un barbero pone de tiempo extra en las citas de su agenda, cada barbero usa este tiempo porque hay ocaciones que la cita se puede demorar más de lo previsto. Este tiempo les ayuda a evitar que se les retrase la agenda
- **vigente**: Representa si el barbero sigue o no presentando el servicio en la barbería
- **Combinación única**: Combinación única que indica que un mismo barbero no puede aparecer dos veces ofreciendo el mismo servicio

| id | barbero | servicio | duracionEnHoras | duracionEnMinutos | tiempoExtra | vigente | Combinación única |
|---|---|---|---|---|---|---|---|
| 1 | Juan García | Motilada | 0 | 45 | 15 | si | Juan García-Motilada |
| 2 | Juan Ortiz | Corte de barba | 0 | 10 | 5 | si | Juan Ortiz-Corte de barba |
| 3 | Carlos Arbeladez | Perfilada de barba | 0 | 15 | 5 | si | Carlos Arbeladez-Perfilada de barba |
| 4 | Andres Ramirez | Arreglo completo de barba con toalla caliente | 0 | 40 | 10 | si | Andres Ramirez-Arreglo completo de barba con toalla caliente |
| 5 | Juan Ortiz | Motilada | 0 | 40 | 10 | si | Juan Ortiz-Motilada |
| 6 | Carlos Arbeladez | Corte de barba | 0 | 15 | 5 | si | Carlos Arbeladez-Corte de barba |
| 7 | Juan García | Perfilada de barba | 0 | 20 | 5 | si | Juan García-Perfilada de barba |
| 8 | Andres Ramirez | Motilada | 0 | 50 | 15 | si | Andres Ramirez-Motilada |
| 9 | Juan Zuluaga | Corte de barba | 0 | 12 | 5 | si | Juan Zuluaga-Corte de barba |

**Combinaciones únicas y datos tomados de otros objetos:**

- **barbero**: en los datos de ejemplo se muestra con el primerNombre y el primerApellido del [Barbero](#barbero), separados por un espacio.
- **servicio**: toma el valor de `nombre` de [Servicio](#servicio).
- **Combinación única**: formada por `barbero` + `servicio`.

**Clasificación de las columnas del muestreo:**

- Corresponde al identificador unico del objeto de dominio: id
- Corresponde a las referencias de otros objetos de dominio: barbero, servicio
- Corresponde a los datos que ingresa el usuario: duracionEnHoras, duracionEnMinutos, tiempoExtra
- Corresponde a los datos auto generados por el sistema: vigente
- Corresponde a la combinacion única: Combinación única

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Rendondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | habilitarServicioBarbero | ajustarTiemposServicioBarbero | ajustarTiemposServicioBarbero | consultarServiciosElegidos | consultarServiciosDeBarbero | desactivarServicioBarbero | reactivarServicioBarbero |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| id | Representa un identificador que hará unico cada objeto de dominio de este tipo, no se puede repetir | Si | Identificador único universal | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No | No aplica | No aplica | No aplica | No aplica | No | UUID vacio | Si | No requerido | Requerido | No modificable | No mostrar | No mostrar | Requerido | Requerido |
| barbero | Representa el nombre y apellidos del barbero | No | [Barbero](#barbero) | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | Aplican las reglas del objeto referenciado | No | No aplica | No aplica | No aplica | No aplica | No | UUID vacio | No | Requerido | No requerido | No modificable | No mostrar | Mostrar | No requerido | No requerido |
| servicio | Representa el nombre del servicio de la barberia  | No | [Servicio](#servicio) | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | Aplican las reglas del objeto referenciado | No | No aplica | No aplica | No aplica | No aplica | No | UUID vacio | No | Requerido | No requerido | No modificable | Mostrar | Mostrar | No requerido | No requerido |
| duracionEnHoras | Representa la cantidad de horas que un barbero tarda en realizar un servicio, esta duracion el barbero debe de ser consiente de cuanto se demora en realizarlo | No | Entero | Si | No aplica | No aplica | No aplica | No aplica | 0 | 3 | No aplica | No aplica | No | No aplica | No aplica | No aplica | No aplica | No | 0 | No | Requerido | Requerido | Modificable | Mostrar | No mostrar | No requerido | No requerido |
| duracionEnMinutos | Representa la cantidad de minutos que un barbero tarda en realizar un servicio, esta duracion el barbero debe de ser consiente de cuanto se demora en realizarlo | No | Entero | Si | No aplica | No aplica | No aplica | No aplica | 0 | 59 | No aplica | No aplica | No | No aplica | No aplica | No aplica | No aplica | No | 0 | No | Requerido | Requerido | Modificable | Mostrar | No mostrar | No requerido | No requerido |
| tiempoExtra | Representa la cantidad de minutos que un barbero pone de tiempo extra en las citas de su agenda, cada barbero usa este tiempo porque hay ocaciones que la cita se puede demorar más de lo previsto. Este tiempo les ayuda a evitar que se les retrase la agenda | No | Entero | Si | No aplica | No aplica | No aplica | No aplica | 0 | 59 | No aplica | No aplica | No | No aplica | No aplica | No aplica | No aplica | No | 0 | No | Requerido | Requerido | Modificable | Mostrar | No mostrar | No requerido | No requerido |
| vigente | Representa si el barbero sigue o no presentando el servicio en la barbería | No | Lógico | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No | No aplica | No aplica | No aplica | No aplica | No | Si | No | No requerido | No requerido | No modificable | No mostrar | No mostrar | No requerido | No requerido |

| Nombre combinación única | Descripción | Atributos involucrados |
|---|---|---|
| Combinación única | Combinación única que indica que un mismo barbero no puede aparecer dos veces ofreciendo el mismo servicio | barbero, servicio |

| Responsabilidad | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Salida / Descripción | Políticas (Reglas de Negocio) / Política | Políticas (Reglas de Negocio) / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |
|---|---|---|---|---|---|---|---|---|---|---|
| habilitarServicioBarbero | Comando que permite a un barbero indicar que sabe realizar un servicio del catálogo, con su duración y colchón | datos{barbero, servicio, duracionEnHoras, duracionEnMinutos, tiempoExtra} | BarberoServicio | Contiene la información requerida para habilitarle un servicio a un barbero | BarberoServicio | Contiene la información del servicio habilitado para el barbero | P-BSE-0001 | Asegurar que los datos requeridos (barbero, servicio, duración en horas, duración en minutos, tiempo extra) sean válidos en tipo de dato, obligatoriedad y rango | Generar una excepción indicándole al barbero que los datos no cumplen las reglas definidas | Detener operación |
|  |  |  |  |  |  |  | P-BSE-0003 | Asegurar que el barbero no tenga ya definido ese mismo servicio | Generar una excepción indicándole el barbero ya tiene habilitado ese mismo servicio | Detener operación |
|  |  |  |  |  |  |  | P-BSE-0005 | Asegurar que la suma del tiempo en horas y minutos de la realizacion del servicio por el barbero sea mayor a cero | Generar una excepción indicándole al barbero que los no se puede realizar un servicio en tiempo cero, es decir que debe de poner un timpio mayor a cer, ya que en la hora o en el minuto | Detener operación |
|  |  |  |  |  |  |  | P-BSE-0009 | Asegurar que el servicio pertenezca a la sede en la que trabaja actualmente el barbero (su sedeDeTrabajo) y que esté disponible | Generar una excepción indicándole al barbero que el servicio no está disponible en la sede en la que trabaja | Detener operación |
|  |  |  |  |  |  |  | P-BSE-0010 | Asegurar que no exista otro objeto de tipo BarberoServicio con el mismo id; el id solo debe ser único entre los objetos de tipo BarberoServicio | Generar un nuevo id para el BarberoServicio y volver a validar que no lo tenga otro BarberoServicio | Continuar operación |
| ajustarTiemposServicioBarbero | Permite modificar la duración y el tiempo extra que un barbero usa para un servicio ya habilitado | id | UUID | Corresponde al identificador del servicio del barbero que se va a ajustar | BarberoServicio | Contiene la información del servicio del barbero con sus tiempos actualizados | P-BSE-0004 | Asegurar que exista el servicio definido del barbero con el id enviado | Informar con un mensaje que no existe un servicio habilitado del barbero con el identificador enviado y por lo tanto no es posible llevar a cabo la operación | Detener operación |
|  |  | datos{duracionEnHoras, duracionEnMinutos, tiempoExtra} | BarberoServicio | Contiene los nuevos tiempos con los que se va a modificar el servicio |  |  | P-BSE-0002 | Asegurar que los datos requeridos (duración en horas, duración en minutos, tiempo extra) sean válidos en tipo de dato, obligatoriedad y rango | Generar una excepción indicándole al barbero que los datos no cumplen las reglas definidas | Detener operación |
|  |  |  |  |  |  |  | P-BSE-0005 | Asegurar que la suma del tiempo en horas y minutos de la realizacion del servicio por el barbero sea mayor a cero | Generar una excepción indicándole al barbero que los no se puede realizar un servicio en tiempo cero, es decir que debe de poner un timpio mayor a cer, ya que en la hora o en el minuto | Detener operación |
| consultarServiciosElegidos | Permite a un barbero consultar los servicios que esten vigentes | filtro{barbero} | BarberoServicio | Contiene el barbero por el cual se van a consultar sus servicios habilitados | Lista<BarberoServicio> | Contiene todos los servicios que el barbero tiene habilitados |  |  |  |  |
| consultarServiciosDeBarbero | Permite a un cliente consultar qué servicios ofrece un barbero en particular | filtro{barbero} | BarberoServicio | Contiene el barbero por el cual se van a consultar los servicios que ofrece | Lista<BarberoServicio> | Contiene todos los servicios vigentes que ofrece ese barbero | P-BSE-0008 | Asegurar que el barbero esté vigente (vigente = si) | Informar al cliente que el barbero no se encuentra vigente y por eso no se pueden consultar sus servicios | Detener operación |
| desactivarServicioBarbero | Permite a un barbero desactivar un servicio que ya no quiere seguir ofreciendo | id | UUID | Corresponde al identificador del servicio del barbero que se va a desactivar | No retorna ningún valor. En caso de error genera una excepción. |  | P-BSE-0004 | Asegurar que exista el servicio definido del barbero con el id enviado | Informar con un mensaje que no existe un servicio habilitado del barbero con el identificador enviado y por lo tanto no es posible llevar a cabo la operación | Detener operación |
|  |  |  |  |  |  |  | P-BSE-0006 | Asegurar que el estado de BarberoServicio este vigente | Informar al barbero que el servicio que quiere desactivar, ya se encuentra desactivado | Detener operación |
| reactivarServicioBarbero | Permite a un barbero activar un servicio que ya se habia desactivado | id | UUID | Corresponde al identificador del servicio del barbero que se va a desactivar | No retorna ningún valor. En caso de error genera una excepción. |  | P-BSE-0004 | Asegurar que exista el servicio definido del barbero con el id enviado | Informar con un mensaje que no existe un servicio habilitado del barbero con el identificador enviado y por lo tanto no es posible llevar a cabo la operación | Detener operación |
|  |  |  |  |  |  |  | P-BSE-0007 | Asegurar que el estado del BarberoServicio no este vigente | Informar al barbero que el servicio que quiere reactivar, ya se encuentra activado | Detener operación |
|  |  |  |  |  |  |  | P-BSE-0009 | Asegurar que el servicio pertenezca a la sede en la que trabaja actualmente el barbero (su sedeDeTrabajo) y que esté disponible | Generar una excepción indicándole al barbero que el servicio no está disponible en la sede en la que trabaja | Detener operación |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Barbero | Definir un servicio para el barbero | Comando que permite a un barbero indicar que sabe realizar un servicio del catálogo, con su duración y colchón | BarberoServicio | Servicio | Permite verificar que el servicio pertenezca a la sede en la que trabaja el barbero y esté disponible. | P-BSE-0001 | Asegurar que los datos requeridos (barbero, servicio, duración en horas, duración en minutos, tiempo extra) sean válidos en tipo de dato, obligatoriedad y rango |  | Servicio habilitado para barbero |  |
|  |  |  |  |  |  | P-BSE-0003 | Asegurar que el barbero no tenga ya definido ese mismo servicio |  |  |  |
|  |  |  |  |  |  | P-BSE-0005 | Asegurar que la suma del tiempo en horas y minutos de la realizacion del servicio por el barbero sea mayor a cero |  |  |  |
|  |  |  |  |  |  | P-BSE-0009 | Asegurar que el servicio pertenezca a la sede en la que trabaja actualmente el barbero (su sedeDeTrabajo) y que esté disponible |  |  |  |
| Barbero | Ajustar los tiempos de un servicio del barbero | Permite modificar la duración y el tiempo extra que un barbero usa para un servicio ya habilitado | BarberoServicio |  |  | P-BSE-0002 | Asegurar que los datos requeridos (duración en horas, duración en minutos, tiempo extra) sean válidos en tipo de dato, obligatoriedad y rango |  | Tiempos de servicio de barbero actualizados |  |
|  |  |  |  |  |  | P-BSE-0005 | Asegurar que la suma del tiempo en horas y minutos de la realizacion del servicio por el barbero sea mayor a cero |  |  |  |
| Barbero | Ver servicios elegidos | Permite a un barbero consultar los servicios que tiene habilitados | BarberoServicio |  |  |  |  |  | Servicios de barbero consultados |  |
| Cliente | Ver servicios de un barbero | Permite a un cliente consultar qué servicios ofrece un barbero en particular | BarberoServicio |  |  | P-BSE-0008 | Asegurar que el barbero esté vigente (vigente = si) |  | Servicios de barbero consultados |  |
| Barbero | Dejar de prestar el servicio para el catálogo | Permite a un barbero desactivar un servicio que ya no quiere seguir ofreciendo | BarberoServicio |  |  | P-BSE-0006 | Asegurar que el estado de BarberoServicio este vigente |  | Servicio de barbero desactivado |  |
| Barbero | Volver prestar el servicio para el catálogo | Permite a un barbero desactivar un servicio que ya no quiere seguir ofreciendo | BarberoServicio | Servicio | Permite verificar que el servicio pertenezca a la sede en la que trabaja el barbero y esté disponible. | P-BSE-0007 | Asegurar que el estado del BarberoServicio no este vigente |  | Servicio de barbero reactivado |  |
|  |  |  |  |  |  | P-BSE-0009 | Asegurar que el servicio pertenezca a la sede en la que trabaja actualmente el barbero (su sedeDeTrabajo) y que esté disponible |  |  |  |

### Políticas

| Número Política | Descripción Política | Objeto Responsable |
|---|---|---|
| P-BSE-0001 | Asegurar que los datos requeridos (barbero, servicio, duración en horas, duración en minutos, tiempo extra) sean válidos en tipo de dato, obligatoriedad y rango | [BarberoServicio](#barberoservicio) |
| P-BSE-0002 | Asegurar que los datos requeridos (duración en horas, duración en minutos, tiempo extra) sean válidos en tipo de dato, obligatoriedad y rango | [BarberoServicio](#barberoservicio) |
| P-BSE-0003 | Asegurar que el barbero no tenga ya definido ese mismo servicio | [BarberoServicio](#barberoservicio) |
| P-BSE-0004 | Asegurar que exista el servicio definido del barbero con el id enviado | [BarberoServicio](#barberoservicio) |
| P-BSE-0005 | Asegurar que la suma del tiempo en horas y minutos de la realizacion del servicio por el barbero sea mayor a cero | [BarberoServicio](#barberoservicio) |
| P-BSE-0006 | Asegurar que el estado de BarberoServicio este vigente | [BarberoServicio](#barberoservicio) |
| P-BSE-0007 | Asegurar que el estado del BarberoServicio no este vigente | [BarberoServicio](#barberoservicio) |
| P-BSE-0008 | Asegurar que el barbero esté vigente (vigente = si) | [BarberoServicio](#barberoservicio) |
| P-BSE-0009 | Asegurar que el servicio pertenezca a la sede en la que trabaja actualmente el barbero (su sedeDeTrabajo) y que esté disponible | [Servicio](#servicio) |
| P-BSE-0010 | Asegurar que no exista otro objeto de tipo BarberoServicio con el mismo id; el id solo debe ser único entre los objetos de tipo BarberoServicio | [BarberoServicio](#barberoservicio) |

[↑ Volver al índice](#objetos-de-dominio)

---

## Bloqueo

**Descripción:** Representa los momentos en que el barbero no esta disponible para atender sus citas, el barbero establece la hora y la fecha en que empieza y termina ese estado de no disponible.  
**Línea de vida:** 5

### Muestreo de datos

- **id**: Representa un identificador que hará unico cada objeto de dominio de este tipo, no se puede repetir
- **barbero**: Referencia a qué barbero le pertence este bloqueo (referencia a [Barbero](#barbero))
- **fechaHoraInicio**: Representa la fecha y hora en el que el barbero empieza a no estar disponible para atender las citas
- **fechaHoraFinal**: Representa la fecha y hora en el que el barbero empieza estar disponible nuevamente para atender las citas
- **Combinación única**: Combinación única que indica que un mismo barbero no puede tener dos bloqueos con la misma fecha y hora de inicio y la misma fecha y hora final

| id | barbero | fechaHoraInicio | fechaHoraFinal | Combinación única |
|---|---|---|---|---|
| 1 | +57-3245627890 | 15/06/2026 12:00 | 15/06/2026 13:00 | +57-3245627890-15/06/2026 12:00-15/06/2026 13:00 |
| 2 | +57-3124518923 | 16/06/2026 10:00 | 16/06/2026 10:30 | +57-3124518923-16/06/2026 10:00-16/06/2026 10:30 |
| 3 | +57-3214533321 | 18/06/2026 14:00 | 18/06/2026 15:00 | +57-3214533321-18/06/2026 14:00-18/06/2026 15:00 |
| 4 | +91-9876543210 | 20/06/2026 09:00 | 20/06/2026 09:30 | +91-9876543210-20/06/2026 09:00-20/06/2026 09:30 |
| 5 | +91-9876543210 | 22/06/2026 16:00 | 22/06/2026 16:45 | +91-9876543210-22/06/2026 16:00-22/06/2026 16:45 |

**Combinaciones únicas y datos tomados de otros objetos:**

- **barbero**: referencia a [Barbero](#barbero); en los datos de ejemplo se muestra con su combinación única.
- **Combinación única**: formada por `barbero` + `fechaHoraInicio` + `fechaHoraFinal`.

**Clasificación de las columnas del muestreo:**

- Corresponde al identificador unico del objeto de dominio: id
- Corresponde a las referencias de otros objetos de dominio: barbero
- Corresponde a los datos que ingresa el usuario: fechaHoraInicio, fechaHoraFinal
- Corresponde a la combinacion única: Combinación única

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Rendondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | definirBloqueo | eliminarBloqueo | consultarBloqueosPorFecha | consultarBloqueoPorFechaHora | editarBloqueo | editarBloqueo |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| id | Representa un identificador que hará unico cada objeto de dominio de este tipo, no se puede repetir | Si | Identificador único universal | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No | No | No aplica | No | No | No | UUID vacio | Si | No requerido | Requerido | No mostrar | No mostrar | Requerido | No modificable |
| barbero | Referencia a qué barbero le pertence este bloqueo | No | [Barbero](#barbero) | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | Aplican las reglas del objeto referenciado | No | No aplica | No aplica | No aplica | No aplica | No | UUID vacio | No | Requerido | No requerido | No mostrar | No mostrar | No requerido | No modificable |
| fechaHoraInicio | Representa la fecha y hora en el que el barbero empieza a no estar disponible para atender las citas | No | Fecha hora | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No | No aplica | No aplica | No aplica | No aplica | No | 01/01/1000 00:00 | No | Requerido | No requerido | Mostrar | Mostrar | Requerido | Modificable |
| fechaHoraFinal | Representa la fecha y hora en el que el barbero empieza estar disponible nuevamente para atender las citas | No | Fecha hora | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | Debe ser posterior a fechaHoraInicio | No | No aplica | No aplica | No aplica | No aplica | No | 01/01/1000 00:00 | No | Requerido | No requerido | Mostrar | Mostrar | Requerido | Modificable |

| Nombre combinación única | Descripción | Atributos involucrados |
|---|---|---|
| Combinación única | Combinación única que indica que un mismo barbero no puede tener dos bloqueos con la misma fecha y hora de inicio y la misma fecha y hora final | barbero, fechaHoraInicio, fechaHoraFinal |

| Responsabilidad | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Salida / Descripción | Políticas (Reglas de Negocio) / Política | Políticas (Reglas de Negocio) / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |
|---|---|---|---|---|---|---|---|---|---|---|
| definirBloqueo | Comando que permite a un barbero asignar un espacio de no disponibilidad para atender sus citas | datos{barbero, fechaHoraInicio, fechaHoraFinal} | Bloqueo | Contiene la información requerida para registrar un nuevo bloqueo del barbero | Bloqueo | Contiene la información del bloqueo registrado | P-BLO-0001 | Asegurar que los datos requeridos (fecha y hora de inicio, fecha y hora de fin) sean válidos en tipo de dato, obligatoriedad, formato y rango | Generar una excepción indicándole al barbero que los datos no cumplen los datos requeridos | Detener operación |
|  |  |  |  |  |  |  | P-BLO-0002 | Rechazar el bloqueo si ya existen citas agendadas dentro de ese mismo rango elegido | Generar una excepción indicándole al barbero que ese rango no se puede bloquear porque ya tiene citas agendadas | Detener operación |
|  |  |  |  |  |  |  | P-BLO-0005 | Asegurar que el bloqueo no se cruze con otro bloqueo suyo | Generar una excepción indicándole al barbero que el rango se solapa con otro bloqueo suyo | Detener operación |
|  |  |  |  |  |  |  | P-BLO-0007 | Asegurar que la fecha y hora de fin sea mayor a la fecha y hora de inicio | Generar una excepción indicandole al barbero que la fecha y hora de fin debe de ser mayor a la fecha y hora de inicio | Detener operación |
|  |  |  |  |  |  |  | P-BLO-0008 | Asegurar que no exista otro objeto de tipo Bloqueo con el mismo id; el id solo debe ser único entre los objetos de tipo Bloqueo | Generar un nuevo id para el Bloqueo y volver a validar que no lo tenga otro Bloqueo | Continuar operación |
| eliminarBloqueo | Permite a un barbero liberar un espacio de su agenda que había bloqueado previamente | id | UUID | Corresponde al identificador del bloqueo que se va a eliminar | No retorna ningún valor. En caso de error genera una excepción. |  | P-BLO-0004 | Asegurar que el bloqueo que se va a editar o eliminar le pertenezca al mismo barbero que hace la solicitud | Generar una excepción indicándole al usuario que el bloqueo no le pertenece | Detener operación |
|  |  |  |  |  |  |  | P-BLO-0006 | Asegurar que exista el bloqueo con el id enviado | Informar con un mensaje que no existe un bloqueo con el identificador enviado y por lo tanto no es posible llevar a cabo la operación | Detener operación |
| consultarBloqueosPorFecha | Permite a un barbero ver los espacios que tiene bloqueados en una fecha dada | filtro{barbero, fecha} | Bloqueo | Contiene el barbero y la fecha por los cuales se van a consultar los bloqueos | Lista<Bloqueo> | Contiene todos los bloqueos del barbero en esa fecha |  |  |  |  |
| consultarBloqueoPorFechaHora | Permite al sistema ver si hay o no un bloqueo en una fecha y hora, en el que empieza el bloqueo, para que el determine luego si el cliente puede agenda una cita en ese momento | filtro{barbero, fechaHoraInicio} | Bloqueo | Contiene el barbero y la fecha y hora por las cuales se va a consultar el bloqueo | Bloqueo | Contiene el bloqueo que cubre esa fecha y hora, si existe |  |  |  |  |
| editarBloqueo | Permite al barbero poder editar la fecha y hora en que inicia o termina | id | UUID | Corresponde al identificador del bloqueo que se va a editar | Bloqueo | Contiene la información del bloqueo con su rango actualizado | P-BLO-0006 | Asegurar que exista el bloqueo con el id enviado | Informar con un mensaje que no existe un bloqueo con el identificador enviado y por lo tanto no es posible llevar a cabo la operación | Detener operación |
|  |  | datos{fechaHoraInicio, fechaHoraFinal} | Bloqueo | Contiene el nuevo rango con el que se va a modificar el bloqueo |  |  | P-BLO-0003 | Asegurar que los datos requeridos para editar el bloqueo (fecha y hora de inicio, fecha y hora de fin) sean válidos en tipo de dato, obligatoriedad, formato y rango, y que la fecha y hora de fin sea mayor a la de inicio | Generar una excepción indicándole al usuario cuáles datos del bloqueo que se va a editar no cumplen con las reglas definidas | Detener operación |
|  |  |  |  |  |  |  | P-BLO-0002 | Rechazar el bloqueo si ya existen citas agendadas dentro de ese mismo rango elegido | Generar una excepción indicándole al usuario que ese rango no se puede bloquear porque ya tiene citas agendadas | Detener operación |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Barbero | Definir un bloque de no disponible | Comando que permite a un barbero asiganar un espacio de no disponibilidad para atender sus citas | Bloqueo | HorarioBarbero | Permite llegar de las agendas al barbero dueño de cada cita, ya que la cita no referencia al barbero directamente. | P-BLO-0001 | Asegurar que los datos requeridos (fecha y hora de inicio, fecha y hora de fin) sean válidos en tipo de dato, obligatoriedad, formato y rango |  | Bloqueo registrado |  |
|  |  |  |  | Agenda | Permite conocer la fecha de cada cita, ya que la cita solo almacena horas. Es lo que hace comparable el rango del bloqueo contra las citas existentes. | P-BLO-0002 | Rechazar el bloqueo si ya existen citas agendadas dentro de ese mismo rango elegido |  |  |  |
|  |  |  |  | Cita | Permite verificar que no haya citas ya agendadas dentro del rango que se va a bloquear. | P-BLO-0005 | Asegurar que el bloqueo no se cruze con otro bloqueo suyo |  |  |  |
|  |  |  |  | Estado | Permite descartar las citas canceladas, que no deben impedir el bloqueo. | P-BLO-0007 | Asegurar que la fecha y hora de fin sea mayor a la fecha y hora de inicio |  |  |  |
| Barbero | Eliminar un bloqueo | Permite a un barbero liberar un espacio de su agenda que había bloqueado previamente | Bloqueo |  |  | P-BLO-0004 | Asegurar que el bloqueo que se va a editar o eliminar le pertenezca al mismo barbero que hace la solicitud |  | Bloqueo cancelado |  |
| Barbero | Ver bloqueos en una fecha | Permite a un barbero ver los espacios que tiene bloqueados en una fecha dada | Bloqueo |  |  |  |  |  | Bloqueos vistos |  |
| Sistema | Ver bloqueo en una fecha y hora de inicio | Permite al sistema ver si hay o no un bloqueo en una fecha y hora, en el que empieza el bloqueo, para que el determine luego si el cliente puede agendar una cita en ese momento | Bloqueo |  |  |  |  |  | Bloqueo visto |  |
| Barbero | Ver bloqueo en una fecha y hora de inicio | Permite al barbero ver si hay o no un bloqueo en una fecha y hora, en el que empieza el bloqueo, para que mire si el puso o no un bloqueo | Bloqueo |  |  |  |  |  | Bloqueo visto |  |
| Barbero | Editar un bloqueo | Permite al barbero poder editar la fecha y hora en que inicia o termina | Bloqueo | HorarioBarbero | Permite llegar de las agendas al barbero dueño de cada cita, ya que la cita no referencia al barbero directamente. | P-BLO-0002 | Rechazar el bloqueo si ya existen citas agendadas dentro de ese mismo rango elegido |  | Bloqueo editado |  |
|  |  |  |  | Agenda | Permite conocer la fecha de cada cita, ya que la cita solo almacena horas. Es lo que hace comparable el rango del bloqueo contra las citas existentes. | P-BLO-0003 | Asegurar que los datos requeridos para editar el bloqueo (fecha y hora de inicio, fecha y hora de fin) sean válidos en tipo de dato, obligatoriedad, formato y rango, y que la fecha y hora de fin sea mayor a la de inicio |  |  |  |
|  |  |  |  | Cita | Permite verificar que el nuevo rango no choque con citas ya agendadas. |  |  |  |  |  |
|  |  |  |  | Estado | Permite descartar las citas canceladas, que no deben impedir el bloqueo. |  |  |  |  |  |

### Políticas

| Número Política | Descripción Política | Objeto Responsable |
|---|---|---|
| P-BLO-0001 | Asegurar que los datos requeridos (fecha y hora de inicio, fecha y hora de fin) sean válidos en tipo de dato, obligatoriedad, formato y rango | [Bloqueo](#bloqueo) |
| P-BLO-0002 | Rechazar el bloqueo si ya existen citas agendadas dentro de ese mismo rango elegido | [Cita](#cita) |
| P-BLO-0003 | Asegurar que los datos requeridos para editar el bloqueo (fecha y hora de inicio, fecha y hora de fin) sean válidos en tipo de dato, obligatoriedad, formato y rango, y que la fecha y hora de fin sea mayor a la de inicio | [Bloqueo](#bloqueo) |
| P-BLO-0004 | Asegurar que el bloqueo que se va a editar o eliminar le pertenezca al mismo barbero que hace la solicitud | [Bloqueo](#bloqueo) |
| P-BLO-0005 | Asegurar que el bloqueo no se cruze con otro bloqueo suyo | [HorarioBarbero](#horariobarbero) |
| P-BLO-0006 | Asegurar que exista el bloqueo con el id enviado | [Bloqueo](#bloqueo) |
| P-BLO-0007 | Asegurar que la fecha y hora de fin sea mayor a la fecha y hora de inicio | [Bloqueo](#bloqueo) |
| P-BLO-0008 | Asegurar que no exista otro objeto de tipo Bloqueo con el mismo id; el id solo debe ser único entre los objetos de tipo Bloqueo | [Bloqueo](#bloqueo) |

[↑ Volver al índice](#objetos-de-dominio)

---

## HorarioBarbero

**Descripción:** Representa el día de la semana en que trabaja un barbero, junto con la hora en la que empieza y termina su jornada de trabajo.  
**Línea de vida:** 5

### Muestreo de datos

- **id**: Representa un identificador que hará unico cada objeto de dominio de este tipo, no se puede repetir
- **barbero**: Referencia a que barbero va a ser dueño de este horario (referencia a [Barbero](#barbero))
- **horarioDeLaSede**: Hace referencia al horario de la sede en la que trabaja el barbero, dentro del cual se define este horario de trabajo (referencia a [HorarioSede](#horariosede))
- **horaInicio**: Representa la hora en la que el barbero empieza a estar disponible ese dia
- **horaFinal**: Representa la hora en la que el barbero deja de estar disponible ese día.
- **fechaCreacion**: Representa la fecha en el que el barbero creo su horario. Es un dato calculado que toma la fecha de hoy cuando el barbero la crea
- **fechaDesactivacion**: Representa la fecha en la que este horario dejó de estar vigente, ya sea porque el barbero lo retiró o porque se desactivó el horario de la sede del que depende. Es un dato calculado que toma la fecha del sistema en ese momento.
- **vigente**: Representa si este horario lo sigue o no usando el barbero. Una vez que el barbero cambie este estado a no vigente, no se puede volver a cambiar
- **Combinación única**: Combinación única que indica que un mismo barbero no puede tener dos horarios con el mismo día de la barbería, la misma hora de inicio, la misma hora final, misma fecha de creacion y de desactivacion

| id | barbero | horarioDeLaSede | horaInicio | horaFinal | fechaCreacion | fechaDesactivacion | vigente | Combinación única |
|---|---|---|---|---|---|---|---|---|
| 1 | +57-3245627890 | BarberClub Colombia-Sede Poblado-Lunes-09:00-19:00-12/11/2023-1/01/1000 | 10:00 | 16:00 | 03/05/2025 | 1/01/1000 | si | +57-3245627890-BarberClub Colombia-Sede Poblado-Lunes-09:00-19:00-12/11/2023-1/01/1000-10:00-16:00-03/05/2025-1/01/1000 |
| 2 | +57-3124518923 | BarberClub Colombia-Sede Poblado-Martes-09:00-19:00-12/11/2023-1/01/1000 | 09:00 | 15:00 | 02/03/2025 | 1/01/1000 | si | +57-3124518923-BarberClub Colombia-Sede Poblado-Martes-09:00-19:00-12/11/2023-1/01/1000-09:00-15:00-02/03/2025-1/01/1000 |
| 3 | +57-3214533321 | BarberClub Colombia-Sede Poblado-Jueves-09:00-19:00-12/11/2023-1/01/1000 | 13:00 | 19:00 | 22/12/2022 | 1/01/1000 | si | +57-3214533321-BarberClub Colombia-Sede Poblado-Jueves-09:00-19:00-12/11/2023-1/01/1000-13:00-19:00-22/12/2022-1/01/1000 |
| 4 | +91-9876543210 | BarberClub Colombia-Sede Poblado-Sábado-08:00-21:00-12/12/2024-1/01/1000 | 08:00 | 14:00 | 15/09/2025 | 01/01/2026 | no | +91-9876543210-BarberClub Colombia-Sede Poblado-Sábado-08:00-21:00-12/12/2024-1/01/1000-08:00-14:00-15/09/2025-01/01/2026 |

**Combinaciones únicas y datos tomados de otros objetos:**

- **barbero**: referencia a [Barbero](#barbero); en los datos de ejemplo se muestra con su combinación única.
- **horarioDeLaSede**: referencia a [HorarioSede](#horariosede); en los datos de ejemplo se muestra con su combinación única.
- **Combinación única**: formada por `barbero` + `horarioDeLaSede` + `horaInicio` + `horaFinal` + `fechaCreacion` + `fechaDesactivacion`.

**Clasificación de las columnas del muestreo:**

- Corresponde al identificador unico del objeto de dominio: id
- Corresponde a las referencias de otros objetos de dominio: barbero, horarioDeLaSede
- Corresponde a los datos auto generados por el sistema: fechaCreacion, fechaDesactivacion, vigente
- Corresponde a los datos que ingresa el usuario: horaInicio, horaFinal
- Corresponde a la combinacion única: Combinación única

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Rendondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | definirHorarioDeTrabajo | consultarHorariosDefinidos | desactivarHorarioDeTrabajo | consultarHorariosDeTrabajoDeBarbero |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| id | Representa un identificador que hará unico cada objeto de dominio de este tipo, no se puede repetir | Si | Identificador único universal | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No | No | No aplica | No | No | No | UUID vacio | Si | No requerido | No mostrar | Requerido | No mostrar |
| barbero | Referencia a que barbero va a ser dueño de este horario | No | [Barbero](#barbero) | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | Aplican las reglas del objeto referenciado | No | No aplica | No aplica | No aplica | No aplica | No | UUID vacio | No | Requerido | No mostrar | No requerido | Mostrar |
| horarioDeLaSede | Hace referencia al horario de la sede en la que trabaja el barbero, dentro del cual se define este horario de trabajo | No | [HorarioSede](#horariosede) | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | Aplican las reglas del objeto referenciado | No | No aplica | No aplica | No aplica | No aplica | No | UUID vacio | No | Requerido | Mostrar | No requerido | Mostrar |
| horaInicio | Representa la hora en la que el barbero empieza a estar disponible ese dia | No | Hora | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | Debe estar dentro del rango de horarioDeLaSede | No | No aplica | No aplica | No aplica | No aplica | No | 00:00 | No | Requerido | Mostrar | No requerido | Mostrar |
| horaFinal | Representa la hora en la que el barbero deja de estar disponible ese día. | No | Hora | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | Debe ser mayor a horaInicio y estar dentro del rango de horarioDeLaSede | No | No aplica | No aplica | No aplica | No aplica | No | 00:00 | No | Requerido | Mostrar | No requerido | Mostrar |
| fechaCreacion | Representa la fecha en el que el barbero creo su horario. Es un dato calculado que toma la fecha de hoy cuando el barbero la crea | No | Fecha | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | Toma la fecha del sistema en el momento en que el barbero crea este horario | Si | No aplica | No aplica | No aplica | No aplica | No | 01/01/1000 | Si | No requerido | Mostrar | No requerido | No mostrar |
| fechaDesactivacion | Representa la fecha en la que este horario dejó de estar vigente, ya sea porque el barbero lo retiró o porque se desactivó el horario de la sede del que depende. Es un dato calculado que toma la fecha del sistema en ese momento. | No | Fecha | No | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | Toma la fecha del sistema en el momento en que el barbero desactiva este horario. Su valor por defecto es 01/01/1000 mientras siga vigente | Si | No aplica | No aplica | No aplica | No aplica | No | 01/01/1000 | Si | No requerido | Mostrar | No requerido | No mostrar |
| vigente | Representa si este horario lo sigue o no usando el barbero. Una vez que el barbero cambie este estado a no vigente, no se puede volver a cambiar | No | Lógico | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | Una vez se cambia a No, no puede volver a cambiar a Si | No | No aplica | No aplica | No aplica | No aplica | No | Si | Si | No requerido | Mostrar | No requerido | No mostrar |

| Nombre combinación única | Descripción | Atributos involucrados |
|---|---|---|
| Combinación única | Combinación única que indica que un mismo barbero no puede tener dos horarios con el mismo día de la barbería, la misma hora de inicio, la misma hora final, misma fecha de creacion y de desactivacion | barbero, horarioDeLaSede, horaInicio, horaFinal, fechaCreacion, fechaDesactivacion |

| Responsabilidad | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Salida / Descripción | Políticas (Reglas de Negocio) / Política | Políticas (Reglas de Negocio) / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |
|---|---|---|---|---|---|---|---|---|---|---|
| definirHorarioDeTrabajo | Comando que permite a un barbero registrar el día de la semana y las horas en que trabaja | datos{barbero, horarioDeLaSede, horaInicio, horaFinal} | HorarioBarbero | Contiene la información requerida para registrar el horario de trabajo del barbero | HorarioBarbero | Contiene la información del horario de trabajo registrado | P-HBO-0001 | Asegurar que los datos requeridos (horario de la sede, hora de inicio, hora de fin) sean válidos en tipo de dato, obligatoriedad, formato y rango | Generar una excepción indicándole al barbero que los datos no cumplen las reglas definidas | Detener operación |
|  |  |  |  |  |  |  | P-HBO-0002 | Asegurar que el horario de trabajo esté dentro del horario de apertura y cierre de la sede para ese día | Generar una excepción indicándole al barbero que el horario de trabajo queda por fuera del horario de apertura y cierre de la barbería para ese día | Detener operación |
|  |  |  |  |  |  |  | P-HBO-0006 | Asegurar que la hora de fin sea mayor a la hora de inicio | Generar una excepción indicándole al barbero que la hora de fin debe ser mayor a la hora de inicio | Detener operación |
|  |  |  |  |  |  |  | P-HBO-0008 | Asegurar que el horario de la sede elegido pertenezca a la sede en la que trabaja actualmente el barbero (su sedeDeTrabajo) | Generar una excepción indicándole al barbero que el horario elegido no pertenece a la sede en la que trabaja | Detener operación |
|  |  |  |  |  |  |  | P-HBO-0009 | Asegurar que no exista otro objeto de tipo HorarioBarbero con el mismo id; el id solo debe ser único entre los objetos de tipo HorarioBarbero | Generar un nuevo id para el HorarioBarbero y volver a validar que no lo tenga otro HorarioBarbero | Continuar operación |
| consultarHorariosDefinidos | Permite a un barbero consultar los horarios de trabajo que ha definido | filtro{barbero} | HorarioBarbero | Contiene el barbero por el cual se van a consultar sus horarios de trabajo | Lista<HorarioBarbero> | Contiene todos los horarios de trabajo que el barbero tiene definidos |  |  |  |  |
| desactivarHorarioDeTrabajo | Permite a un barbero desactivar un horario para dejar de trabajar ese día de la semana, cancelando las citas futuras que dependían de él | id | UUID | Corresponde al identificador del horario de trabajo que se va a desactivar |  | No retorna ningún valor. En caso de error genera una excepción. | P-HBO-0004 | Asegurar que queden canceladas, en el estado Cancelación, todas las citas futuras asociadas a las agendas generadas a partir de ese horario de trabajo. Se consideran futuras las citas cuya agenda tenga una fecha posterior a la fecha actual | Si alguna de las citas futuras no pudo ser cancelada, revertir toda la operación e informar el error | Detener operación |
|  |  |  |  |  |  |  | P-HBO-0005 | Asegurar que exista el horario de trabajo del barbero con el id enviado | Informar con un mensaje que no existe un horario de trabajo con el identificador enviado y por lo tanto no es posible llevar a cabo la operación | Detener operación |
|  |  |  |  |  |  |  | P-HBO-0007 | Asegurar que el horario de trabajo que se va a desactivar se encuentre vigente | Informar con un mensaje que ese horario de trabajo ya se encuentra desactivado y por lo tanto no puede volver a desactivarse | Detener operación |
| consultarHorariosDeTrabajoDeBarbero | Permite a un cliente consultar en qué días y horas trabaja un barbero | filtro{barbero} | HorarioBarbero | Contiene el barbero por el cual se van a consultar sus horarios de trabajo | Lista<HorarioBarbero> | Contiene todos los horarios de trabajo vigentes de ese barbero |  |  |  |  |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Barbero | Definir mi horario de trabajo | Comando que permite a un barbero registrar el día de la semana y las horas en que trabaja | HorarioBarbero | HorarioSede | Permite verificar que el horario elegido pertenezca a la sede en la que trabaja el barbero y conocer sus horas de apertura y cierre. | P-HBO-0001 | Asegurar que los datos requeridos (horario de la sede, hora de inicio, hora de fin) sean válidos en tipo de dato, obligatoriedad, formato y rango |  | Horario de barbero definido |  |
|  |  |  |  |  |  | P-HBO-0002 | Asegurar que el horario de trabajo esté dentro del horario de apertura y cierre de la sede para ese día |  |  |  |
|  |  |  |  |  |  | P-HBO-0006 | Asegurar que la hora de fin sea mayor a la hora de inicio |  |  |  |
|  |  |  |  |  |  | P-HBO-0008 | Asegurar que el horario de la sede elegido pertenezca a la sede en la que trabaja actualmente el barbero (su sedeDeTrabajo) |  |  |  |
| Barbero | Ver mis horarios definidos | Permite a un barbero consultar los horarios de trabajo que ha definido | HorarioBarbero |  |  |  |  |  | Horarios de barbero consultados |  |
| Barbero | Desactivar horario de trabajo | Permite a un barbero desactivar un horario para dejar de trabajar ese día de la semana, cancelando las citas futuras que dependían de él | HorarioBarbero | Agenda | Permite identificar las citas futuras que quedaron en las agendas generadas a partir de ese horario. La agenda no se modifica: solo se recorre para llegar a las citas. | P-HBO-0004 | Asegurar que queden canceladas, en el estado Cancelación, todas las citas futuras asociadas a las agendas generadas a partir de ese horario de trabajo. Se consideran futuras las citas cuya agenda tenga una fecha posterior a la fecha actual |  | Horario de barbero desactivado |  |
|  |  |  |  | Cita | Permite identificar las citas futuras que se deben cancelar. | P-HBO-0005 | Asegurar que exista el horario de trabajo del barbero con el id enviado |  |  |  |
|  |  |  |  | Estado | Permite dejar esas citas en el estado Cancelación. | P-HBO-0007 | Asegurar que el horario de trabajo que se va a desactivar se encuentre vigente |  |  |  |
| Cliente | Ver horarios de trabajo de un barbero | Permite a un cliente consultar en qué días y horas trabaja un barbero | HorarioBarbero |  |  |  |  |  | Horarios de barbero consultados |  |

### Políticas

| Número Política | Descripción Política | Objeto Responsable |
|---|---|---|
| P-HBO-0001 | Asegurar que los datos requeridos (horario de la sede, hora de inicio, hora de fin) sean válidos en tipo de dato, obligatoriedad, formato y rango | [HorarioBarbero](#horariobarbero) |
| P-HBO-0002 | Asegurar que el horario de trabajo esté dentro del horario de apertura y cierre de la sede para ese día | [HorarioSede](#horariosede) |
| P-HBO-0004 | Asegurar que queden canceladas, en el estado Cancelación, todas las citas futuras asociadas a las agendas generadas a partir de ese horario de trabajo. Se consideran futuras las citas cuya agenda tenga una fecha posterior a la fecha actual | [Cita](#cita) |
| P-HBO-0005 | Asegurar que exista el horario de trabajo del barbero con el id enviado | [HorarioBarbero](#horariobarbero) |
| P-HBO-0006 | Asegurar que la hora de fin sea mayor a la hora de inicio | [HorarioBarbero](#horariobarbero) |
| P-HBO-0007 | Asegurar que el horario de trabajo que se va a desactivar se encuentre vigente | [HorarioBarbero](#horariobarbero) |
| P-HBO-0008 | Asegurar que el horario de la sede elegido pertenezca a la sede en la que trabaja actualmente el barbero (su sedeDeTrabajo) | [HorarioSede](#horariosede) |
| P-HBO-0009 | Asegurar que no exista otro objeto de tipo HorarioBarbero con el mismo id; el id solo debe ser único entre los objetos de tipo HorarioBarbero | [HorarioBarbero](#horariobarbero) |

[↑ Volver al índice](#objetos-de-dominio)

---

## Agenda

**Descripción:** Representa una fecha puntual en donde el barbero ve todas las citas que debe de atender ese día. El sistema la crea con anticipación, de modo que siempre haya agendas desde hoy hasta 15 días después.  
**Línea de vida:** 6

### Muestreo de datos

- **id**: Representa un identificador que hará unico cada objeto de dominio de este tipo, no se puede repetir
- **horarioDelBarbero**: Hace referencia al horario de trabajo del barbero (día de la semana, hora de inicio y hora final) al que pertenece esta agenda (referencia a [HorarioBarbero](#horariobarbero))
- **fecha**: Representa la fecha específica en el que la agenda va a guardar las citas de ese barbero
- **Combinación única **: Combinación única que indica que un mismo horario de barbero no puede tener más de una agenda para el mismo día

| id | horarioDelBarbero | fecha | Combinación única  |
|---|---|---|---|
| 1 | +57-3245627890-BarberClub Colombia-Sede Poblado-Lunes-09:00-19:00-12/11/2023-1/01/1000-10:00-16:00-03/05/2025-1/01/1000 | 05/10/2026 | +57-3245627890-BarberClub Colombia-Sede Poblado-Lunes-09:00-19:00-12/11/2023-1/01/1000-10:00-16:00-03/05/2025-1/01/1000-05/10/2026 |
| 2 | +57-3124518923-BarberClub Colombia-Sede Poblado-Martes-09:00-19:00-12/11/2023-1/01/1000-09:00-15:00-02/03/2025-1/01/1000 | 10/03/2026 | +57-3124518923-BarberClub Colombia-Sede Poblado-Martes-09:00-19:00-12/11/2023-1/01/1000-09:00-15:00-02/03/2025-1/01/1000-10/03/2026 |
| 3 | +57-3214533321-BarberClub Colombia-Sede Poblado-Jueves-09:00-19:00-12/11/2023-1/01/1000-13:00-19:00-22/12/2022-1/01/1000 | 14/05/2026 | +57-3214533321-BarberClub Colombia-Sede Poblado-Jueves-09:00-19:00-12/11/2023-1/01/1000-13:00-19:00-22/12/2022-1/01/1000-14/05/2026 |
| 4 | +91-9876543210-BarberClub Colombia-Sede Poblado-Sábado-08:00-21:00-12/12/2024-1/01/1000-08:00-14:00-15/09/2025-01/01/2026 | 22/11/2025 | +91-9876543210-BarberClub Colombia-Sede Poblado-Sábado-08:00-21:00-12/12/2024-1/01/1000-08:00-14:00-15/09/2025-01/01/2026-22/11/2025 |
| 5 | +57-3214533321-BarberClub Colombia-Sede Poblado-Jueves-09:00-19:00-12/11/2023-1/01/1000-13:00-19:00-22/12/2022-1/01/1000 | 06/08/2026 | +57-3214533321-BarberClub Colombia-Sede Poblado-Jueves-09:00-19:00-12/11/2023-1/01/1000-13:00-19:00-22/12/2022-1/01/1000-06/08/2026 |
| 6 | +57-3245627890-BarberClub Colombia-Sede Poblado-Lunes-09:00-19:00-12/11/2023-1/01/1000-10:00-16:00-03/05/2025-1/01/1000 | 01/06/2026 | +57-3245627890-BarberClub Colombia-Sede Poblado-Lunes-09:00-19:00-12/11/2023-1/01/1000-10:00-16:00-03/05/2025-1/01/1000-01/06/2026 |
| 7 | +57-3124518923-BarberClub Colombia-Sede Poblado-Martes-09:00-19:00-12/11/2023-1/01/1000-09:00-15:00-02/03/2025-1/01/1000 | 16/06/2026 | +57-3124518923-BarberClub Colombia-Sede Poblado-Martes-09:00-19:00-12/11/2023-1/01/1000-09:00-15:00-02/03/2025-1/01/1000-16/06/2026 |
| 8 | +57-3214533321-BarberClub Colombia-Sede Poblado-Jueves-09:00-19:00-12/11/2023-1/01/1000-13:00-19:00-22/12/2022-1/01/1000 | 02/07/2026 | +57-3214533321-BarberClub Colombia-Sede Poblado-Jueves-09:00-19:00-12/11/2023-1/01/1000-13:00-19:00-22/12/2022-1/01/1000-02/07/2026 |

**Combinaciones únicas y datos tomados de otros objetos:**

- **horarioDelBarbero**: referencia a [HorarioBarbero](#horariobarbero); en los datos de ejemplo se muestra con su combinación única.
- **Combinación única**: formada por `horarioDelBarbero` + `fecha`.

**Clasificación de las columnas del muestreo:**

- Corresponde al identificador unico del objeto de dominio: id
- Corresponde a las referencias de otros objetos de dominio: horarioDelBarbero
- Corresponde a los datos auto generados por el sistema: fecha
- Corresponde a la combinacion única: Combinación única 

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Rendondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | crearAgendaBarbero | consultarDisponibilidadBarbero | consultarCitasDeAgenda | consultarCitasPorBarberoYRango |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| id | Representa un identificador que hará unico cada objeto de dominio de este tipo, no se puede repetir | Si | Identificador único universal | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No | No | No aplica | No | No | No | UUID vacio | Si | No requerido | No mostrar | No mostrar | No mostrar |
| horarioDelBarbero | Hace referencia al horario de trabajo del barbero (día de la semana, hora de inicio y hora final) al que pertenece esta agenda | No | [HorarioBarbero](#horariobarbero) | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | Aplican las reglas del objeto referenciado | No | No aplica | No aplica | No aplica | No aplica | No | UUID vacio | No | Requerido | No mostrar | Mostrar | Mostrar |
| fecha | Representa la fecha específica en el que la agenda va a guardar las citas de ese barbero | No | Fecha | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No | No aplica | No aplica | No aplica | No aplica | No | 01/01/1000 | Si | Requerido | Mostrar | Mostrar | Mostrar |

| Nombre combinación única | Descripción | Atributos involucrados |
|---|---|---|
| Combinación única  | Combinación única que indica que un mismo horario de barbero no puede tener más de una agenda para el mismo día | horarioDelBarbero, fecha |

| Responsabilidad | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Salida / Descripción | Políticas (Reglas de Negocio) / Política | Políticas (Reglas de Negocio) / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |
|---|---|---|---|---|---|---|---|---|---|---|
| crearAgendaBarbero | Comando que el sistema ejecuta todos los días para crear la agenda de un barbero en cada fecha desde hoy hasta hoy + 15 días, para que los clientes siempre puedan agendar en ese rango y el barbero sepa qué citas debe atender | datos{horarioDelBarbero, fecha} | Agenda | Contiene la información requerida para abrirle la agenda del día a un barbero | Agenda | Contiene la información de la agenda abierta | P-AGE-0001 | Asegurar que no exista ya una agenda para ese mismo horario de barbero y esa misma fecha | Generar una excepción indicándole al usuario que ya existe una agenda para ese horario de barbero y esa misma fecha | Detener operación |
|  |  |  |  |  |  |  | P-AGE-0002 | Asegurar que el barbero esté vigente antes de abrirle una nueva agenda | Generar una excepción indicándole al usuario que no se le puede abrir agenda porque el barbero no está vigente | Detener operación |
|  |  |  |  |  |  |  | P-AGE-0005 | Asegurar que no se abra una agenda cuando toda la jornada del horario del barbero en esa fecha queda dentro de un periodo de cierre de la sede de ese horario; si el cierre cubre solo una parte de la jornada, la agenda se abre normalmente y las horas cerradas quedan sin disponibilidad. Si el periodo de cierre se registra después de que la agenda ya se creó, la agenda se conserva y las citas en estado Agendada que se crucen con el cierre se cancelan (P-PCI-0006) | Generar una excepción indicándole al usuario que no se puede abrir la agenda porque la sede permanece cerrada durante toda la jornada del barbero en esa fecha | Detener operación |
|  |  |  |  |  |  |  | P-AGE-0006 | Asegurar que no se abra una agenda en una fecha que es festivo si la sede del horario del barbero no tiene registrada la apertura de ese festivo; por defecto las sedes no abren los festivos y, cuando abren, atienden con su horario habitual del día de la semana en que cae el festivo | Generar una excepción indicándole al usuario que no se puede abrir la agenda porque la fecha es un festivo en el que la sede no abre | Detener operación |
|  |  |  |  |  |  |  | P-AGE-0007 | Asegurar que la fecha de la agenda esté entre el día de hoy y hoy + 15 días y que caiga en el mismo día de la semana del horario del barbero. Todos los días el sistema crea las agendas que falten en ese rango para cada horario vigente de los barberos vigentes, de modo que los clientes siempre tengan agendas disponibles para los próximos 15 días | Generar una excepción indicándole al usuario que la fecha de la agenda debe estar entre hoy y hoy + 15 días y coincidir con el día de la semana del horario del barbero | Detener operación |
|  |  |  |  |  |  |  | P-AGE-0004 | Asegurar que no exista otro objeto de tipo Agenda con el mismo id; el id solo debe ser único entre los objetos de tipo Agenda | Generar un nuevo id para el Agenda y volver a validar que no lo tenga otro Agenda | Continuar operación |
| consultarDisponibilidadBarbero | Permite a un cliente ver qué espacios le quedan libres a un barbero en una fecha, descontando sus citas ya agendadas, sus bloqueos, los periodos en los que la sede permanece cerrada y los festivos en los que la sede no abre | filtro{barbero, fecha} | Agenda | Contiene el barbero y la fecha por los cuales se va a consultar la disponibilidad | Lista<Hora> | Contiene los espacios libres del barbero en esa fecha, descontando sus citas, sus bloqueos y los periodos de cierre de la sede; si la fecha es un festivo en el que la sede no abre, la lista queda vacía | P-AGE-0003 | Al consultar la disponibilidad de una agenda, descontar de la jornada del barbero las horas que ya tienen una cita, las que están cubiertas por un bloqueo del barbero y las que están cubiertas por un periodo de cierre de la sede del horario del barbero. Si la fecha es un festivo en el que la sede no tiene registrada la apertura, no queda ningún espacio disponible | Si no se pueden descontar las citas, los bloqueos, los periodos de cierre o los festivos en los que la sede no abre, informar que la disponibilidad no se pudo calcular | Detener operación |
| consultarCitasDeAgenda | Permite consultar todas las citas agrupadas en la agenda de un barbero para una fecha puntual | filtro{barbero, fecha} | Agenda | Contiene el barbero y la fecha por los cuales se van a consultar las citas | Lista<Cita> | Contiene todas las citas agrupadas en la agenda del barbero para esa fecha |  |  |  |  |
| consultarCitasPorBarberoYRango | Permite consultar las citas no canceladas de un barbero dentro de un rango de fecha y hora, recorriendo todas las agendas comprendidas en ese rango | filtro{barbero, fechaHoraInicio, fechaHoraFinal} | Agenda | Contiene el barbero y el rango de fecha y hora por los cuales se van a consultar las citas | Lista<Cita> | Contiene todas las citas no canceladas del barbero comprendidas en ese rango de fecha y hora |  |  |  |  |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Sistema | Crear la agenda de un barbero para una fecha | Comando que el sistema ejecuta todos los días para crear la agenda de un barbero en cada fecha desde hoy hasta 15 días en adelante, para que los clientes siempre puedan agendar en ese rango y el barbero sepa qué citas debe atender | Agenda | Barbero | Permite verificar que el barbero esté vigente antes de abrirle la agenda. | P-AGE-0001 | Asegurar que no exista ya una agenda para ese mismo horario de barbero y esa misma fecha |  | Agenda creada |  |
|  |  |  |  | HorarioBarbero | Permite conocer la jornada de trabajo del barbero para esa fecha. | P-AGE-0002 | Asegurar que el barbero esté vigente antes de abrirle una nueva agenda |  |  |  |
|  |  |  |  | HorarioSede | Permite conocer la sede a la que pertenece el horario del barbero. | P-AGE-0005 | Asegurar que no se abra una agenda cuando toda la jornada del horario del barbero en esa fecha queda dentro de un periodo de cierre de la sede de ese horario; si el cierre cubre solo una parte de la jornada, la agenda se abre normalmente y las horas cerradas quedan sin disponibilidad. Si el periodo de cierre se registra después de que la agenda ya se creó, la agenda se conserva y las citas en estado Agendada que se crucen con el cierre se cancelan (P-PCI-0006) |  |  |  |
|  |  |  |  | Festivo | Permite saber si la fecha de la agenda es festivo. | P-AGE-0006 | Asegurar que no se abra una agenda en una fecha que es festivo si la sede del horario del barbero no tiene registrada la apertura de ese festivo; por defecto las sedes no abren los festivos y, cuando abren, atienden con su horario habitual del día de la semana en que cae el festivo |  |  |  |
|  |  |  |  | SedeFestivo | Permite saber si la sede del horario del barbero abre en ese festivo. | P-AGE-0007 | Asegurar que la fecha de la agenda esté entre el día de hoy y hoy + 15 días y que caiga en el mismo día de la semana del horario del barbero. Todos los días el sistema crea las agendas que falten en ese rango para cada horario vigente de los barberos vigentes, de modo que los clientes siempre tengan agendas disponibles para los próximos 15 días |  |  |  |
|  |  |  |  | PeriodoCierre | Permite saber si toda la jornada del barbero en esa fecha queda dentro de un periodo de cierre de la sede. |  |  |  |  |  |
| Cliente | Consultar la disponibilidad de un barbero para una fecha | Permite a un cliente ver qué espacios le quedan libres a un barbero en una fecha, descontando sus citas ya agendadas, sus bloqueos, los periodos en los que la sede permanece cerrada y los festivos en los que la sede no abre | Agenda | Cita | Permite conocer las horas de esa fecha que ya están ocupadas por una cita. | P-AGE-0003 | Al consultar la disponibilidad de una agenda, descontar de la jornada del barbero las horas que ya tienen una cita, las que están cubiertas por un bloqueo del barbero y las que están cubiertas por un periodo de cierre de la sede del horario del barbero. Si la fecha es un festivo en el que la sede no tiene registrada la apertura, no queda ningún espacio disponible |  | Disponibilidad de barbero consultada |  |
|  |  |  |  | Bloqueo | Permite conocer las horas de esa fecha en las que el barbero no está disponible. |  |  |  |  |  |
|  |  |  |  | HorarioSede | Permite conocer, a través del horario del barbero, la sede de la agenda. |  |  |  |  |  |
|  |  |  |  | Festivo | Permite saber si la fecha consultada es festivo. |  |  |  |  |  |
|  |  |  |  | SedeFestivo | Permite saber si la sede abre en ese festivo; si no abre, no queda ningún espacio disponible. |  |  |  |  |  |
|  |  |  |  | PeriodoCierre | Permite descontar las horas de esa fecha en las que la sede permanece cerrada. |  |  |  |  |  |
| Barbero | Consultar las citas de un barbero para una fecha | Permite consultar todas las citas agrupadas en la agenda de un barbero para una fecha puntual | Agenda |  |  |  |  |  | Citas de agenda consultadas |  |
| Cliente | Consultar las citas de un barbero para una fecha | Permite consultar todas las citas agrupadas en la agenda de un barbero para una fecha puntual | Agenda |  |  |  |  |  | Citas de agenda consultadas |  |
| Sistema | Consultar las citas de un barbero en un rango de fecha y hora | Permite consultar las citas no canceladas de un barbero dentro de un rango de fecha y hora, recorriendo todas las agendas comprendidas en ese rango | Agenda | Cita | Permite conocer las horas de las citas de cada agenda comprendida en el rango. |  |  |  | Citas de barbero por rango consultadas |  |
|  |  |  |  | Estado | Permite descartar las citas canceladas. |  |  |  |  |  |

### Políticas

| Número Política | Descripción Política | Objeto Responsable |
|---|---|---|
| P-AGE-0001 | Asegurar que no exista ya una agenda para ese mismo horario de barbero y esa misma fecha | [Agenda](#agenda) |
| P-AGE-0002 | Asegurar que el barbero esté vigente antes de abrirle una nueva agenda | [Barbero](#barbero) |
| P-AGE-0003 | Al consultar la disponibilidad de una agenda, descontar de la jornada del barbero las horas que ya tienen una cita, las que están cubiertas por un bloqueo del barbero y las que están cubiertas por un periodo de cierre de la sede del horario del barbero. Si la fecha es un festivo en el que la sede no tiene registrada la apertura, no queda ningún espacio disponible | [Agenda](#agenda) |
| P-AGE-0004 | Asegurar que no exista otro objeto de tipo Agenda con el mismo id; el id solo debe ser único entre los objetos de tipo Agenda | [Agenda](#agenda) |
| P-AGE-0005 | Asegurar que no se abra una agenda cuando toda la jornada del horario del barbero en esa fecha queda dentro de un periodo de cierre de la sede de ese horario; si el cierre cubre solo una parte de la jornada, la agenda se abre normalmente y las horas cerradas quedan sin disponibilidad. Si el periodo de cierre se registra después de que la agenda ya se creó, la agenda se conserva y las citas en estado Agendada que se crucen con el cierre se cancelan (P-PCI-0006) | [PeriodoCierre](#periodocierre) |
| P-AGE-0006 | Asegurar que no se abra una agenda en una fecha que es festivo si la sede del horario del barbero no tiene registrada la apertura de ese festivo; por defecto las sedes no abren los festivos y, cuando abren, atienden con su horario habitual del día de la semana en que cae el festivo | [SedeFestivo](#sedefestivo) |
| P-AGE-0007 | Asegurar que la fecha de la agenda esté entre el día de hoy y hoy + 15 días y que caiga en el mismo día de la semana del horario del barbero. Todos los días el sistema crea las agendas que falten en ese rango para cada horario vigente de los barberos vigentes, de modo que los clientes siempre tengan agendas disponibles para los próximos 15 días | [Agenda](#agenda) |

[↑ Volver al índice](#objetos-de-dominio)

---

## Cita

**Descripción:** Representa la reserva de un cliente con un barbero para un fecha y hora puntual, con los servicios pedidos, su estado, y lo que realmente ocurrió (atención, tardanzas, inasistencia).  
**Línea de vida:** 7

### Muestreo de datos

- **id**: Representa un identificador que hará unico cada objeto de dominio de este tipo, no se puede repetir
- **cliente**: Representa a cuál cliente le pertenece esta cita (referencia a [Cliente](#cliente))
- **agenda**: Referencia en cual agenda va a estar esta cita (referencia a [Agenda](#agenda))
- **estado**: Representa en qué estado se encuentra esta cita puntual: agendada, finalizada, cancelada, con tardanza del cliente o del barbero, o inasistencia (referencia a [Estado](#estado))
- **horaInicio**: Representa la hora en la que se va a realizar la cita al cliente
- **horaFinEstimada**: Representa la hora en la que se espera que termine la cita, sumando horaInicio más la duración total de los servicios pedidos. Es un dato calculado
- **porcentajeDescuento**: Representa el descuento que el barbero le concede al cliente por haberse demorado en atenderlo; solo se descuenta del precioTotal cuando la cita queda en el estado "El barbero se demoro"
- **multa**: Representa el precio de sancion, en caso de que el cliente se demore
- **tiempoEspera**: Representa la cantidad de minutos en el que el barbero puede esperar a un cliente, después de este tiempo de espera se le hace una sanción por retraso. Si el barbero se pasa de este tiempo se le da el descuento al cliente
- **precioTotal**: Representa cuánto debe pagar el cliente por los servicios de esta cita: la suma del precioServicio de todos sus CitaServicio, al que solo se le aplica el porcentajeDescuento cuando la cita quedó en el estado "El barbero se demoro"
- **Combinación única**: Combinación única que indica que un mismo cliente no puede tener dos citas en la misma agenda a la misma hora de inicio: si la cancela, la conserva y puede reagendarla. Que dos clientes no se crucen lo controla P-CIT-0003

| id | cliente | agenda | estado | horaInicio | horaFinEstimada | porcentajeDescuento | multa | tiempoEspera | precioTotal | Combinación única |
|---|---|---|---|---|---|---|---|---|---|---|
| 1 | +57-3234528921 | +57-3245627890-BarberClub Colombia-Sede Poblado-Lunes-09:00-19:00-12/11/2023-1/01/1000-10:00-16:00-03/05/2025-1/01/1000-05/10/2026 | Agendada | 10:00 | 11:00 | 10 | 10000 | 10 | 22.000 | +57-3234528921-+57-3245627890-BarberClub Colombia-Sede Poblado-Lunes-09:00-19:00-12/11/2023-1/01/1000-10:00-16:00-03/05/2025-1/01/1000-05/10/2026-10:00 |
| 2 | +57-3161657782 | +57-3124518923-BarberClub Colombia-Sede Poblado-Martes-09:00-19:00-12/11/2023-1/01/1000-09:00-15:00-02/03/2025-1/01/1000-10/03/2026 | Finalizada | 09:30 | 09:45 | 10 | 10000 | 10 | 12.000 | +57-3161657782-+57-3124518923-BarberClub Colombia-Sede Poblado-Martes-09:00-19:00-12/11/2023-1/01/1000-09:00-15:00-02/03/2025-1/01/1000-10/03/2026-09:30 |
| 3 | +57-3119884321 | +57-3214533321-BarberClub Colombia-Sede Poblado-Jueves-09:00-19:00-12/11/2023-1/01/1000-13:00-19:00-22/12/2022-1/01/1000-14/05/2026 | El cliente se demoro | 13:00 | 13:20 | 10 | 10000 | 10 | 15.000 | +57-3119884321-+57-3214533321-BarberClub Colombia-Sede Poblado-Jueves-09:00-19:00-12/11/2023-1/01/1000-13:00-19:00-22/12/2022-1/01/1000-14/05/2026-13:00 |
| 4 | +58-4127359182 | +91-9876543210-BarberClub Colombia-Sede Poblado-Sábado-08:00-21:00-12/12/2024-1/01/1000-08:00-14:00-15/09/2025-01/01/2026-22/11/2025 | Inasistencia del cliente | 13:00 | 13:50 | 10 | 12000 | 15 | 35.000 | +58-4127359182-+91-9876543210-BarberClub Colombia-Sede Poblado-Sábado-08:00-21:00-12/12/2024-1/01/1000-08:00-14:00-15/09/2025-01/01/2026-22/11/2025-13:00 |
| 5 | +58-4127359182 | +57-3214533321-BarberClub Colombia-Sede Poblado-Jueves-09:00-19:00-12/11/2023-1/01/1000-13:00-19:00-22/12/2022-1/01/1000-06/08/2026 | El barbero se demoro | 18:00 | 18:20 | 10 | 10000 | 10 | 10.800 | +58-4127359182-+57-3214533321-BarberClub Colombia-Sede Poblado-Jueves-09:00-19:00-12/11/2023-1/01/1000-13:00-19:00-22/12/2022-1/01/1000-06/08/2026-18:00 |
| 6 | +57-3005544332 | +57-3245627890-BarberClub Colombia-Sede Poblado-Lunes-09:00-19:00-12/11/2023-1/01/1000-10:00-16:00-03/05/2025-1/01/1000-01/06/2026 | Inasistencia del cliente | 10:00 | 11:00 | 10 | 12000 | 15 | 22.000 | +57-3005544332-+57-3245627890-BarberClub Colombia-Sede Poblado-Lunes-09:00-19:00-12/11/2023-1/01/1000-10:00-16:00-03/05/2025-1/01/1000-01/06/2026-10:00 |
| 7 | +57-3005544332 | +57-3124518923-BarberClub Colombia-Sede Poblado-Martes-09:00-19:00-12/11/2023-1/01/1000-09:00-15:00-02/03/2025-1/01/1000-16/06/2026 | Inasistencia del cliente | 09:00 | 09:15 | 5 | 10000 | 10 | 12.000 | +57-3005544332-+57-3124518923-BarberClub Colombia-Sede Poblado-Martes-09:00-19:00-12/11/2023-1/01/1000-09:00-15:00-02/03/2025-1/01/1000-16/06/2026-09:00 |
| 8 | +57-3005544332 | +57-3214533321-BarberClub Colombia-Sede Poblado-Jueves-09:00-19:00-12/11/2023-1/01/1000-13:00-19:00-22/12/2022-1/01/1000-02/07/2026 | Inasistencia del cliente | 15:00 | 15:20 | 15 | 10000 | 10 | 15.000 | +57-3005544332-+57-3214533321-BarberClub Colombia-Sede Poblado-Jueves-09:00-19:00-12/11/2023-1/01/1000-13:00-19:00-22/12/2022-1/01/1000-02/07/2026-15:00 |
| 9 | +57-3161657782 | +57-3214533321-BarberClub Colombia-Sede Poblado-Jueves-09:00-19:00-12/11/2023-1/01/1000-13:00-19:00-22/12/2022-1/01/1000-14/05/2026 | Finalizada | 13:30 | 14:10 | 0 | 10000 | 15 | 27.000 | +57-3161657782-+57-3214533321-BarberClub Colombia-Sede Poblado-Jueves-09:00-19:00-12/11/2023-1/01/1000-13:00-19:00-22/12/2022-1/01/1000-14/05/2026-13:30 |

**Combinaciones únicas y datos tomados de otros objetos:**

- **cliente**: referencia a [Cliente](#cliente); en los datos de ejemplo se muestra con su combinación única.
- **agenda**: referencia a [Agenda](#agenda); en los datos de ejemplo se muestra con su combinación única.
- **estado**: referencia a [Estado](#estado); en los datos de ejemplo se muestra con su combinación única.
- **horaFinEstimada**: se calcula como la horaInicio de la cita más la suma de duracionEnHorasElServicio, duracionEnMinutosElServicio y tiempoExtra de todos los [CitaServicio](#citaservicio) de la cita.
- **precioTotal**: se calcula como la suma del precioServicio de todos los [CitaServicio](#citaservicio) de la cita; si el estado de la cita es «El barbero se demoro», a esa suma se le descuenta el porcentajeDescuento.
- **Combinación única**: formada por `cliente` + `agenda` + `horaInicio`.

**Clasificación de las columnas del muestreo:**

- Corresponde al identificador unico del objeto de dominio: id
- Corresponde a las referencias de otros objetos de dominio: cliente, agenda, estado
- Corresponde a los datos calculados por el sistema: horaFinEstimada, precioTotal
- Corresponde a los datos que ingresa el usuario: horaInicio, porcentajeDescuento, multa, tiempoEspera
- Corresponde a la combinacion única: Combinación única

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Rendondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | pedirCita | reprogramarCita | reprogramarCita | cancelarCitaPorCliente | cancelarCitaPorCliente | cancelarCitaPorBarbero | cancelarCitaPorBarbero | registrarInasistenciaCliente | registrarInasistenciaCliente | registrarDemoraCliente | registrarDemoraCliente | finalizarCita | finalizarCita | registrarNoPagoCita | registrarNoPagoCita | cancelarCitasPorVeto | cancelarCitasPorVeto | reagendarCita | reagendarCita |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| id | Representa un identificador que hará unico cada objeto de dominio de este tipo, no se puede repetir | Si | Identificador único universal | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No | No | No aplica | No | No | No | UUID vacio | Si | No requerido | Requerido | No modificable | Requerido | No modificable | Requerido | No modificable | Requerido | No modificable | Requerido | No modificable | Requerido | No modificable | Requerido | No modificable | No requerido | No modificable | Requerido | No modificable |
| cliente | Representa a cuál cliente le pertenece esta cita | No | [Cliente](#cliente) | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | Se muestra el nombre completo del cliente, no una combinación única, únicamente para lectura humana en el muestreo | No | No aplica | No aplica | No aplica | No aplica | No | UUID vacio | No | Requerido | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | Requerido | No modificable | No requerido | No modificable |
| agenda | Referencia en cual agenda va a estar esta cita | No | [Agenda](#agenda) | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | Aplican las reglas del objeto referenciado | No | No aplica | No aplica | No aplica | No aplica | No | UUID vacio | No | Requerido | No requerido | Modificable | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable |
| estado | Representa en qué estado se encuentra esta cita puntual: agendada, finalizada, cancelada, con tardanza del cliente o del barbero, o inasistencia | No | [Estado](#estado) | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | Aplican las reglas del objeto referenciado | No | No aplica | No aplica | No aplica | No aplica | No | UUID vacio | No | No requerido | No requerido | No modificable | No requerido | Modificable | No requerido | Modificable | No requerido | Modificable | No requerido | Modificable | No requerido | Modificable | No requerido | Modificable | No requerido | Modificable | No requerido | Modificable |
| horaInicio | Representa la hora en la que se va a realizar la cita al cliente | No | Hora | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | Debe de estar dentro del horario de trabajo del barbero | No | No aplica | No aplica | No aplica | No aplica | No | 00:00 | No | Requerido | Requerido | Modificable | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable |
| horaFinEstimada | Representa la hora en la que se espera que termine la cita, sumando horaInicio más la duración total de los servicios pedidos. Es un dato calculado | No | Hora | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | horaInicio + duracion (en minutos) y debe de estar dentro del horario de trabajo del barbero  | Si | No aplica | No aplica | No aplica | No aplica | No | 00:00 | No | No requerido | No requerido | Modificable | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No requerido | Modificable |
| porcentajeDescuento | Representa el descuento que el barbero le concede al cliente por haberse demorado en atenderlo; solo se descuenta del precioTotal cuando la cita queda en el estado "El barbero se demoro" | No | Entero | Si | No aplica | No aplica | No aplica | No aplica | 0 | 100 | No aplica | Lo define el barbero y queda congelado en la cita; solo se descuenta del precioTotal cuando la cita queda en el estado "El barbero se demoro" | No | No aplica | No aplica | No aplica | No aplica | No | 0 | No | No requerido | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No requerido | Modificable |
| multa | Representa el precio de sancion, en caso de que el cliente se demore | No | Entero | Si | No aplica | No aplica | No aplica | No aplica | 0 | 100000 | No aplica | Lo define el barbero al momento de agendar la cita y queda congelado en ella; es el valor que se le cobra al cliente si su tardanza supera el tiempoEspera de esta misma cita | No | No aplica | No aplica | No aplica | No aplica | No | 0 | No | No requerido | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No requerido | Modificable |
| tiempoEspera | Representa la cantidad de minutos en el que el barbero puede esperar a un cliente, después de este tiempo de espera se le hace una sanción por retraso. Si el barbero se pasa de este tiempo se le da el descuento al cliente | No | Entero | Si | No aplica | No aplica | No aplica | No aplica | 0 | 60 | No aplica | Es el mismo margen para las dos partes: si el cliente lo supera se le genera una Multa de tipo Tardanza por el valor de multa, y si el barbero lo supera se le aplica al cliente el porcentajeDescuento sobre el precioTotal | No | No aplica | No aplica | No aplica | No aplica | No | 0 | No | No requerido | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No requerido | Modificable |
| precioTotal | Representa cuánto debe pagar el cliente por los servicios de esta cita: la suma del precioServicio de todos sus CitaServicio, al que solo se le aplica el porcentajeDescuento cuando la cita quedó en el estado "El barbero se demoro" | No | Entero | Si | No aplica | No aplica | No aplica | No aplica | 0 | 3000000 | No aplica | Suma del precioServicio de todos los CitaServicio de esta cita. Si el estado de la cita es "El barbero se demoro" se le resta el porcentajeDescuento; en cualquier otro estado se cobra la suma completa | Si | No aplica | No aplica | No aplica | No aplica | No | 0 | No | No requerido | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No requerido | No modificable | No requerido | Modificable |

| Nombre combinación única | Descripción | Atributos involucrados |
|---|---|---|
| Combinación única | Combinación única que indica que un mismo cliente no puede tener dos citas en la misma agenda a la misma hora de inicio: si la cancela, la conserva y puede reagendarla. Que dos clientes no se crucen lo controla P-CIT-0003 | cliente, agenda, horaInicio |

| Responsabilidad | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Salida / Descripción | Políticas (Reglas de Negocio) / Política | Políticas (Reglas de Negocio) / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |
|---|---|---|---|---|---|---|---|---|---|---|
| pedirCita | Comando que permite a un cliente solicitar una cita con un barbero, en una fecha y hora puntual, con uno o más servicios | datos{cliente, agenda, horaInicio, servicios} | Cita | Contiene la información requerida para agendar una nueva cita con un barbero | Cita | Contiene la información de la cita agendada | P-CIT-0001 | Asegurar que los datos requeridos (agenda, hora de inicio, servicios solicitados) sean válidos en tipo de dato, obligatoriedad, formato y rango | Generar una excepción indicándole al cliente que los datos de la cita no cumplen con las reglas definidas | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0002 | Asegurar que el cliente no tenga ninguna multa sin pagar (pagada = no) en la barbería donde quiere agendar: se revisan las multas originadas en citas de cualquiera de las sedes de la barbería a la que pertenece la sede de la agenda solicitada, no solo en esa sede. Las multas ya pagadas y las multas de otras barberías no impiden agendar | Generar una excepción indicándole al cliente que no puede agendar en ninguna sede de esta barbería mientras tenga una multa sin pagar en ella | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0003 | Asegurar que la cita quepa dentro del horario de trabajo del barbero y que no se cruce con ninguna otra cita activa del mismo barbero en esa fecha, sea del cliente que sea, revisando todas las agendas del barbero de ese día. No cuentan las citas en estado Cancelada por el cliente, Cancelada por el barbero, Cancelación o Cancelación por veto. Dos citas se cruzan cuando una empieza antes de que termine la otra y termina después de que la otra empiece; una cita que empieza justo cuando otra termina no se cruza. Al reprogramar o reagendar no se cuenta la misma cita que se está moviendo o reactivando | Generar una excepción indicándole al cliente que el barbero ya tiene una cita entre esas horas y que debe elegir otra hora | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0030 | Asegurar que el cliente no tenga ya una cita, en cualquier estado, en esa misma agenda y a esa misma hora de inicio: un cliente tiene una sola cita por agenda y hora. Si la canceló él mismo, debe reagendarla en lugar de pedir una nueva; si la canceló el barbero o el sistema, debe elegir otra hora | Generar una excepción indicándole al cliente que ya tiene una cita en esa agenda y a esa hora: si la canceló él, debe reagendarla, y si la canceló el barbero o el sistema, debe elegir otra hora | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0012 | Asegurar que la hora solicitada no caiga dentro de ningún bloqueo del barbero, ni que la cita se extienda sobre uno | Generar una excepción indicándole al cliente que la hora solicitada cae dentro de un bloqueo del barbero | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0026 | Asegurar que la cita no se cruce con ningún periodo de cierre de la sede de la agenda solicitada. La cita ocupa desde la fecha de la agenda con su horaInicio hasta esa misma fecha con su horaFinEstimada, y se cruza con un periodo de cierre cuando empieza antes de la fecha y hora final del cierre y termina después de su fecha y hora de inicio. Una cita que termina justo cuando empieza el cierre, o que empieza justo cuando termina, no se cruza. Solo cuentan los periodos de cierre de esa sede; los de otras sedes de la misma barbería no impiden agendar | Generar una excepción indicándole al cliente que la sede permanece cerrada en el horario solicitado, informándole el periodo de cierre y su motivo | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0029 | Asegurar que la cita no se agende en una fecha festiva si la sede no tiene registrada la apertura de ese festivo; por defecto las sedes no atienden los festivos. Si la sede abre el festivo, la cita debe caber en su horario habitual de ese día de la semana. | Generar una excepción indicándole al cliente que la sede no atiende en esa fecha porque es festivo, informándole el nombre del festivo | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0004 | Asegurar que cada servicio solicitado sea un servicio vigente (BarberoServicio vigente) del barbero dueño del horario de la agenda de la cita; así todos los servicios de la cita pertenecen al único barbero que la atiende | Generar una excepción indicándole al cliente que alguno de los servicios pedidos no está habilitado para ese barbero | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0005 | Asegurar que la cita no se solicite para una fecha y hora que ya pasaron, es decir que la cita no se puede solicitar en un tiempo pasado | Generar una excepción indicándole al cliente que no puede agendar una cita para una fecha y hora que ya pasaron | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0015 | Asegurar que la cita se agende como máximo hasta 15 días después del día actual: se permite agendar desde hoy hasta hoy + 15 días, y una fecha posterior a ese límite no se puede agendar | Generar una excepción indicándole al cliente que solo puede agendar hasta 15 días después del día actual | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0025 | Asignar a la cita que se está pidiendo el estado Agendada, tomándolo del catálogo de estados ya existente | Si el estado Agendada no existe en el catálogo, generar una excepción indicándole al cliente que no es posible agendar la cita en este momento porque no se pudo asignar su estado inicial | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0006 | Congelar en la cita el valor de multa, el tiempoEspera y el porcentajeDescuento en el momento de agendarla, para que un cambio posterior no altere citas ya registradas | Si los valores de multa, tiempoEspera y porcentajeDescuento no se pueden congelar, no registrar la cita | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0024 | Asegurar que no exista otro objeto de tipo Cita con el mismo id; el id solo debe ser único entre los objetos de tipo Cita | Generar un nuevo id para el Cita y volver a validar que no lo tenga otro Cita | Continuar operación |
| reprogramarCita | Permite a un cliente cambiar la fecha o la hora de inicio de una cita que aún no ha ocurrido, conservando el mismo barbero y los mismos servicios | id | UUID | Corresponde al identificador de la cita que se va a reprogramar | Cita | Contiene la información de la cita reprogramada | P-CIT-0013 | Asegurar que exista la cita con el id enviado | Informar con un mensaje que no existe una cita con el identificador enviado y por lo tanto no es posible llevar a cabo la operación | Detener operación |
|  |  | datos{fecha, horaInicio} | Fecha, hora | Contiene la nueva fecha y la nueva hora de inicio de la cita; el barbero no cambia, el sistema ubica la agenda de ese mismo barbero para la nueva fecha |  |  | P-CIT-0032 | Asegurar que la cita le pertenezca al cliente que hace la operación; un cliente solo puede reprogramar, cancelar o reagendar sus propias citas | Generar una excepción indicándole al cliente que solo puede reprogramar sus propias citas | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0014 | Asegurar que la cita se encuentre en estado Agendada | Generar una excepción indicándole al cliente que la cita no se puede reprogramar porque no se encuentra en estado Agendada | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0011 | Asegurar que, al reprogramar, el barbero de la cita tenga agenda en la nueva fecha: la cita solo puede cambiar de fecha o de hora de inicio, nunca de barbero, por lo que la nueva agenda es la de ese mismo barbero para esa fecha. Si el barbero no tiene agenda ese día (no trabaja ese día de la semana, la sede permanece cerrada durante toda su jornada o es un festivo en el que la sede no abre), no se puede reprogramar para esa fecha | Generar una excepción indicándole al cliente que su barbero no tiene agenda en la nueva fecha, por lo que la cita no se puede reprogramar para ese día | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0002 | Asegurar que el cliente no tenga ninguna multa sin pagar (pagada = no) en la barbería donde quiere agendar: se revisan las multas originadas en citas de cualquiera de las sedes de la barbería a la que pertenece la sede de la agenda solicitada, no solo en esa sede. Las multas ya pagadas y las multas de otras barberías no impiden agendar | Generar una excepción indicándole al cliente que no puede reprogramar la cita a una sede de una barbería donde tiene multas sin pagar | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0003 | Asegurar que la cita quepa dentro del horario de trabajo del barbero y que no se cruce con ninguna otra cita activa del mismo barbero en esa fecha, sea del cliente que sea, revisando todas las agendas del barbero de ese día. No cuentan las citas en estado Cancelada por el cliente, Cancelada por el barbero, Cancelación o Cancelación por veto. Dos citas se cruzan cuando una empieza antes de que termine la otra y termina después de que la otra empiece; una cita que empieza justo cuando otra termina no se cruza. Al reprogramar o reagendar no se cuenta la misma cita que se está moviendo o reactivando | Generar una excepción indicándole al cliente que el barbero ya tiene una cita entre esas horas y que debe elegir otra hora | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0030 | Asegurar que el cliente no tenga ya una cita, en cualquier estado, en esa misma agenda y a esa misma hora de inicio: un cliente tiene una sola cita por agenda y hora. Si la canceló él mismo, debe reagendarla en lugar de pedir una nueva; si la canceló el barbero o el sistema, debe elegir otra hora | Generar una excepción indicándole al cliente que ya tiene una cita en esa agenda y a esa hora: si la canceló él, debe reagendarla, y si la canceló el barbero o el sistema, debe elegir otra hora | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0012 | Asegurar que la hora solicitada no caiga dentro de ningún bloqueo del barbero, ni que la cita se extienda sobre uno | Generar una excepción indicándole al cliente que la hora solicitada cae dentro de un bloqueo del barbero | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0026 | Asegurar que la cita no se cruce con ningún periodo de cierre de la sede de la agenda solicitada. La cita ocupa desde la fecha de la agenda con su horaInicio hasta esa misma fecha con su horaFinEstimada, y se cruza con un periodo de cierre cuando empieza antes de la fecha y hora final del cierre y termina después de su fecha y hora de inicio. Una cita que termina justo cuando empieza el cierre, o que empieza justo cuando termina, no se cruza. Solo cuentan los periodos de cierre de esa sede; los de otras sedes de la misma barbería no impiden agendar | Generar una excepción indicándole al cliente que la sede permanece cerrada en el horario solicitado, informándole el periodo de cierre y su motivo | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0029 | Asegurar que la cita no se agende en una fecha festiva si la sede no tiene registrada la apertura de ese festivo; por defecto las sedes no atienden los festivos. Si la sede abre el festivo, la cita debe caber en su horario habitual de ese día de la semana. | Generar una excepción indicándole al cliente que la sede no atiende en esa fecha porque es festivo, informándole el nombre del festivo | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0004 | Asegurar que cada servicio solicitado sea un servicio vigente (BarberoServicio vigente) del barbero dueño del horario de la agenda de la cita; así todos los servicios de la cita pertenecen al único barbero que la atiende | Generar una excepción indicándole al cliente que alguno de los servicios de la cita ya no está habilitado para ese barbero | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0015 | Asegurar que la cita se agende como máximo hasta 15 días después del día actual: se permite agendar desde hoy hasta hoy + 15 días, y una fecha posterior a ese límite no se puede agendar | Generar una excepción indicándole al cliente que solo puede reprogramar hasta 15 días después del día actual | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0005 | Asegurar que la cita no se solicite para una fecha y hora que ya pasaron, es decir que la cita no se puede solicitar en un tiempo pasado | Generar una excepción indicándole al cliente que no puede agendar una cita para una fecha y hora que ya pasaron | Detener operación |
| cancelarCitaPorCliente | Permite a un cliente cancelar una cita antes de que ocurra | id | UUID | Corresponde al identificador de la cita que el cliente va a cancelar | Cita | Contiene la cita en el estado Cancelada por el cliente | P-CIT-0013 | Asegurar que exista la cita con el id enviado | Informar con un mensaje que no existe una cita con el identificador enviado y por lo tanto no es posible llevar a cabo la operación | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0032 | Asegurar que la cita le pertenezca al cliente que hace la operación; un cliente solo puede reprogramar, cancelar o reagendar sus propias citas | Generar una excepción indicándole al cliente que solo puede cancelar sus propias citas | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0014 | Asegurar que la cita se encuentre en estado Agendada | Generar una excepción indicándole al cliente que la cita no se puede cancelar porque no se encuentra en estado Agendada | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0009 | El cliente tiene hasta 2 horas antes de la horaInicio de la cita para cancelarla; cuando faltan menos de 2 horas ya no se le permite cancelar | Generar una excepción indicándole al cliente que ya no puede cancelar la cita porque faltan menos de 2 horas para su horaInicio | Detener operación |
| cancelarCitaPorBarbero | Permite a un barbero cancelar una cita antes de que ocurra | id | UUID | Corresponde al identificador de la cita que el barbero va a cancelar | Cita | Contiene la cita en el estado Cancelada por el barbero | P-CIT-0013 | Asegurar que exista la cita con el id enviado | Informar con un mensaje que no existe una cita con el identificador enviado y por lo tanto no es posible llevar a cabo la operación | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0027 | Asegurar que el barbero que cambia el estado de la cita o la cancela sea el barbero de la cita, es decir, el dueño del horario de la agenda en la que está; en una cita solo participan un barbero y un cliente | Generar una excepción indicándole al barbero que solo puede cancelar las citas que él atiende | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0014 | Asegurar que la cita se encuentre en estado Agendada | Generar una excepción indicándole al barbero que la cita no se puede cancelar porque no se encuentra en estado Agendada | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0010 | El barbero tiene hasta 2 horas antes de la horaInicio de la cita para cancelarla; cuando faltan menos de 2 horas ya no se le permite cancelar | Generar una excepción indicándole al barbero que ya no puede cancelar la cita porque faltan menos de 2 horas para su horaInicio | Detener operación |
| registrarInasistenciaCliente | Permite al barbero de la cita indicar que el cliente nunca llegó, después de la hora estimada de finalización de la cita; se le genera una multa de tipo Inasistencia | id | UUID | Corresponde al identificador de la cita a la que el cliente no asistió | Cita | Contiene la cita en el estado Inasistencia del cliente | P-CIT-0013 | Asegurar que exista la cita con el id enviado | Informar con un mensaje que no existe una cita con el identificador enviado y por lo tanto no es posible llevar a cabo la operación | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0027 | Asegurar que el barbero que cambia el estado de la cita o la cancela sea el barbero de la cita, es decir, el dueño del horario de la agenda en la que está; en una cita solo participan un barbero y un cliente | Generar una excepción indicándole al barbero que solo puede cambiar el estado de las citas que él atiende | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0014 | Asegurar que la cita se encuentre en estado Agendada | Generar una excepción indicándole al barbero que no se puede registrar la inasistencia porque la cita no se encuentra en estado Agendada | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0016 | Asegurar que el cambio de estado de la cita se realice en la misma fecha de la cita (fecha de su agenda) | Generar una excepción indicándole al barbero que el estado solo se puede cambiar el mismo día de la cita | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0021 | Asegurar que ya haya pasado la horaFinEstimada de la cita para registrar la inasistencia del cliente; mientras la cita no haya terminado según su hora estimada, el cliente todavía puede llegar | Generar una excepción indicándole al barbero que todavía no ha pasado la hora estimada de finalización de la cita | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0007 | Cuando se registre la inasistencia del cliente, generar una Multa de tipo Inasistencia por el precioTotal de la cita | Si la multa no se puede generar o las citas futuras del cliente no se pueden cancelar por veto, revertir el cambio de estado e informar el error | Detener operación |
| registrarDemoraCliente | Permite al barbero de la cita indicar que el cliente llegó después de la horaInicio más el tiempoEspera de la cita; se le genera una multa de tipo Tardanza | id | UUID | Corresponde al identificador de la cita | Cita | Contiene la cita en el estado El cliente se demoro | P-CIT-0013 | Asegurar que exista la cita con el id enviado | Informar con un mensaje que no existe una cita con el identificador enviado | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0027 | Asegurar que el barbero que cambia el estado de la cita o la cancela sea el barbero de la cita, es decir, el dueño del horario de la agenda en la que está; en una cita solo participan un barbero y un cliente | Generar una excepción indicándole al barbero que solo puede cambiar el estado de las citas que él atiende | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0014 | Asegurar que la cita se encuentre en estado Agendada | Generar una excepción indicándole al barbero que la cita no se encuentra en estado Agendada | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0016 | Asegurar que el cambio de estado de la cita se realice en la misma fecha de la cita (fecha de su agenda) | Generar una excepción indicándole al barbero que el estado solo se puede cambiar el mismo día de la cita | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0018 | Asegurar que ya haya pasado la horaInicio de la cita más su tiempoEspera | Generar una excepción indicándole al barbero que todavía no ha pasado la hora de inicio más el tiempo de espera de la cita | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0023 | Cuando la cita pase al estado El cliente se demoro, generar una Multa de tipo Tardanza por el valor de multa de esa misma cita; si después el cliente no paga los servicios, se registra además el No pagado | Si la multa no se puede generar o las citas futuras del cliente no se pueden cancelar por veto, revertir el cambio de estado e informar el error | Detener operación |
| finalizarCita | Permite al barbero indicar que atendió al cliente y que este pagó el servicio | id | UUID | Corresponde al identificador de la cita | Cita | Contiene la cita en el estado Finalizada | P-CIT-0013 | Asegurar que exista la cita con el id enviado | Informar con un mensaje que no existe una cita con el identificador enviado | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0027 | Asegurar que el barbero que cambia el estado de la cita o la cancela sea el barbero de la cita, es decir, el dueño del horario de la agenda en la que está; en una cita solo participan un barbero y un cliente | Generar una excepción indicándole al barbero que solo puede cambiar el estado de las citas que él atiende | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0019 | Asegurar que la cita se encuentre en estado Agendada, El cliente se demoro o El barbero se demoro para poder finalizarla | Generar una excepción indicándole al barbero que la cita no se encuentra en un estado que se pueda finalizar | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0016 | Asegurar que el cambio de estado de la cita se realice en la misma fecha de la cita (fecha de su agenda) | Generar una excepción indicándole al barbero que el estado solo se puede cambiar el mismo día de la cita | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0017 | Asegurar que ya haya pasado la horaInicio de la cita | Generar una excepción indicándole al barbero que todavía no ha llegado la hora de inicio de la cita | Detener operación |
| registrarNoPagoCita | Permite al barbero indicar que el cliente recibió la atención pero no pagó | id | UUID | Corresponde al identificador de la cita | Cita | Contiene la cita en el estado No pagado | P-CIT-0013 | Asegurar que exista la cita con el id enviado | Informar con un mensaje que no existe una cita con el identificador enviado | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0027 | Asegurar que el barbero que cambia el estado de la cita o la cancela sea el barbero de la cita, es decir, el dueño del horario de la agenda en la que está; en una cita solo participan un barbero y un cliente | Generar una excepción indicándole al barbero que solo puede cambiar el estado de las citas que él atiende | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0020 | Asegurar que la cita se encuentre en estado Agendada, El cliente se demoro o El barbero se demoro para poder registrarla como No pagado | Generar una excepción indicándole al barbero que la cita no se encuentra en un estado desde el que se pueda registrar el no pago | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0016 | Asegurar que el cambio de estado de la cita se realice en la misma fecha de la cita (fecha de su agenda) | Generar una excepción indicándole al barbero que el estado solo se puede cambiar el mismo día de la cita | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0017 | Asegurar que ya haya pasado la horaInicio de la cita | Generar una excepción indicándole al barbero que todavía no ha llegado la hora de inicio de la cita | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0022 | Cuando la cita pase al estado No pagado, generar una Multa de tipo No pagado por el precioTotal de la cita | Si la multa no se puede generar o las citas futuras del cliente no se pueden cancelar por veto, revertir el cambio de estado e informar el error | Detener operación |
| cancelarCitasPorVeto | Comando que permite al sistema cancelar las citas futuras que el cliente tiene agendadas en una barbería cuando se le impone una multa en ella | filtro{cliente, barberia} | Cita | Contiene el cliente multado y la barbería donde se originó la multa | Lista<Cita> | Contiene las citas del cliente que quedaron en el estado Cancelación por veto | P-CIT-0028 | Cuando al cliente se le imponga una multa, cancelar en el estado Cancelación por veto todas sus citas futuras en estado Agendada en cualquier sede de la barbería donde se originó la multa. Son futuras las citas cuya fecha de agenda y horaInicio son posteriores al momento actual. No aplica el límite de 2 horas para cancelar, las citas de otras barberías no se modifican y las citas canceladas no se restauran aunque el cliente pague la multa o el barbero la elimine | Si alguna de las citas no se puede cancelar, revertir toda la operación, incluida la multa, e informar el error | Detener operación |
| reagendarCita | Comando que permite a un cliente volver a activar una cita que él mismo canceló, en la misma agenda y a la misma hora, siempre que ese espacio siga libre; la cita vuelve al estado Agendada y no se crea una cita nueva | id | UUID | Corresponde al identificador de la cita cancelada que el cliente quiere volver a activar | Cita | Contiene la cita de nuevo en el estado Agendada | P-CIT-0013 | Asegurar que exista la cita con el id enviado | Informar con un mensaje que no existe una cita con el identificador enviado y por lo tanto no es posible llevar a cabo la operación | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0032 | Asegurar que la cita le pertenezca al cliente que hace la operación; un cliente solo puede reprogramar, cancelar o reagendar sus propias citas | Generar una excepción indicándole al cliente que solo puede reagendar sus propias citas | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0031 | Asegurar que la cita se encuentre en estado Cancelada por el cliente para poder reagendarla; las citas canceladas por el barbero, por cambio de políticas de la barbería o por veto no se pueden reagendar | Generar una excepción indicándole al cliente que solo se pueden reagendar las citas que él mismo canceló | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0005 | Asegurar que la cita no se solicite para una fecha y hora que ya pasaron, es decir que la cita no se puede solicitar en un tiempo pasado | Generar una excepción indicándole al cliente que la hora de la cita ya pasó y no se puede reagendar | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0002 | Asegurar que el cliente no tenga ninguna multa sin pagar (pagada = no) en la barbería donde quiere agendar: se revisan las multas originadas en citas de cualquiera de las sedes de la barbería a la que pertenece la sede de la agenda solicitada, no solo en esa sede. Las multas ya pagadas y las multas de otras barberías no impiden agendar | Generar una excepción indicándole al cliente que no puede reagendar en esta barbería mientras tenga una multa sin pagar en ella | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0003 | Asegurar que la cita quepa dentro del horario de trabajo del barbero y que no se cruce con ninguna otra cita activa del mismo barbero en esa fecha, sea del cliente que sea, revisando todas las agendas del barbero de ese día. No cuentan las citas en estado Cancelada por el cliente, Cancelada por el barbero, Cancelación o Cancelación por veto. Dos citas se cruzan cuando una empieza antes de que termine la otra y termina después de que la otra empiece; una cita que empieza justo cuando otra termina no se cruza. Al reprogramar o reagendar no se cuenta la misma cita que se está moviendo o reactivando | Generar una excepción indicándole al cliente que esa hora ya la tomó otra persona y que debe pedir una cita en otra hora | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0012 | Asegurar que la hora solicitada no caiga dentro de ningún bloqueo del barbero, ni que la cita se extienda sobre uno | Generar una excepción indicándole al cliente que la hora de la cita cae dentro de un bloqueo del barbero | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0026 | Asegurar que la cita no se cruce con ningún periodo de cierre de la sede de la agenda solicitada. La cita ocupa desde la fecha de la agenda con su horaInicio hasta esa misma fecha con su horaFinEstimada, y se cruza con un periodo de cierre cuando empieza antes de la fecha y hora final del cierre y termina después de su fecha y hora de inicio. Una cita que termina justo cuando empieza el cierre, o que empieza justo cuando termina, no se cruza. Solo cuentan los periodos de cierre de esa sede; los de otras sedes de la misma barbería no impiden agendar | Generar una excepción indicándole al cliente que la sede permanece cerrada en el horario de la cita, informándole el periodo de cierre y su motivo | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0029 | Asegurar que la cita no se agende en una fecha festiva si la sede no tiene registrada la apertura de ese festivo; por defecto las sedes no atienden los festivos. Si la sede abre el festivo, la cita debe caber en su horario habitual de ese día de la semana. | Generar una excepción indicándole al cliente que la sede no atiende en esa fecha porque es festivo, informándole el nombre del festivo | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0004 | Asegurar que cada servicio solicitado sea un servicio vigente (BarberoServicio vigente) del barbero dueño del horario de la agenda de la cita; así todos los servicios de la cita pertenecen al único barbero que la atiende | Generar una excepción indicándole al cliente que alguno de los servicios de la cita ya no está habilitado para ese barbero | Detener operación |
|  |  |  |  |  |  |  | P-CIT-0006 | Congelar en la cita el valor de multa, el tiempoEspera y el porcentajeDescuento en el momento de agendarla, para que un cambio posterior no altere citas ya registradas | Si los valores de multa, tiempoEspera y porcentajeDescuento vigentes no se pueden congelar de nuevo, no reagendar la cita | Detener operación |
|  |  |  |  |  |  |  | P-CSE-0001 | Asegurar que al crear el CitaServicio se copien el precio del Servicio y la duración y el tiempo extra del BarberoServicio vigentes en el momento de agendar la cita, para que un cambio posterior no altere la cita | Volver a copiar en cada servicio de la cita el precio del Servicio y la duración y el tiempo extra del BarberoServicio vigentes; si no se pueden copiar, no reagendar la cita | Detener operación |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Cliente | Pedir cita | Comando que permite a un cliente solicitar una cita con un barbero, en una fecha y hora puntual, con uno o más servicios | Cita | Agenda | Permite conocer la disponibilidad del barbero en la fecha solicitada. | P-CIT-0001 | Asegurar que los datos requeridos (agenda, hora de inicio, servicios solicitados) sean válidos en tipo de dato, obligatoriedad, formato y rango |  | Cita agendada |  |
|  |  |  |  | Bloqueo | Permite conocer los rangos de tiempo en los que el barbero no está disponible. | P-CIT-0002 | Asegurar que el cliente no tenga ninguna multa sin pagar (pagada = no) en la barbería donde quiere agendar: se revisan las multas originadas en citas de cualquiera de las sedes de la barbería a la que pertenece la sede de la agenda solicitada, no solo en esa sede. Las multas ya pagadas y las multas de otras barberías no impiden agendar |  |  |  |
|  |  |  |  | HorarioBarbero | Permite verificar que la hora solicitada esté dentro de la jornada del barbero. | P-CIT-0003 | Asegurar que la cita quepa dentro del horario de trabajo del barbero y que no se cruce con ninguna otra cita activa del mismo barbero en esa fecha, sea del cliente que sea, revisando todas las agendas del barbero de ese día. No cuentan las citas en estado Cancelada por el cliente, Cancelada por el barbero, Cancelación o Cancelación por veto. Dos citas se cruzan cuando una empieza antes de que termine la otra y termina después de que la otra empiece; una cita que empieza justo cuando otra termina no se cruza. Al reprogramar o reagendar no se cuenta la misma cita que se está moviendo o reactivando |  |  |  |
|  |  |  |  | BarberoServicio | Permite seleccionar los servicios de ese barbero y conocer su duración. | P-CIT-0012 | Asegurar que la hora solicitada no caiga dentro de ningún bloqueo del barbero, ni que la cita se extienda sobre uno |  |  |  |
|  |  |  |  | Estado | Permite asignar el estado inicial de la cita. | P-CIT-0026 | Asegurar que la cita no se cruce con ningún periodo de cierre de la sede de la agenda solicitada. La cita ocupa desde la fecha de la agenda con su horaInicio hasta esa misma fecha con su horaFinEstimada, y se cruza con un periodo de cierre cuando empieza antes de la fecha y hora final del cierre y termina después de su fecha y hora de inicio. Una cita que termina justo cuando empieza el cierre, o que empieza justo cuando termina, no se cruza. Solo cuentan los periodos de cierre de esa sede; los de otras sedes de la misma barbería no impiden agendar |  |  |  |
|  |  |  |  | Multa | Permite conocer las multas del cliente que siguen sin pagar (pagada = no) y la cita de donde salió cada una. | P-CIT-0004 | Asegurar que cada servicio solicitado sea un servicio vigente (BarberoServicio vigente) del barbero dueño del horario de la agenda de la cita; así todos los servicios de la cita pertenecen al único barbero que la atiende |  |  |  |
|  |  |  |  | HorarioSede | Permite conocer, a través del horario del barbero, la sede de la agenda solicitada y la sede de la cita donde se originó cada multa. | P-CIT-0005 | Asegurar que la cita no se solicite para una fecha y hora que ya pasaron, es decir que la cita no se puede solicitar en un tiempo pasado |  |  |  |
|  |  |  |  | Sede | Permite conocer la barbería de cada sede, para revisar solo las multas de la barbería donde se quiere agendar. | P-CIT-0015 | Asegurar que la cita se agende como máximo hasta 15 días después del día actual: se permite agendar desde hoy hasta hoy + 15 días, y una fecha posterior a ese límite no se puede agendar |  |  |  |
|  |  |  |  | Festivo | Permite saber si la fecha de la agenda solicitada es festivo. | P-CIT-0025 | Asignar a la cita que se está pidiendo el estado Agendada, tomándolo del catálogo de estados ya existente |  |  |  |
|  |  |  |  | SedeFestivo | Permite saber si la sede de la agenda abre en ese festivo; si no abre, no se puede agendar. | P-CIT-0029 | Asegurar que la cita no se agende en una fecha festiva si la sede no tiene registrada la apertura de ese festivo; por defecto las sedes no atienden los festivos. Si la sede abre el festivo, la cita debe caber en su horario habitual de ese día de la semana. |  |  |  |
|  |  |  |  | PeriodoCierre | Permite verificar que la cita no se cruce con un periodo en el que la sede de la agenda permanece cerrada. | P-CIT-0030 | Asegurar que el cliente no tenga ya una cita, en cualquier estado, en esa misma agenda y a esa misma hora de inicio: un cliente tiene una sola cita por agenda y hora. Si la canceló él mismo, debe reagendarla en lugar de pedir una nueva; si la canceló el barbero o el sistema, debe elegir otra hora |  |  |  |
|  |  |  |  |  |  | P-CIT-0006 | Congelar en la cita el valor de multa, el tiempoEspera y el porcentajeDescuento en el momento de agendarla, para que un cambio posterior no altere citas ya registradas |  |  |  |
| Cliente | Reprogramar la cita | Permite a un cliente cambiar la fecha o la hora de inicio de una cita que aún no ha ocurrido, conservando el mismo barbero y los mismos servicios | Cita | Agenda | Permite conocer la disponibilidad del barbero en la nueva fecha. | P-CIT-0014 | Asegurar que la cita se encuentre en estado Agendada |  | Cita reprogramada |  |
|  |  |  |  | Bloqueo | Permite verificar que la nueva hora no caiga en un bloqueo del barbero. | P-CIT-0011 | Asegurar que, al reprogramar, el barbero de la cita tenga agenda en la nueva fecha: la cita solo puede cambiar de fecha o de hora de inicio, nunca de barbero, por lo que la nueva agenda es la de ese mismo barbero para esa fecha. Si el barbero no tiene agenda ese día (no trabaja ese día de la semana, la sede permanece cerrada durante toda su jornada o es un festivo en el que la sede no abre), no se puede reprogramar para esa fecha |  |  |  |
|  |  |  |  | HorarioBarbero | Permite ubicar, a partir del barbero de la cita, la agenda de ese mismo barbero en la nueva fecha. | P-CIT-0002 | Asegurar que el cliente no tenga ninguna multa sin pagar (pagada = no) en la barbería donde quiere agendar: se revisan las multas originadas en citas de cualquiera de las sedes de la barbería a la que pertenece la sede de la agenda solicitada, no solo en esa sede. Las multas ya pagadas y las multas de otras barberías no impiden agendar |  |  |  |
|  |  |  |  | Estado | Permite verificar que la cita se encuentre en estado Agendada antes de reprogramarla. | P-CIT-0003 | Asegurar que la cita quepa dentro del horario de trabajo del barbero y que no se cruce con ninguna otra cita activa del mismo barbero en esa fecha, sea del cliente que sea, revisando todas las agendas del barbero de ese día. No cuentan las citas en estado Cancelada por el cliente, Cancelada por el barbero, Cancelación o Cancelación por veto. Dos citas se cruzan cuando una empieza antes de que termine la otra y termina después de que la otra empiece; una cita que empieza justo cuando otra termina no se cruza. Al reprogramar o reagendar no se cuenta la misma cita que se está moviendo o reactivando |  |  |  |
|  |  |  |  | HorarioSede | Permite conocer, a través del horario del barbero, la sede de la nueva agenda. | P-CIT-0012 | Asegurar que la hora solicitada no caiga dentro de ningún bloqueo del barbero, ni que la cita se extienda sobre uno |  |  |  |
|  |  |  |  | PeriodoCierre | Permite verificar que la cita no se cruce con un periodo en el que la sede de la agenda permanece cerrada. | P-CIT-0026 | Asegurar que la cita no se cruce con ningún periodo de cierre de la sede de la agenda solicitada. La cita ocupa desde la fecha de la agenda con su horaInicio hasta esa misma fecha con su horaFinEstimada, y se cruza con un periodo de cierre cuando empieza antes de la fecha y hora final del cierre y termina después de su fecha y hora de inicio. Una cita que termina justo cuando empieza el cierre, o que empieza justo cuando termina, no se cruza. Solo cuentan los periodos de cierre de esa sede; los de otras sedes de la misma barbería no impiden agendar |  |  |  |
|  |  |  |  | Festivo | Permite saber si la nueva fecha es festivo. | P-CIT-0015 | Asegurar que la cita se agende como máximo hasta 15 días después del día actual: se permite agendar desde hoy hasta hoy + 15 días, y una fecha posterior a ese límite no se puede agendar |  |  |  |
|  |  |  |  | SedeFestivo | Permite saber si la sede de la nueva agenda abre en ese festivo; si no abre, no se puede reprogramar para ese día. | P-CIT-0029 | Asegurar que la cita no se agende en una fecha festiva si la sede no tiene registrada la apertura de ese festivo; por defecto las sedes no atienden los festivos. Si la sede abre el festivo, la cita debe caber en su horario habitual de ese día de la semana. |  |  |  |
|  |  |  |  | Multa | Permite conocer las multas sin pagar del cliente y la cita de donde salió cada una. | P-CIT-0030 | Asegurar que el cliente no tenga ya una cita, en cualquier estado, en esa misma agenda y a esa misma hora de inicio: un cliente tiene una sola cita por agenda y hora. Si la canceló él mismo, debe reagendarla en lugar de pedir una nueva; si la canceló el barbero o el sistema, debe elegir otra hora |  |  |  |
|  |  |  |  | Sede | Permite conocer la barbería de la sede de la nueva agenda, para revisar solo las multas de esa barbería. | P-CIT-0005 | Asegurar que la cita no se solicite para una fecha y hora que ya pasaron, es decir que la cita no se puede solicitar en un tiempo pasado |  |  |  |
|  |  |  |  | BarberoServicio | Permite verificar que el barbero siga ofreciendo los servicios de la cita. | P-CIT-0032 | Asegurar que la cita le pertenezca al cliente que hace la operación; un cliente solo puede reprogramar, cancelar o reagendar sus propias citas |  |  |  |
|  |  |  |  |  |  | P-CIT-0004 | Asegurar que cada servicio solicitado sea un servicio vigente (BarberoServicio vigente) del barbero dueño del horario de la agenda de la cita; así todos los servicios de la cita pertenecen al único barbero que la atiende |  |  |  |
| Cliente | Cancelar la cita por decisión del cliente | Permite a un cliente cancelar una cita antes de que ocurra | Cita | Estado | Permite verificar que la cita se encuentre en estado Agendada y cambiarla a Cancelada por el cliente cuando la cancelación es aceptada. | P-CIT-0032 | Asegurar que la cita le pertenezca al cliente que hace la operación; un cliente solo puede reprogramar, cancelar o reagendar sus propias citas |  | Cita cancelada por el cliente |  |
|  |  |  |  |  |  | P-CIT-0014 | Asegurar que la cita se encuentre en estado Agendada |  |  |  |
|  |  |  |  |  |  | P-CIT-0009 | El cliente tiene hasta 2 horas antes de la horaInicio de la cita para cancelarla; cuando faltan menos de 2 horas ya no se le permite cancelar |  |  |  |
| Cliente | Reagendar la cita | Comando que permite a un cliente volver a activar una cita que él mismo canceló, en la misma fecha y hora, si ese espacio sigue libre; la cita vuelve a quedar agendada sin crear una nueva | Cita | Estado | Permite verificar que la cita esté en Cancelada por el cliente y dejarla de nuevo en Agendada. | P-CIT-0032 | Asegurar que la cita le pertenezca al cliente que hace la operación; un cliente solo puede reprogramar, cancelar o reagendar sus propias citas |  | Cita reagendada |  |
|  |  |  |  | Agenda | Permite conocer la fecha de la cita y las demás citas activas del barbero ese día. | P-CIT-0031 | Asegurar que la cita se encuentre en estado Cancelada por el cliente para poder reagendarla; las citas canceladas por el barbero, por cambio de políticas de la barbería o por veto no se pueden reagendar |  |  |  |
|  |  |  |  | Bloqueo | Permite verificar que la hora de la cita no haya quedado dentro de un bloqueo del barbero. | P-CIT-0005 | Asegurar que la cita no se solicite para una fecha y hora que ya pasaron, es decir que la cita no se puede solicitar en un tiempo pasado |  |  |  |
|  |  |  |  | BarberoServicio | Permite verificar que el barbero siga ofreciendo los servicios de la cita y copiar su duración y tiempo extra vigentes. | P-CIT-0002 | Asegurar que el cliente no tenga ninguna multa sin pagar (pagada = no) en la barbería donde quiere agendar: se revisan las multas originadas en citas de cualquiera de las sedes de la barbería a la que pertenece la sede de la agenda solicitada, no solo en esa sede. Las multas ya pagadas y las multas de otras barberías no impiden agendar |  |  |  |
|  |  |  |  | Servicio | Permite copiar el precio vigente de cada servicio de la cita. | P-CIT-0003 | Asegurar que la cita quepa dentro del horario de trabajo del barbero y que no se cruce con ninguna otra cita activa del mismo barbero en esa fecha, sea del cliente que sea, revisando todas las agendas del barbero de ese día. No cuentan las citas en estado Cancelada por el cliente, Cancelada por el barbero, Cancelación o Cancelación por veto. Dos citas se cruzan cuando una empieza antes de que termine la otra y termina después de que la otra empiece; una cita que empieza justo cuando otra termina no se cruza. Al reprogramar o reagendar no se cuenta la misma cita que se está moviendo o reactivando |  |  |  |
|  |  |  |  | CitaServicio | Permite actualizar los valores congelados de cada servicio de la cita. | P-CIT-0012 | Asegurar que la hora solicitada no caiga dentro de ningún bloqueo del barbero, ni que la cita se extienda sobre uno |  |  |  |
|  |  |  |  | Multa | Permite conocer las multas sin pagar del cliente en la barbería. | P-CIT-0026 | Asegurar que la cita no se cruce con ningún periodo de cierre de la sede de la agenda solicitada. La cita ocupa desde la fecha de la agenda con su horaInicio hasta esa misma fecha con su horaFinEstimada, y se cruza con un periodo de cierre cuando empieza antes de la fecha y hora final del cierre y termina después de su fecha y hora de inicio. Una cita que termina justo cuando empieza el cierre, o que empieza justo cuando termina, no se cruza. Solo cuentan los periodos de cierre de esa sede; los de otras sedes de la misma barbería no impiden agendar |  |  |  |
|  |  |  |  | HorarioSede | Permite conocer, a través del horario del barbero, la sede de la cita. | P-CIT-0029 | Asegurar que la cita no se agende en una fecha festiva si la sede no tiene registrada la apertura de ese festivo; por defecto las sedes no atienden los festivos. Si la sede abre el festivo, la cita debe caber en su horario habitual de ese día de la semana. |  |  |  |
|  |  |  |  | Sede | Permite conocer la barbería de la sede, para revisar solo las multas de esa barbería. | P-CIT-0004 | Asegurar que cada servicio solicitado sea un servicio vigente (BarberoServicio vigente) del barbero dueño del horario de la agenda de la cita; así todos los servicios de la cita pertenecen al único barbero que la atiende |  |  |  |
|  |  |  |  | Festivo | Permite saber si la fecha de la cita es festivo. | P-CIT-0006 | Congelar en la cita el valor de multa, el tiempoEspera y el porcentajeDescuento en el momento de agendarla, para que un cambio posterior no altere citas ya registradas |  |  |  |
|  |  |  |  | SedeFestivo | Permite saber si la sede abre en ese festivo. | P-CSE-0001 | Asegurar que al crear el CitaServicio se copien el precio del Servicio y la duración y el tiempo extra del BarberoServicio vigentes en el momento de agendar la cita, para que un cambio posterior no altere la cita |  |  |  |
|  |  |  |  | PeriodoCierre | Permite verificar que la cita no se cruce con un periodo de cierre de la sede. |  |  |  |  |  |
| Barbero | Cancelar la cita por decisión del barbero | Permite a un barbero cancelar una cita antes de que ocurra | Cita | HorarioBarbero | Permite verificar, a través del horario de la agenda, que la cita sea del barbero que hace la operación. | P-CIT-0027 | Asegurar que el barbero que cambia el estado de la cita o la cancela sea el barbero de la cita, es decir, el dueño del horario de la agenda en la que está; en una cita solo participan un barbero y un cliente |  | Cita cancelada por el barbero |  |
|  |  |  |  | Estado | Permite verificar que la cita se encuentre en estado Agendada y cambiarla a Cancelada por el barbero. | P-CIT-0014 | Asegurar que la cita se encuentre en estado Agendada |  |  |  |
|  |  |  |  |  |  | P-CIT-0010 | El barbero tiene hasta 2 horas antes de la horaInicio de la cita para cancelarla; cuando faltan menos de 2 horas ya no se le permite cancelar |  |  |  |
| Barbero | Registrar la inasistencia del cliente | Permite al barbero de la cita indicar que el cliente nunca llegó, cuando ya pasó la hora estimada de finalización de la cita | Cita | Agenda | Permite conocer la fecha de la cita para verificar que el cambio de estado se haga el mismo día. | P-CIT-0027 | Asegurar que el barbero que cambia el estado de la cita o la cancela sea el barbero de la cita, es decir, el dueño del horario de la agenda en la que está; en una cita solo participan un barbero y un cliente |  | Inasistencia de cliente registrada |  |
|  |  |  |  | HorarioBarbero | Permite verificar, a través del horario de la agenda, que la cita sea del barbero que hace la operación. | P-CIT-0014 | Asegurar que la cita se encuentre en estado Agendada |  |  |  |
|  |  |  |  | Multa | Permite generar la multa por inasistencia con el precioTotal de la cita. | P-CIT-0016 | Asegurar que el cambio de estado de la cita se realice en la misma fecha de la cita (fecha de su agenda) |  |  |  |
|  |  |  |  | Estado | Permite verificar que la cita se encuentre en estado Agendada y cambiarla a Inasistencia del cliente. | P-CIT-0021 | Asegurar que ya haya pasado la horaFinEstimada de la cita para registrar la inasistencia del cliente; mientras la cita no haya terminado según su hora estimada, el cliente todavía puede llegar |  |  |  |
|  |  |  |  |  |  | P-CIT-0007 | Cuando se registre la inasistencia del cliente, generar una Multa de tipo Inasistencia por el precioTotal de la cita |  |  |  |
| Barbero | Registrar que el cliente se demoró | Permite al barbero indicar que el cliente no llegó dentro de la horaInicio más el tiempoEspera de la cita | Cita | Agenda | Permite conocer la fecha de la cita para verificar que el cambio de estado se haga el mismo día. | P-CIT-0027 | Asegurar que el barbero que cambia el estado de la cita o la cancela sea el barbero de la cita, es decir, el dueño del horario de la agenda en la que está; en una cita solo participan un barbero y un cliente |  | Demora del cliente registrada |  |
|  |  |  |  | HorarioBarbero | Permite verificar, a través del horario de la agenda, que la cita sea del barbero que hace la operación. | P-CIT-0014 | Asegurar que la cita se encuentre en estado Agendada |  |  |  |
|  |  |  |  | Estado | Permite verificar que la cita se encuentre en estado Agendada y cambiarla a El cliente se demoro. | P-CIT-0016 | Asegurar que el cambio de estado de la cita se realice en la misma fecha de la cita (fecha de su agenda) |  |  |  |
|  |  |  |  | Multa | Permite generar la multa de tipo Tardanza con el valor de multa de la cita. | P-CIT-0018 | Asegurar que ya haya pasado la horaInicio de la cita más su tiempoEspera |  |  |  |
|  |  |  |  |  |  | P-CIT-0023 | Cuando la cita pase al estado El cliente se demoro, generar una Multa de tipo Tardanza por el valor de multa de esa misma cita; si después el cliente no paga los servicios, se registra además el No pagado |  |  |  |
| Barbero | Finalizar la cita | Permite al barbero indicar que atendió al cliente, que se prestó el servicio y que el cliente pagó | Cita | Agenda | Permite conocer la fecha de la cita para verificar que el cambio de estado se haga el mismo día. | P-CIT-0027 | Asegurar que el barbero que cambia el estado de la cita o la cancela sea el barbero de la cita, es decir, el dueño del horario de la agenda en la que está; en una cita solo participan un barbero y un cliente |  | Cita finalizada |  |
|  |  |  |  | HorarioBarbero | Permite verificar, a través del horario de la agenda, que la cita sea del barbero que hace la operación. | P-CIT-0019 | Asegurar que la cita se encuentre en estado Agendada, El cliente se demoro o El barbero se demoro para poder finalizarla |  |  |  |
|  |  |  |  | Estado | Permite verificar que la cita se encuentre en estado Agendada, El cliente se demoro o El barbero se demoro y cambiarla a Finalizada. | P-CIT-0016 | Asegurar que el cambio de estado de la cita se realice en la misma fecha de la cita (fecha de su agenda) |  |  |  |
|  |  |  |  |  |  | P-CIT-0017 | Asegurar que ya haya pasado la horaInicio de la cita |  |  |  |
| Barbero | Registrar que el cliente no pagó | Permite al barbero indicar que el cliente asistió y recibió la atención, pero no realizó el pago | Cita | Agenda | Permite conocer la fecha de la cita para verificar que el cambio de estado se haga el mismo día. | P-CIT-0027 | Asegurar que el barbero que cambia el estado de la cita o la cancela sea el barbero de la cita, es decir, el dueño del horario de la agenda en la que está; en una cita solo participan un barbero y un cliente |  | Cita no pagada registrada |  |
|  |  |  |  | HorarioBarbero | Permite verificar, a través del horario de la agenda, que la cita sea del barbero que hace la operación. | P-CIT-0020 | Asegurar que la cita se encuentre en estado Agendada, El cliente se demoro o El barbero se demoro para poder registrarla como No pagado |  |  |  |
|  |  |  |  | Estado | Permite verificar que la cita se encuentre en estado Agendada o El barbero se demoro y cambiarla a No pagado. | P-CIT-0016 | Asegurar que el cambio de estado de la cita se realice en la misma fecha de la cita (fecha de su agenda) |  |  |  |
|  |  |  |  | Multa | Permite generar la multa de tipo No pagado por el precioTotal de la cita. | P-CIT-0017 | Asegurar que ya haya pasado la horaInicio de la cita |  |  |  |
|  |  |  |  |  |  | P-CIT-0022 | Cuando la cita pase al estado No pagado, generar una Multa de tipo No pagado por el precioTotal de la cita |  |  |  |
| Sistema | Cancelar las citas futuras por veto | Comando que permite al sistema cancelar las citas futuras que el cliente tiene agendadas en una barbería cuando se le impone una multa en ella | Cita | Agenda | Permite conocer la fecha de cada cita del cliente para identificar cuáles son futuras. | P-CIT-0028 | Cuando al cliente se le imponga una multa, cancelar en el estado Cancelación por veto todas sus citas futuras en estado Agendada en cualquier sede de la barbería donde se originó la multa. Son futuras las citas cuya fecha de agenda y horaInicio son posteriores al momento actual. No aplica el límite de 2 horas para cancelar, las citas de otras barberías no se modifican y las citas canceladas no se restauran aunque el cliente pague la multa o el barbero la elimine |  | Citas canceladas por veto |  |
|  |  |  |  | HorarioBarbero | Permite llegar desde cada agenda al horario de la sede al que pertenece. |  |  |  |  |  |
|  |  |  |  | HorarioSede | Permite saber a qué sede pertenece cada cita. |  |  |  |  |  |
|  |  |  |  | Sede | Permite quedarse solo con las citas de las sedes de la barbería donde se originó la multa. |  |  |  |  |  |
|  |  |  |  | Estado | Permite identificar las citas que siguen en estado Agendada y dejarlas en Cancelación por veto. |  |  |  |  |  |

### Políticas

| Número Política | Descripción Política | Objeto Responsable |
|---|---|---|
| P-CIT-0001 | Asegurar que los datos requeridos (agenda, hora de inicio, servicios solicitados) sean válidos en tipo de dato, obligatoriedad, formato y rango | [Cita](#cita) |
| P-CIT-0002 | Asegurar que el cliente no tenga ninguna multa sin pagar (pagada = no) en la barbería donde quiere agendar: se revisan las multas originadas en citas de cualquiera de las sedes de la barbería a la que pertenece la sede de la agenda solicitada, no solo en esa sede. Las multas ya pagadas y las multas de otras barberías no impiden agendar | [Multa](#multa) |
| P-CIT-0003 | Asegurar que la cita quepa dentro del horario de trabajo del barbero y que no se cruce con ninguna otra cita activa del mismo barbero en esa fecha, sea del cliente que sea, revisando todas las agendas del barbero de ese día. No cuentan las citas en estado Cancelada por el cliente, Cancelada por el barbero, Cancelación o Cancelación por veto. Dos citas se cruzan cuando una empieza antes de que termine la otra y termina después de que la otra empiece; una cita que empieza justo cuando otra termina no se cruza. Al reprogramar o reagendar no se cuenta la misma cita que se está moviendo o reactivando | [Agenda](#agenda) |
| P-CIT-0004 | Asegurar que cada servicio solicitado sea un servicio vigente (BarberoServicio vigente) del barbero dueño del horario de la agenda de la cita; así todos los servicios de la cita pertenecen al único barbero que la atiende | [BarberoServicio](#barberoservicio) |
| P-CIT-0005 | Asegurar que la cita no se solicite para una fecha y hora que ya pasaron, es decir que la cita no se puede solicitar en un tiempo pasado | [Cita](#cita) |
| P-CIT-0006 | Congelar en la cita el valor de multa, el tiempoEspera y el porcentajeDescuento en el momento de agendarla, para que un cambio posterior no altere citas ya registradas | [Cita](#cita) |
| P-CIT-0007 | Cuando se registre la inasistencia del cliente, generar una Multa de tipo Inasistencia por el precioTotal de la cita | [Multa](#multa) |
| P-CIT-0008 | Si la cita queda en el estado El barbero se demoro, aplicar el porcentajeDescuento de esa misma cita sobre su precioTotal | [Cita](#cita) |
| P-CIT-0009 | El cliente tiene hasta 2 horas antes de la horaInicio de la cita para cancelarla; cuando faltan menos de 2 horas ya no se le permite cancelar | [Cita](#cita) |
| P-CIT-0010 | El barbero tiene hasta 2 horas antes de la horaInicio de la cita para cancelarla; cuando faltan menos de 2 horas ya no se le permite cancelar | [Cita](#cita) |
| P-CIT-0011 | Asegurar que, al reprogramar, el barbero de la cita tenga agenda en la nueva fecha: la cita solo puede cambiar de fecha o de hora de inicio, nunca de barbero, por lo que la nueva agenda es la de ese mismo barbero para esa fecha. Si el barbero no tiene agenda ese día (no trabaja ese día de la semana, la sede permanece cerrada durante toda su jornada o es un festivo en el que la sede no abre), no se puede reprogramar para esa fecha | [Agenda](#agenda) |
| P-CIT-0012 | Asegurar que la hora solicitada no caiga dentro de ningún bloqueo del barbero, ni que la cita se extienda sobre uno | [Bloqueo](#bloqueo) |
| P-CIT-0013 | Asegurar que exista la cita con el id enviado | [Cita](#cita) |
| P-CIT-0014 | Asegurar que la cita se encuentre en estado Agendada | [Cita](#cita) |
| P-CIT-0015 | Asegurar que la cita se agende como máximo hasta 15 días después del día actual: se permite agendar desde hoy hasta hoy + 15 días, y una fecha posterior a ese límite no se puede agendar | [Cita](#cita) |
| P-CIT-0016 | Asegurar que el cambio de estado de la cita se realice en la misma fecha de la cita (fecha de su agenda) | [Agenda](#agenda) |
| P-CIT-0017 | Asegurar que ya haya pasado la horaInicio de la cita | [Cita](#cita) |
| P-CIT-0018 | Asegurar que ya haya pasado la horaInicio de la cita más su tiempoEspera | [Cita](#cita) |
| P-CIT-0019 | Asegurar que la cita se encuentre en estado Agendada, El cliente se demoro o El barbero se demoro para poder finalizarla | [Cita](#cita) |
| P-CIT-0020 | Asegurar que la cita se encuentre en estado Agendada, El cliente se demoro o El barbero se demoro para poder registrarla como No pagado | [Cita](#cita) |
| P-CIT-0021 | Asegurar que ya haya pasado la horaFinEstimada de la cita para registrar la inasistencia del cliente; mientras la cita no haya terminado según su hora estimada, el cliente todavía puede llegar | [Cita](#cita) |
| P-CIT-0022 | Cuando la cita pase al estado No pagado, generar una Multa de tipo No pagado por el precioTotal de la cita | [Multa](#multa) |
| P-CIT-0023 | Cuando la cita pase al estado El cliente se demoro, generar una Multa de tipo Tardanza por el valor de multa de esa misma cita; si después el cliente no paga los servicios, se registra además el No pagado | [Multa](#multa) |
| P-CIT-0024 | Asegurar que no exista otro objeto de tipo Cita con el mismo id; el id solo debe ser único entre los objetos de tipo Cita | [Cita](#cita) |
| P-CIT-0025 | Asignar a la cita que se está pidiendo el estado Agendada, tomándolo del catálogo de estados ya existente | [Cita](#cita) |
| P-CIT-0026 | Asegurar que la cita no se cruce con ningún periodo de cierre de la sede de la agenda solicitada. La cita ocupa desde la fecha de la agenda con su horaInicio hasta esa misma fecha con su horaFinEstimada, y se cruza con un periodo de cierre cuando empieza antes de la fecha y hora final del cierre y termina después de su fecha y hora de inicio. Una cita que termina justo cuando empieza el cierre, o que empieza justo cuando termina, no se cruza. Solo cuentan los periodos de cierre de esa sede; los de otras sedes de la misma barbería no impiden agendar | [PeriodoCierre](#periodocierre) |
| P-CIT-0027 | Asegurar que el barbero que cambia el estado de la cita o la cancela sea el barbero de la cita, es decir, el dueño del horario de la agenda en la que está; en una cita solo participan un barbero y un cliente | [Cita](#cita) |
| P-CIT-0028 | Cuando al cliente se le imponga una multa, cancelar en el estado Cancelación por veto todas sus citas futuras en estado Agendada en cualquier sede de la barbería donde se originó la multa. Son futuras las citas cuya fecha de agenda y horaInicio son posteriores al momento actual. No aplica el límite de 2 horas para cancelar, las citas de otras barberías no se modifican y las citas canceladas no se restauran aunque el cliente pague la multa o el barbero la elimine | [Cita](#cita) |
| P-CIT-0029 | Asegurar que la cita no se agende en una fecha festiva si la sede no tiene registrada la apertura de ese festivo; por defecto las sedes no atienden los festivos. Si la sede abre el festivo, la cita debe caber en su horario habitual de ese día de la semana. | [SedeFestivo](#sedefestivo) |
| P-CIT-0030 | Asegurar que el cliente no tenga ya una cita, en cualquier estado, en esa misma agenda y a esa misma hora de inicio: un cliente tiene una sola cita por agenda y hora. Si la canceló él mismo, debe reagendarla en lugar de pedir una nueva; si la canceló el barbero o el sistema, debe elegir otra hora | [Cita](#cita) |
| P-CIT-0031 | Asegurar que la cita se encuentre en estado Cancelada por el cliente para poder reagendarla; las citas canceladas por el barbero, por cambio de políticas de la barbería o por veto no se pueden reagendar | [Cita](#cita) |
| P-CIT-0032 | Asegurar que la cita le pertenezca al cliente que hace la operación; un cliente solo puede reprogramar, cancelar o reagendar sus propias citas | [Cita](#cita) |

[↑ Volver al índice](#objetos-de-dominio)

---

## CitaServicio

**Descripción:** Representa cada servicio incluido dentro de una cita puntual, guardando el precio y la duración que tenía ese servicio para ese barbero en el momento exacto en que se agendó, para que cambios futuros en el catálogo no alteren citas ya registradas.  
**Línea de vida:** 8

### Muestreo de datos

- **id**: Representa un identificador que hará unico cada objeto de dominio de este tipo, no se puede repetir
- **cita**: Hace referencia a la cita a la que pertenece este servicio pedido (referencia a [Cita](#cita))
- **barberoServicio**: Hace referencia a qué servicio, de qué barbero específico, se pidió en esta cita. No se referencia el Servicio directamente porque un barbero podría no ofrecerlo (referencia a [BarberoServicio](#barberoservicio))
- **precioServicio**: Representa el precio que tenía el servicio en el momento en que se agendó esta cita. Es un dato auto generado: copia de Servicio.precio, para que cambios futuros en el precio del servicio no alteren una cita ya registrada
- **duracionEnHorasElServicio**: Representa la duración en horas que tenía el servicio para ese barbero en el momento en que se agendó esta cita. Es un dato auto generado: copia de BarberoServicio.duracionServicio
- **duracionEnMinutosElServicio**: Representa la duración en minutos que tenía el servicio para ese barbero en el momento en que se agendó esta cita. Es un dato auto generado: copia de BarberoServicio.duracionServicio
- **tiempoExtra**: Representa el tiempo extra en minutos que ese barbero tenía configurado para este servicio en el momento en que se agendó la cita. Es un dato auto generado: copia de BarberoServicio.tiempoExtra, para que cambios futuros en el tiempo extra no alteren una cita ya registrada
- **Combinación única **: Combinación única que indica que un mismo servicio no se puede pedir dos veces en la misma cita, es decir que CitaServicio no puede tener la misma cita y el barberoServicio

| id | cita | barberoServicio | precioServicio | duracionEnHorasElServicio | duracionEnMinutosElServicio | tiempoExtra | Combinación única  |
|---|---|---|---|---|---|---|---|
| 1 | +57-3234528921-+57-3245627890-BarberClub Colombia-Sede Poblado-Lunes-09:00-19:00-12/11/2023-1/01/1000-10:00-16:00-03/05/2025-1/01/1000-05/10/2026-10:00 | Juan García-Motilada | $ 22.000 | 0 | 45 | 15 | +57-3234528921-+57-3245627890-BarberClub Colombia-Sede Poblado-Lunes-09:00-19:00-12/11/2023-1/01/1000-10:00-16:00-03/05/2025-1/01/1000-05/10/2026-10:00-Juan García-Motilada |
| 2 | +57-3161657782-+57-3124518923-BarberClub Colombia-Sede Poblado-Martes-09:00-19:00-12/11/2023-1/01/1000-09:00-15:00-02/03/2025-1/01/1000-10/03/2026-09:30 | Juan Ortiz-Corte de barba | $ 12.000 | 0 | 10 | 5 | +57-3161657782-+57-3124518923-BarberClub Colombia-Sede Poblado-Martes-09:00-19:00-12/11/2023-1/01/1000-09:00-15:00-02/03/2025-1/01/1000-10/03/2026-09:30-Juan Ortiz-Corte de barba |
| 3 | +57-3119884321-+57-3214533321-BarberClub Colombia-Sede Poblado-Jueves-09:00-19:00-12/11/2023-1/01/1000-13:00-19:00-22/12/2022-1/01/1000-14/05/2026-13:00 | Carlos Arbeladez-Perfilada de barba | $ 15.000 | 0 | 15 | 5 | +57-3119884321-+57-3214533321-BarberClub Colombia-Sede Poblado-Jueves-09:00-19:00-12/11/2023-1/01/1000-13:00-19:00-22/12/2022-1/01/1000-14/05/2026-13:00-Carlos Arbeladez-Perfilada de barba |
| 4 | +58-4127359182-+91-9876543210-BarberClub Colombia-Sede Poblado-Sábado-08:00-21:00-12/12/2024-1/01/1000-08:00-14:00-15/09/2025-01/01/2026-22/11/2025-13:00 | Andres Ramirez-Arreglo completo de barba con toalla caliente | $ 35.000 | 0 | 40 | 10 | +58-4127359182-+91-9876543210-BarberClub Colombia-Sede Poblado-Sábado-08:00-21:00-12/12/2024-1/01/1000-08:00-14:00-15/09/2025-01/01/2026-22/11/2025-13:00-Andres Ramirez-Arreglo completo de barba con toalla caliente |
| 5 | +58-4127359182-+57-3214533321-BarberClub Colombia-Sede Poblado-Jueves-09:00-19:00-12/11/2023-1/01/1000-13:00-19:00-22/12/2022-1/01/1000-06/08/2026-18:00 | Carlos Arbeladez-Corte de barba | $ 12.000 | 0 | 15 | 5 | +58-4127359182-+57-3214533321-BarberClub Colombia-Sede Poblado-Jueves-09:00-19:00-12/11/2023-1/01/1000-13:00-19:00-22/12/2022-1/01/1000-06/08/2026-18:00-Carlos Arbeladez-Corte de barba |
| 6 | +57-3005544332-+57-3245627890-BarberClub Colombia-Sede Poblado-Lunes-09:00-19:00-12/11/2023-1/01/1000-10:00-16:00-03/05/2025-1/01/1000-01/06/2026-10:00 | Juan García-Motilada | $ 22.000 | 0 | 45 | 15 | +57-3005544332-+57-3245627890-BarberClub Colombia-Sede Poblado-Lunes-09:00-19:00-12/11/2023-1/01/1000-10:00-16:00-03/05/2025-1/01/1000-01/06/2026-10:00-Juan García-Motilada |
| 7 | +57-3005544332-+57-3124518923-BarberClub Colombia-Sede Poblado-Martes-09:00-19:00-12/11/2023-1/01/1000-09:00-15:00-02/03/2025-1/01/1000-16/06/2026-09:00 | Juan Ortiz-Corte de barba | $ 12.000 | 0 | 10 | 5 | +57-3005544332-+57-3124518923-BarberClub Colombia-Sede Poblado-Martes-09:00-19:00-12/11/2023-1/01/1000-09:00-15:00-02/03/2025-1/01/1000-16/06/2026-09:00-Juan Ortiz-Corte de barba |
| 8 | +57-3005544332-+57-3214533321-BarberClub Colombia-Sede Poblado-Jueves-09:00-19:00-12/11/2023-1/01/1000-13:00-19:00-22/12/2022-1/01/1000-02/07/2026-15:00 | Carlos Arbeladez-Perfilada de barba | $ 15.000 | 0 | 15 | 5 | +57-3005544332-+57-3214533321-BarberClub Colombia-Sede Poblado-Jueves-09:00-19:00-12/11/2023-1/01/1000-13:00-19:00-22/12/2022-1/01/1000-02/07/2026-15:00-Carlos Arbeladez-Perfilada de barba |
| 9 | +57-3161657782-+57-3214533321-BarberClub Colombia-Sede Poblado-Jueves-09:00-19:00-12/11/2023-1/01/1000-13:00-19:00-22/12/2022-1/01/1000-14/05/2026-13:30 | Carlos Arbeladez-Perfilada de barba | $ 15.000 | 0 | 15 | 5 | +57-3161657782-+57-3214533321-BarberClub Colombia-Sede Poblado-Jueves-09:00-19:00-12/11/2023-1/01/1000-13:00-19:00-22/12/2022-1/01/1000-14/05/2026-13:30-Carlos Arbeladez-Perfilada de barba |
| 10 | +57-3161657782-+57-3214533321-BarberClub Colombia-Sede Poblado-Jueves-09:00-19:00-12/11/2023-1/01/1000-13:00-19:00-22/12/2022-1/01/1000-14/05/2026-13:30 | Carlos Arbeladez-Corte de barba | $ 12.000 | 0 | 15 | 5 | +57-3161657782-+57-3214533321-BarberClub Colombia-Sede Poblado-Jueves-09:00-19:00-12/11/2023-1/01/1000-13:00-19:00-22/12/2022-1/01/1000-14/05/2026-13:30-Carlos Arbeladez-Corte de barba |

**Combinaciones únicas y datos tomados de otros objetos:**

- **cita**: referencia a [Cita](#cita); en los datos de ejemplo se muestra con su combinación única.
- **barberoServicio**: referencia a [BarberoServicio](#barberoservicio); en los datos de ejemplo se muestra con su combinación única.
- **precioServicio**: toma el valor de `precio` de [Servicio](#servicio).
- **duracionEnHorasElServicio**: toma el valor de `duracionEnHoras` de [BarberoServicio](#barberoservicio).
- **duracionEnMinutosElServicio**: toma el valor de `duracionEnMinutos` de [BarberoServicio](#barberoservicio).
- **tiempoExtra**: toma el valor de `tiempoExtra` de [BarberoServicio](#barberoservicio).
- **Combinación única**: formada por `cita` + `barberoServicio`.

**Clasificación de las columnas del muestreo:**

- Corresponde al identificador unico del objeto de dominio: id
- Corresponde a las referencias de otros objetos de dominio: cita, barberoServicio
- Corresponde a los datos auto generados por el sistema: precioServicio, duracionEnHorasElServicio, duracionEnMinutosElServicio, tiempoExtra
- Corresponde a la combinacion única: Combinación única 

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Rendondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | consultarServiciosDeCita | consultarPrecioDeCadaServicio | crearCitaServicio |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| id | Representa un identificador que hará unico cada objeto de dominio de este tipo, no se puede repetir | Si | Identificador único universal | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No | No | No aplica | No | No | No | UUID vacio | Si | No mostrar | No mostrar | No requerido |
| cita | Hace referencia a la cita a la que pertenece este servicio pedido | No | [Cita](#cita) | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | Aplican las reglas del objeto referenciado | No | No aplica | No aplica | No aplica | No aplica | No | UUID vacio | No | No mostrar | No mostrar | Requerido |
| barberoServicio | Hace referencia a qué servicio, de qué barbero específico, se pidió en esta cita. No se referencia el Servicio directamente porque un barbero podría no ofrecerlo | No | [BarberoServicio](#barberoservicio) | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | Aplican las reglas del objeto referenciado | No | No aplica | No aplica | No aplica | No aplica | No | UUID vacio | No | Mostrar | Mostrar | Requerido |
| precioServicio | Representa el precio que tenía el servicio en el momento en que se agendó esta cita. Es un dato auto generado: copia de Servicio.precio, para que cambios futuros en el precio del servicio no alteren una cita ya registrada | No | Entero | Si | No aplica | No aplica | No aplica | No aplica | 0 | 2000000 | No aplica | Copia de Servicio.precio en el momento de agendar la cita | No | No aplica | No aplica | No aplica | No aplica | No | 0 | Si | Mostrar | Mostrar | No requerido |
| duracionEnHorasElServicio | Representa la duración en horas que tenía el servicio para ese barbero en el momento en que se agendó esta cita. Es un dato auto generado: copia de BarberoServicio.duracionServicio | No | Entero | Si | No aplica | No aplica | No aplica | No aplica | 0 | 3 | No aplica | Copia de BarberoServicio.duracionEnHoras en el momento de agendar la cita | No | No aplica | No aplica | No aplica | No aplica | No | 0 | Si | Mostrar | No mostrar | No requerido |
| duracionEnMinutosElServicio | Representa la duración en minutos que tenía el servicio para ese barbero en el momento en que se agendó esta cita. Es un dato auto generado: copia de BarberoServicio.duracionServicio | No | Entero | Si | No aplica | No aplica | No aplica | No aplica | 0 | 59 | No aplica | Copia de BarberoServicio.duracionServicio en el momento de agendar la cita | No | No aplica | No aplica | No aplica | No aplica | No | 0 | Si | Mostrar | No mostrar | No requerido |
| tiempoExtra | Representa el tiempo extra en minutos que ese barbero tenía configurado para este servicio en el momento en que se agendó la cita. Es un dato auto generado: copia de BarberoServicio.tiempoExtra, para que cambios futuros en el tiempo extra no alteren una cita ya registrada | No | Entero | Si | No aplica | No aplica | No aplica | No aplica | 0 | 59 | No aplica | Copia de BarberoServicio.tiempoExtra en el momento de agendar la cita | No | No aplica | No aplica | No aplica | No aplica | No | 0 | Si | Mostrar | No mostrar | No requerido |

| Nombre combinación única | Descripción | Atributos involucrados |
|---|---|---|
| Combinación única  | Combinación única que indica que un mismo servicio no se puede pedir dos veces en la misma cita, es decir que CitaServicio no puede tener la misma cita y el barberoServicio | cita, barberoServicio |

| Responsabilidad | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Salida / Descripción | Políticas (Reglas de Negocio) / Política | Políticas (Reglas de Negocio) / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |
|---|---|---|---|---|---|---|---|---|---|---|
| consultarServiciosDeCita | Permite ver qué servicios fueron pedidos dentro de una cita puntual | filtro{cita} | CitaServicio | Contiene la cita por la cual se van a consultar sus servicios | Lista<CitaServicio> | Contiene todos los servicios que fueron pedidos dentro de esa cita |  |  |  |  |
| consultarPrecioDeCadaServicio | Permite consultar el precio que quedó congelado para cada servicio de una cita en el momento en que se agendó | filtro{cita} | CitaServicio | Contiene la cita por la cual se van a consultar los precios de sus servicios | Lista<CitaServicio> | Contiene el precio que quedó congelado para cada servicio de esa cita |  |  |  |  |
| crearCitaServicio | Comando que permite al sistema registrar un servicio pedido dentro de una cita, copiando el precio y la duración vigentes en el momento de agendarla | datos{cita, barberoServicio} | CitaServicio | Contiene la cita y el servicio del barbero que se pidió en ella | CitaServicio | Contiene la información del servicio registrado dentro de la cita | P-CSE-0001 | Asegurar que al crear el CitaServicio se copien el precio del Servicio y la duración y el tiempo extra del BarberoServicio vigentes en el momento de agendar la cita, para que un cambio posterior no altere la cita | Si los valores no se pueden copiar, no registrar el servicio y revertir el agendamiento de la cita | Detener operación |
|  |  |  |  |  |  |  | P-CSE-0002 | Asegurar que no exista otro objeto de tipo CitaServicio con el mismo id; el id solo debe ser único entre los objetos de tipo CitaServicio | Generar un nuevo id para el CitaServicio y volver a validar que no lo tenga otro CitaServicio | Continuar operación |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Barbero | Consultar los servicios de una cita | Permite ver qué servicios fueron pedidos dentro de una cita puntual | CitaServicio |  |  |  |  |  | Servicios de cita consultados |  |
| Cliente | Consultar los servicios de una cita | Permite ver qué servicios fueron pedidos dentro de una cita puntual | CitaServicio |  |  |  |  |  | Servicios de cita consultados |  |
| Barbero | Ver precio de cada servicio | Permite consultar el precio que quedó congelado para cada servicio de una cita en el momento en que se agendó | CitaServicio |  |  |  |  |  | Precio de servicio de cita consultado |  |
| Cliente | Ver precio de cada servicio | Permite consultar el precio que quedó congelado para cada servicio de una cita en el momento en que se agendó | CitaServicio |  |  |  |  |  | Precio de servicio de cita consultado |  |
| Sistema | Crear servicios de una cita | Permite al sistema registrar cada servicio pedido dentro de una cita en el momento en que se agenda, con el precio y la duración vigentes | CitaServicio | Cita | Permite asociar el servicio a la cita que se está agendando. | P-CSE-0001 | Asegurar que al crear el CitaServicio se copien el precio del Servicio y la duración y el tiempo extra del BarberoServicio vigentes en el momento de agendar la cita, para que un cambio posterior no altere la cita |  | CitaServicio creado |  |
|  |  |  |  | BarberoServicio | Permite copiar la duración y el tiempo extra del servicio para ese barbero. |  |  |  |  |  |
|  |  |  |  | Servicio | Permite copiar el precio vigente del servicio. |  |  |  |  |  |

### Políticas

| Número Política | Descripción Política | Objeto Responsable |
|---|---|---|
| P-CSE-0001 | Asegurar que al crear el CitaServicio se copien el precio del Servicio y la duración y el tiempo extra del BarberoServicio vigentes en el momento de agendar la cita, para que un cambio posterior no altere la cita | [CitaServicio](#citaservicio) |
| P-CSE-0002 | Asegurar que no exista otro objeto de tipo CitaServicio con el mismo id; el id solo debe ser único entre los objetos de tipo CitaServicio | [CitaServicio](#citaservicio) |

[↑ Volver al índice](#objetos-de-dominio)

---

## Multa

**Descripción:** Representa la sanción económica que se le impone a un cliente por incumplir una cita, ya sea por llegar tarde fuera de tolerancia, por no presentarse o por no pagar los servicios recibidos, calculada a partir de la cita específica que la originó. Mientras siga sin pagar, el cliente queda vetado en la barbería donde se originó.  
**Línea de vida:** 8

### Muestreo de datos

- **id**: Representa un identificador que hará unico cada objeto de dominio de este tipo, no se puede repetir
- **cita**: Hace referencia a la cita puntual que el cliente incumplió (llegando tarde fuera de la tolerancia, no presentándose o no pagando los servicios); de esa cita sale el valor del monto. A través de la cita se conoce el barbero que la atendió y la sede y la barbería donde se originó la multa (referencia a [Cita](#cita))
- **tipo**: Hace referencia al tipo de multa -tardanza, inasistencia o no pagado- según lo que haya ocurrido con la cita (referencia a [TipoMulta](#tipomulta))
- **monto**: Representa cuánto dinero en pesos colombianos debe pagar el cliente por esta multa. Es un dato auto generado: si el tipo es Tardanza copia el valor de multa de la Cita; si el tipo es Inasistencia o No pagado copia el precioTotal de la Cita
- **horaGeneracion**: Representa la hora en la que se generó esta multa: es la hora en la que el barbero de la cita registró el estado que la origina (El cliente se demoro, Inasistencia del cliente o No pagado). El día es el mismo día de la agenda de la cita
- **fechaHoraPago**: Representa la fecha y hora en la que el cliente pagó esta multa. Su valor por defecto es 01/01/1000 00:00 y es permitido: significa que la multa sigue sin pagar
- **pagada**: Representa si el cliente ya pagó o no esta multa. Mientras tenga una multa sin pagar (pagada = no), el cliente no puede agendar citas en ninguna sede de la barbería donde se originó la multa; en las demás barberías sí puede agendar. Si el barbero de la cita elimina la multa, deja de contar para el veto
- **Combinación única 1**: Combinación única que indica que una misma cita no puede tener dos multas del mismo tipo; sí puede tener una de tipo Tardanza y otra de tipo No pagado

| id | cita | tipo | monto | horaGeneracion | fechaHoraPago | pagada | Combinación única 1 |
|---|---|---|---|---|---|---|---|
| 1 | +57-3119884321-+57-3214533321-BarberClub Colombia-Sede Poblado-Jueves-09:00-19:00-12/11/2023-1/01/1000-13:00-19:00-22/12/2022-1/01/1000-14/05/2026-13:00 | Tardanza | 10.000 | 13:25 | 30/07/2026 10:00 | si | +57-3119884321-+57-3214533321-BarberClub Colombia-Sede Poblado-Jueves-09:00-19:00-12/11/2023-1/01/1000-13:00-19:00-22/12/2022-1/01/1000-14/05/2026-13:00-Tardanza |
| 2 | +58-4127359182-+91-9876543210-BarberClub Colombia-Sede Poblado-Sábado-08:00-21:00-12/12/2024-1/01/1000-08:00-14:00-15/09/2025-01/01/2026-22/11/2025-13:00 | Inasistencia | 35.000 | 14:00 | 25/11/2025 10:00 | si | +58-4127359182-+91-9876543210-BarberClub Colombia-Sede Poblado-Sábado-08:00-21:00-12/12/2024-1/01/1000-08:00-14:00-15/09/2025-01/01/2026-22/11/2025-13:00-Inasistencia |
| 3 | +57-3005544332-+57-3245627890-BarberClub Colombia-Sede Poblado-Lunes-09:00-19:00-12/11/2023-1/01/1000-10:00-16:00-03/05/2025-1/01/1000-01/06/2026-10:00 | Inasistencia | 22.000 | 11:10 | 1/01/1000 00:00 | no | +57-3005544332-+57-3245627890-BarberClub Colombia-Sede Poblado-Lunes-09:00-19:00-12/11/2023-1/01/1000-10:00-16:00-03/05/2025-1/01/1000-01/06/2026-10:00-Inasistencia |
| 4 | +57-3005544332-+57-3124518923-BarberClub Colombia-Sede Poblado-Martes-09:00-19:00-12/11/2023-1/01/1000-09:00-15:00-02/03/2025-1/01/1000-16/06/2026-09:00 | Inasistencia | 12.000 | 09:25 | 1/01/1000 00:00 | no | +57-3005544332-+57-3124518923-BarberClub Colombia-Sede Poblado-Martes-09:00-19:00-12/11/2023-1/01/1000-09:00-15:00-02/03/2025-1/01/1000-16/06/2026-09:00-Inasistencia |
| 5 | +57-3005544332-+57-3214533321-BarberClub Colombia-Sede Poblado-Jueves-09:00-19:00-12/11/2023-1/01/1000-13:00-19:00-22/12/2022-1/01/1000-02/07/2026-15:00 | Inasistencia | 15.000 | 15:30 | 1/01/1000 00:00 | no | +57-3005544332-+57-3214533321-BarberClub Colombia-Sede Poblado-Jueves-09:00-19:00-12/11/2023-1/01/1000-13:00-19:00-22/12/2022-1/01/1000-02/07/2026-15:00-Inasistencia |

**Combinaciones únicas y datos tomados de otros objetos:**

- **cita**: referencia a [Cita](#cita); en los datos de ejemplo se muestra con su combinación única.
- **tipo**: referencia a [TipoMulta](#tipomulta); en los datos de ejemplo se muestra con su combinación única.
- **monto**: toma el valor de `multa` de [Cita](#cita).
- **horaGeneracion**: en los datos de ejemplo corresponde a la horaFinEstimada de la [Cita](#cita) más 10 minutos.
- **Combinación única 1**: formada por `cita` + `tipo`.

**Clasificación de las columnas del muestreo:**

- Corresponde al identificador unico del objeto de dominio: id
- Corresponde a las referencias de otros objetos de dominio: cita, tipo
- Corresponde a los datos auto generados por el sistema: monto, horaGeneracion, fechaHoraPago, pagada
- Corresponde a los datos que ingresa el usuario: ninguna columna
- Corresponde a la combinacion única: Combinación única 1

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Rendondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | imponerMultaCliente | consultarMultasDeCliente | consultarMultasSinPagarClienteEnBarberia | consultarMultasClienteDeBarbero | registrarPagoMulta | registrarPagoMulta | eliminarMulta |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| id | Representa un identificador que hará unico cada objeto de dominio de este tipo, no se puede repetir | Si | Identificador único universal | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No | No aplica | No aplica | No aplica | No aplica | No | UUID vacio | Si | No requerido | No mostrar | No mostrar | No mostrar | Requerido | No modificable | Requerido |
| cita | Hace referencia a la cita puntual que el cliente incumplió (llegando tarde fuera de la tolerancia, no presentándose o no pagando los servicios); de esa cita sale el valor del monto. A través de la cita se conoce el barbero que la atendió y la sede y la barbería donde se originó la multa | No | [Cita](#cita) | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | Aplican las reglas del objeto referenciado | No | No aplica | No aplica | No aplica | No aplica | No | UUID vacio | No | Requerido | Mostrar | Mostrar | Mostrar | No requerido | No modificable | No requerido |
| tipo | Hace referencia al tipo de multa -tardanza, inasistencia o no pagado- según lo que haya ocurrido con la cita | No | [TipoMulta](#tipomulta) | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | Aplican las reglas del objeto referenciado | No | No aplica | No aplica | No aplica | No aplica | No | UUID vacio | No | Requerido | Mostrar | Mostrar | Mostrar | No requerido | No modificable | No requerido |
| monto | Representa cuánto dinero en pesos colombianos debe pagar el cliente por esta multa. Es un dato auto generado: si el tipo es Tardanza copia el valor de multa de la Cita; si el tipo es Inasistencia o No pagado copia el precioTotal de la Cita | No | Entero | Si | No aplica | No aplica | No aplica | No aplica | 0 | 1000000 | No aplica | Si tipo=Tardanza copia Cita.multa; si tipo=Inasistencia o No pagado copia Cita.precioTotal, y queda congelado | No | No aplica | No aplica | No aplica | No aplica | No | 0 | Si | No requerido | Mostrar | Mostrar | Mostrar | No requerido | No modificable | No requerido |
| horaGeneracion | Representa la hora en la que se generó esta multa: es la hora en la que el barbero de la cita registró el estado que la origina (El cliente se demoro, Inasistencia del cliente o No pagado). El día es el mismo día de la agenda de la cita | No | Hora | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | Toma la hora en la que el barbero de la cita registra el estado que genera la multa (El cliente se demoro, Inasistencia del cliente o No pagado) | No | No aplica | No aplica | No aplica | No aplica | No | 00:00 | Si | No requerido | Mostrar | Mostrar | Mostrar | No requerido | No modificable | No requerido |
| fechaHoraPago | Representa la fecha y hora en la que el cliente pagó esta multa. Su valor por defecto es 01/01/1000 00:00 y es permitido: significa que la multa sigue sin pagar | No | Fecha y Hora | No | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No | No aplica | No aplica | No aplica | No aplica | No | 01/01/1000 00:00 | No | No requerido | Mostrar | No mostrar | Mostrar | Requerido | Modificable | No requerido |
| pagada | Representa si el cliente ya pagó o no esta multa. Mientras tenga una multa sin pagar (pagada = no), el cliente no puede agendar citas en ninguna sede de la barbería donde se originó la multa; en las demás barberías sí puede agendar. Si el barbero de la cita elimina la multa, deja de contar para el veto | No | Lógico | Si | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No aplica | No | No aplica | No aplica | No aplica | No aplica | No | No | No | No requerido | Mostrar | No mostrar | Mostrar | No requerido | Modificable | No requerido |

| Nombre combinación única | Descripción | Atributos involucrados |
|---|---|---|
| Combinación única 1 | Combinación única que indica que una misma cita no puede tener dos multas del mismo tipo; sí puede tener una de tipo Tardanza y otra de tipo No pagado | cita, tipo |

| Responsabilidad | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Salida / Descripción | Políticas (Reglas de Negocio) / Política | Políticas (Reglas de Negocio) / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |
|---|---|---|---|---|---|---|---|---|---|---|
| imponerMultaCliente | Genera automáticamente una multa al cliente cuando el barbero de la cita la deja en El cliente se demoro, Inasistencia del cliente o No pagado; con la multa el cliente queda vetado en esa barbería y sus citas futuras en ella se cancelan por veto | datos{cita, tipo} | Multa | Contiene la cita incumplida y el tipo de multa que se le va a imponer al cliente | Multa | Contiene la información de la multa impuesta | P-MUL-0001 | Congelar el motivo (tipo de multa) y el monto en el momento de generarse: si es de tipo Tardanza se copia Cita.multa; si es de tipo Inasistencia o No pagado se copia Cita.precioTotal, sin recalcular después | Si el tipo de multa y el monto no se pueden congelar, no registrar la multa e informar el error | Detener operación |
|  |  |  |  |  |  |  | P-MUL-0006 | Asegurar que la cita no tenga ya una multa del mismo tipo; una misma cita puede tener una multa de tipo Tardanza y otra de tipo No pagado cuando el cliente llegó tarde y además no pagó | Generar una excepción indicando que la cita ya tiene una multa de ese tipo | Detener operación |
|  |  |  |  |  |  |  | P-MUL-0003 | Al imponerse una multa, el cliente queda vetado en la barbería donde se originó: se deben cancelar, en el estado Cancelación por veto, todas sus citas futuras en estado Agendada en cualquier sede de esa barbería (P-CIT-0028). El veto no se guarda en el cliente; se calcula a partir de sus multas sin pagar en esa barbería (P-CIT-0002) | Si las citas futuras del cliente no se pueden cancelar por veto, no registrar la multa e informar el error | Detener operación |
|  |  |  |  |  |  |  | P-MUL-0007 | El cambio de estado de la cita, la multa y la cancelación por veto de las citas futuras del cliente se realizan como una sola operación: si alguna parte no se puede completar, se revierte todo y la cita conserva su estado anterior | Revertir la multa, la cancelación de las citas y el cambio de estado de la cita e informar el error al barbero | Detener operación |
|  |  |  |  |  |  |  | P-MUL-0005 | Asegurar que no exista otro objeto de tipo Multa con el mismo id; el id solo debe ser único entre los objetos de tipo Multa | Generar un nuevo id para el Multa y volver a validar que no lo tenga otro Multa | Continuar operación |
| consultarMultasDeCliente | Permite a un cliente consultar el historial de multas que se le han impuesto | filtro{cliente} | Multa | Contiene el cliente por el cual se van a consultar sus multas | Lista<Multa> | Contiene todas las multas que se le han impuesto al cliente |  |  |  |  |
| consultarMultasSinPagarClienteEnBarberia | Permite al cliente consultar las multas que tiene sin pagar en una barbería; si tiene al menos una, no puede agendar citas en ninguna sede de esa barbería | filtro{cliente, barberia} | Multa | Contiene el cliente y la barbería por los cuales se van a consultar las multas sin pagar | Lista<Multa> | Contiene las multas sin pagar del cliente originadas en citas de cualquier sede de esa barbería; si está vacía, el cliente puede agendar en ella |  |  |  |  |
| consultarMultasClienteDeBarbero | Permite al barbero consultar las multas que tiene un cliente originadas en las citas que él atendió, para cobrarlas o eliminarlas | filtro{cliente, barbero} | Multa | Contiene el cliente y el barbero por los cuales se van a consultar las multas | Lista<Multa> | Contiene las multas del cliente originadas en citas de ese barbero, indicando si ya están pagadas |  |  |  |  |
| registrarPagoMulta | Permite al barbero de la cita marcar que el cliente ya pagó una multa pendiente que salió de esa cita | id | UUID | Corresponde al identificador de la multa que se va a marcar como pagada | Multa | Contiene la multa con su pago registrado | P-MUL-0004 | Asegurar que exista la multa con el id enviado | Informar con un mensaje que no existe una multa con el identificador enviado y por lo tanto no es posible llevar a cabo la operación | Detener operación |
|  |  | fechaHoraPago | Fecha y Hora | Contiene la fecha y hora en la que el cliente pagó la multa |  |  | P-MUL-0008 | Asegurar que el barbero que registra el pago o elimina la multa sea el barbero de la cita que originó la multa, es decir, el dueño del horario de la agenda de esa cita | Generar una excepción indicándole al barbero que solo puede gestionar las multas de las citas que él atendió | Detener operación |
|  |  |  |  |  |  |  | P-MUL-0002 | Asegurar que la multa no esté ya pagada antes de registrar un nuevo pago | Generar una excepción indicándole al usuario que esa multa ya está pagada | Detener operación |
| eliminarMulta | Permite al barbero de la cita eliminar una multa sin pagar que salió de esa cita, por ejemplo cuando decide perdonarla; deja de contar para el veto del cliente | id | UUID | Corresponde al identificador de la multa que se va a eliminar | No retorna ningún valor. En caso de error genera una excepción. |  | P-MUL-0004 | Asegurar que exista la multa con el id enviado | Informar con un mensaje que no existe una multa con el identificador enviado y por lo tanto no es posible llevar a cabo la operación | Detener operación |
|  |  |  |  |  |  |  | P-MUL-0008 | Asegurar que el barbero que registra el pago o elimina la multa sea el barbero de la cita que originó la multa, es decir, el dueño del horario de la agenda de esa cita | Generar una excepción indicándole al barbero que solo puede gestionar las multas de las citas que él atendió | Detener operación |
|  |  |  |  |  |  |  | P-MUL-0009 | Asegurar que la multa que se va a eliminar no esté pagada; al eliminarla deja de contar para el veto del cliente, pero las citas que se cancelaron por veto no se restauran | Generar una excepción indicándole al barbero que la multa ya está pagada y por eso no se puede eliminar | Detener operación |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Sistema | Imponer una multa al cliente | Genera automáticamente una multa al cliente cuando el barbero de la cita la deja en El cliente se demoro, Inasistencia del cliente o No pagado; con la multa el cliente queda vetado en esa barbería y sus citas futuras en ella se cancelan por veto | Multa | Cita | Permite conocer la cita incumplida de donde salen el tipo y el monto de la multa. | P-MUL-0001 | Congelar el motivo (tipo de multa) y el monto en el momento de generarse: si es de tipo Tardanza se copia Cita.multa; si es de tipo Inasistencia o No pagado se copia Cita.precioTotal, sin recalcular después |  | Multa impuesta |  |
|  |  |  |  | Agenda | Permite conocer la fecha de las citas del cliente para identificar cuáles son futuras. | P-MUL-0006 | Asegurar que la cita no tenga ya una multa del mismo tipo; una misma cita puede tener una multa de tipo Tardanza y otra de tipo No pagado cuando el cliente llegó tarde y además no pagó |  |  |  |
|  |  |  |  | HorarioBarbero | Permite llegar desde cada agenda al horario de la sede al que pertenece. | P-MUL-0003 | Al imponerse una multa, el cliente queda vetado en la barbería donde se originó: se deben cancelar, en el estado Cancelación por veto, todas sus citas futuras en estado Agendada en cualquier sede de esa barbería (P-CIT-0028). El veto no se guarda en el cliente; se calcula a partir de sus multas sin pagar en esa barbería (P-CIT-0002) |  |  |  |
|  |  |  |  | HorarioSede | Permite saber a qué sede pertenece cada cita. | P-MUL-0007 | El cambio de estado de la cita, la multa y la cancelación por veto de las citas futuras del cliente se realizan como una sola operación: si alguna parte no se puede completar, se revierte todo y la cita conserva su estado anterior |  |  |  |
|  |  |  |  | Sede | Permite conocer la barbería donde se originó la multa y todas sus sedes. |  |  |  |  |  |
|  |  |  |  | Estado | Permite dejar las citas futuras del cliente en esa barbería en el estado Cancelación por veto. |  |  |  |  |  |
| Cliente | Ver todas mis multas | Permite a un cliente consultar el historial de multas que se le han impuesto | Multa | TipoMulta | Permite mostrar de qué tipo es cada multa del cliente. |  |  |  | Multas consultadas |  |
| Cliente | Ver mis multas sin pagar en una barbería | Permite al cliente consultar las multas que tiene sin pagar en una barbería; si tiene al menos una, no puede agendar citas en ninguna sede de esa barbería | Multa | Cita | Permite conocer la cita de donde salió cada multa. |  |  |  | Multas sin pagar en barbería consultadas |  |
|  |  |  |  | HorarioSede | Permite conocer, a través de la agenda y el horario del barbero de la cita, la sede donde se originó cada multa. |  |  |  |  |  |
|  |  |  |  | Sede | Permite quedarse solo con las multas originadas en las sedes de esa barbería. |  |  |  |  |  |
| Barbero | Ver las multas de un cliente | Permite al barbero consultar las multas que tiene un cliente originadas en las citas que él atendió, para cobrarlas o eliminarlas | Multa | Cita | Permite conocer la cita de donde salió la multa. |  |  |  | Multas de cliente consultadas |  |
|  |  |  |  | Agenda | Permite llegar desde la cita al horario del barbero que la atendió. |  |  |  |  |  |
|  |  |  |  | HorarioBarbero | Permite quedarse solo con las multas de las citas que atendió el barbero. |  |  |  |  |  |
|  |  |  |  | TipoMulta | Permite mostrar de qué tipo es cada multa del cliente. |  |  |  |  |  |
| Barbero | Registrar el pago de una multa | Permite al barbero de la cita marcar que el cliente ya pagó una multa pendiente que salió de esa cita | Multa | Cita | Permite conocer la cita de donde salió la multa. | P-MUL-0008 | Asegurar que el barbero que registra el pago o elimina la multa sea el barbero de la cita que originó la multa, es decir, el dueño del horario de la agenda de esa cita |  | Multa pagada |  |
|  |  |  |  | Agenda | Permite llegar desde la cita al horario del barbero que la atendió. | P-MUL-0002 | Asegurar que la multa no esté ya pagada antes de registrar un nuevo pago |  |  |  |
|  |  |  |  | HorarioBarbero | Permite verificar que la multa salió de una cita del barbero que hace la operación. |  |  |  |  |  |
| Barbero | Eliminar una multa | Permite al barbero de la cita eliminar una multa sin pagar que salió de esa cita, por ejemplo cuando decide perdonarla; deja de contar para el veto del cliente | Multa | Cita | Permite conocer la cita de donde salió la multa. | P-MUL-0008 | Asegurar que el barbero que registra el pago o elimina la multa sea el barbero de la cita que originó la multa, es decir, el dueño del horario de la agenda de esa cita |  | Multa eliminada |  |
|  |  |  |  | Agenda | Permite llegar desde la cita al horario del barbero que la atendió. | P-MUL-0009 | Asegurar que la multa que se va a eliminar no esté pagada; al eliminarla deja de contar para el veto del cliente, pero las citas que se cancelaron por veto no se restauran |  |  |  |
|  |  |  |  | HorarioBarbero | Permite verificar que la multa salió de una cita del barbero que hace la operación. |  |  |  |  |  |

### Políticas

| Número Política | Descripción Política | Objeto Responsable |
|---|---|---|
| P-MUL-0001 | Congelar el motivo (tipo de multa) y el monto en el momento de generarse: si es de tipo Tardanza se copia Cita.multa; si es de tipo Inasistencia o No pagado se copia Cita.precioTotal, sin recalcular después | [Cita](#cita) |
| P-MUL-0002 | Asegurar que la multa no esté ya pagada antes de registrar un nuevo pago | [Multa](#multa) |
| P-MUL-0003 | Al imponerse una multa, el cliente queda vetado en la barbería donde se originó: se deben cancelar, en el estado Cancelación por veto, todas sus citas futuras en estado Agendada en cualquier sede de esa barbería (P-CIT-0028). El veto no se guarda en el cliente; se calcula a partir de sus multas sin pagar en esa barbería (P-CIT-0002) | [Cita](#cita) |
| P-MUL-0004 | Asegurar que exista la multa con el id enviado | [Multa](#multa) |
| P-MUL-0005 | Asegurar que no exista otro objeto de tipo Multa con el mismo id; el id solo debe ser único entre los objetos de tipo Multa | [Multa](#multa) |
| P-MUL-0006 | Asegurar que la cita no tenga ya una multa del mismo tipo; una misma cita puede tener una multa de tipo Tardanza y otra de tipo No pagado cuando el cliente llegó tarde y además no pagó | [Multa](#multa) |
| P-MUL-0007 | El cambio de estado de la cita, la multa y la cancelación por veto de las citas futuras del cliente se realizan como una sola operación: si alguna parte no se puede completar, se revierte todo y la cita conserva su estado anterior | [Multa](#multa) |
| P-MUL-0008 | Asegurar que el barbero que registra el pago o elimina la multa sea el barbero de la cita que originó la multa, es decir, el dueño del horario de la agenda de esa cita | [Cita](#cita) |
| P-MUL-0009 | Asegurar que la multa que se va a eliminar no esté pagada; al eliminarla deja de contar para el veto del cliente, pero las citas que se cancelaron por veto no se restauran | [Multa](#multa) |

[↑ Volver al índice](#objetos-de-dominio)

---

## Relaciones del modelo de dominio

Relaciones entre los objetos de dominio según el diagrama del modelo de dominio. «Multiplicidad en A» es la cardinalidad del lado del objeto A y «Multiplicidad en B» la del lado del objeto B; las dos lecturas indican el sentido en que se lee la asociación. Los números que el diagrama muestra junto a cada objeto corresponden a su línea de vida.

| Objeto A | Multiplicidad en A | Lectura 1 | Lectura 2 | Multiplicidad en B | Objeto B |
|---|---|---|---|---|---|
| [Departamento](#departamento) | 1...1 | tiene -> | <- esta | 1...* | [Ciudad](#ciudad) |
| [Ciudad](#ciudad) | 1...1 | estan -> | <- esta | 0...* | [Sede](#sede) |
| [PeriodoCierre](#periodocierre) | 0...* | le pertenece -> | <- define | 1...1 | [Sede](#sede) |
| [Servicio](#servicio) | 0...* | pertenece -> | <- tiene | 1...1 | [Sede](#sede) |
| [Sede](#sede) | 1...1 | trabajan -> | <- trabaja | 0...* | [Barbero](#barbero) |
| [Sede](#sede) | 1...* | le pertence -> | tiene -> | 1...1 | [Barberia](#barberia) |
| [Barberia](#barberia) | 0...* | constituye -> | esta constituido-> | 1...1 | [TipoSociedad](#tiposociedad) |
| [Sede](#sede) | 1...1 | establece -> | <- pertence a | 0...* | [SedeFestivo](#sedefestivo) |
| [SedeFestivo](#sedefestivo) | 0...* | se da en -> | <- tiene | 1...1 | [Festivo](#festivo) |
| [Sede](#sede) | 1...1 | tiene -> | <- le pertenece | 0...* | [HorarioSede](#horariosede) |
| [HorarioSede](#horariosede) | 0...* | tiene -> | <- pertenece | 1...1 | [DiaSemana](#diasemana) |
| [Barbero](#barbero) | 0...* | lo tienen -> | tiene -> | 1...1 | [PrefijoCelular](#prefijocelular) |
| [PrefijoCelular](#prefijocelular) | 1...1 | lo tienen -> | <- tiene | 0...* | [Cliente](#cliente) |
| [Servicio](#servicio) | 1...1 | aparece -> | <- referencia | 0...* | [BarberoServicio](#barberoservicio) |
| [BarberoServicio](#barberoservicio) | 1...* | aparece -> | <- referencia | 1...1 | [Barbero](#barbero) |
| [BarberoServicio](#barberoservicio) | 1...1 | aparece en -> | <- referencia | 0...* | [CitaServicio](#citaservicio) |
| [Barbero](#barbero) | 1...1 | establece -> | <- le pertenece | 0...* | [Bloqueo](#bloqueo) |
| [Barbero](#barbero) | 1...1 | establece -> | <- le pertenece | 0...* | [HorarioBarbero](#horariobarbero) |
| [HorarioBarbero](#horariobarbero) | 1...* | es delimitado -> | <- delimita | 1...1 | [HorarioSede](#horariosede) |
| [HorarioBarbero](#horariobarbero) | 1...1 | genera -> | <- proviene de | 0...* | [Agenda](#agenda) |
| [Agenda](#agenda) | 1...1 | guarda -> | <- esta en | 0...* | [Cita](#cita) |
| [CitaServicio](#citaservicio) | 1...* | pertenece -> | <- agrupa | 1...1 | [Cita](#cita) |
| [Cita](#cita) | 0...* | tiene -> | <- esta | 1...1 | [Estado](#estado) |
| [Cita](#cita) | 1...1 | genera -> | <- es generado | 0...1 | [Multa](#multa) |
| [Multa](#multa) | 0...* | tiene -> | <- lo tienen | 1...1 | [TipoMulta](#tipomulta) |
| [Cita](#cita) | 0...* | pide -> | la tiene -> | 1...1 | [Cliente](#cliente) |

[↑ Volver al índice](#objetos-de-dominio)
