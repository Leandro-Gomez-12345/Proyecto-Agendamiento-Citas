# Modelo Entidad-Relación — Barbería

**Otras secciones:** [Relaciones del modelo entidad-relación](#relaciones-del-modelo-entidad-relación) · [Restricciones del modelo](#restricciones-del-modelo) · [Vistas de datos calculados](#vistas-de-datos-calculados)

Documentación de la base de datos relacional del sistema

## Tablas

| # | Tabla | Atributos | FK | Descripción |
|---|---|---|---|---|
| 1 | [DiaSemana](#diasemana) | 2 | 0 | Catálogo de los días de la semana que se usan para definir los horarios de las sedes y de cada barbero. |
| 2 | [Estado](#estado) | 3 | 0 | Catálogo de los estados en los que puede encontrarse una cita durante su ciclo de vida: agendada, finalizada, cancelada por el cliente o por el barbero, con demora del cliente o del barbero, inasistencia del cliente, no pagada, o cancelada por cambios en la barbería o por veto. |
| 3 | [Servicio](#servicio) | 6 | 1 | Entidad que almacena los servicios de corte y arreglo que ofrece cada sede de una barbería; el administrador los define para todas las sedes o para una sede, y cada barbero decide cuáles sabe hacer. |
| 4 | [PrefijoCelular](#prefijocelular) | 2 | 0 | Catálogo de prefijos telefónicos de país disponibles para el número de celular de barberos y clientes. |
| 5 | [TipoMulta](#tipomulta) | 3 | 0 | Catálogo de los tipos de multa que se le pueden imponer a un cliente: por tardanza, por inasistencia o por no pagar una cita en la que fue atendido. |
| 6 | [Barbero](#barbero) | 10 | 2 | Entidad que almacena la información de los barberos, con su contacto, la sede en la que trabajan y su vigencia. |
| 7 | [Cliente](#cliente) | 8 | 1 | Entidad que almacena la información de las personas que solicitan citas en las sedes de las barberías. Su estado de veto no se guarda como columna: se obtiene por medio de una vista a partir de sus multas sin pagar. |
| 8 | [HorarioSede](#horariosede) | 8 | 2 | Entidad que registra los horarios de apertura y cierre de cada sede para cada día de la semana; una sede puede tener varios horarios el mismo día (jornada partida) si no se cruzan, y son el límite dentro del cual debe caber el horario de cualquier barbero de esa sede. |
| 9 | [Bloqueo](#bloqueo) | 4 | 1 | Entidad que registra los rangos de fecha y hora en los que un barbero no está disponible para atender sus citas. |
| 10 | [BarberoServicio](#barberoservicio) | 7 | 2 | Entidad asociativa que registra qué servicios sabe hacer cada barbero, cuánto tarda en realizarlos y cuánto tiempo extra reserva para ellos. |
| 11 | [HorarioBarbero](#horariobarbero) | 8 | 2 | Entidad que registra la jornada de trabajo de un barbero dentro de un horario de su sede, con la hora en la que empieza, la hora en la que termina y su vigencia. |
| 12 | [Agenda](#agenda) | 3 | 1 | Entidad que representa el día concreto de trabajo de un barbero, según su horario, en el que se agrupan todas las citas de ese día. |
| 13 | [Cita](#cita) | 8 | 3 | Entidad que registra la reserva de un cliente con un barbero para una fecha y hora concretas, con su estado y las condiciones de tolerancia, multa y descuento que quedan congeladas al agendar. La hora estimada de finalización y el precio total se obtienen por medio de vistas. |
| 14 | [CitaServicio](#citaservicio) | 7 | 2 | Entidad asociativa que registra cada servicio incluido dentro de una cita, congelando el precio y la duración que tenía ese servicio para ese barbero en el momento de agendarla. |
| 15 | [Multa](#multa) | 7 | 2 | Entidad que registra la sanción económica impuesta a un cliente por incumplir una cita, ya sea por tardanza, por inasistencia o por no pagarla, con su monto y su estado de pago. |
| 16 | [Departamento](#departamento) | 2 | 0 | Catálogo de los departamentos del país en los que se ubican las ciudades donde una barbería puede tener sedes. |
| 17 | [Ciudad](#ciudad) | 3 | 1 | Entidad que almacena las ciudades, cada una perteneciente a un departamento, en las que puede estar ubicada una sede. |
| 18 | [Barberia](#barberia) | 4 | 0 | Entidad que almacena las barberías registradas en el sistema, es decir, la cadena o marca comercial dueña de una o varias sedes, con su nombre comercial, su razón social y su NIT. |
| 19 | [Sede](#sede) | 5 | 2 | Entidad que almacena las sucursales físicas de cada barbería, ubicadas en una ciudad, donde se ofrecen los servicios y trabajan los barberos. |
| 20 | [PeriodoCierre](#periodocierre) | 4 | 1 | Entidad que registra los intervalos de fecha y hora durante los cuales una sede permanece cerrada por decisión de la barbería (por ejemplo vacaciones, mantenimiento o remodelación); mientras duran no se atiende a clientes ni se agendan citas. |
| 21 | [Festivo](#festivo) | 3 | 0 | Entidad que almacena las fechas festivas de Colombia en las que, por ley, es día de descanso; el sistema las genera cada año a partir del calendario oficial de festivos y, por defecto, ninguna sede atiende en ellas. |
| 22 | [SedeFestivo](#sedefestivo) | 3 | 2 | Entidad asociativa que registra en qué festivos abre cada sede; si una sede no tiene registrada la apertura de un festivo ese día no atiende, y si la tiene atiende con su horario habitual del día de la semana en que cae el festivo. |

Agrupación por tipo:

- **Catálogos:** [DiaSemana](#diasemana), [Estado](#estado), [PrefijoCelular](#prefijocelular), [TipoMulta](#tipomulta), [Departamento](#departamento).
- **Entidades asociativas (tablas intermedias):** [BarberoServicio](#barberoservicio), [CitaServicio](#citaservicio), [SedeFestivo](#sedefestivo).
- **Entidades:** [Servicio](#servicio), [Barbero](#barbero), [Cliente](#cliente), [HorarioSede](#horariosede), [Bloqueo](#bloqueo), [HorarioBarbero](#horariobarbero), [Agenda](#agenda), [Cita](#cita), [Multa](#multa), [Ciudad](#ciudad), [Barberia](#barberia), [Sede](#sede), [PeriodoCierre](#periodocierre), [Festivo](#festivo).

---

## DiaSemana

**Descripción:** Catálogo de los días de la semana que se usan para definir los horarios de las sedes y de cada barbero.  
**Clasificación:** Catálogo.  
**Número de atributos:** 2.

### Atributos

#### Definición técnica

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Cantidad dígitos parte decimal (Precisión) | ¿Es autoincremento? | ¿Es obligatorio? | ¿Es llave primeria o es parte de ella? |
|---|---|---|---|---|---|---|---|
| `id` | UUID | 36 | — | — | NO | SI | SI |
| `nombre` | VARCHAR | 9 | — | — | NO | SI | NO |

#### Llave foránea, restricciones y alias

| Nombre | ¿Es llave foránea? | Entidad | Columna(s) | ¿Posee restricción de unicidad o es parte de ella? | Nombre restricción unicidad a la que pertenece | ¿Posee restricción de chequeo o es parte de ella? | Nombre restricción chequeo a la que pertenece | ¿Posee restricción de índice o es parte de ella? | Tipo | Nombre restricción índice a la que pertenece | Alias |
|---|---|---|---|---|---|---|---|---|---|---|---|
| `id` | NO | — | — | SI | PK_diaSemana | NO | — | NO | — | — | — |
| `nombre` | NO | — | — | SI | UQ_diaSemana_nombre | NO | — | NO | — | — | — |

#### Descripción del campo

| Nombre | Descripción del campo |
|---|---|
| `id` | Identificador único del registro que es generado por la aplicación. |
| `nombre` | Nombre del día de la semana. Solo puede ser uno de los siete días, y debe ser único en el sistema. |

### Clave primaria

- Atributo `id` (UUID, longitud 36). Restricción: `PK_diaSemana`. ¿Es autoincremento?: NO.

### Claves foráneas

No tiene claves foráneas.

### Restricciones

#### Restricciones de unicidad

- `PK_diaSemana` (clave primaria): `id`.
- `UQ_diaSemana_nombre`: `nombre`.

#### Restricciones de chequeo

No tiene restricciones de chequeo.

#### Restricciones de índice

No tiene restricciones de índice.

#### Obligatoriedad

- Obligatorios: `id`, `nombre`.
- Opcionales: ninguno.

### Relaciones

Se listan las relaciones que establecen las claves foráneas. Ver también [Relaciones del modelo entidad-relación](#relaciones-del-modelo-entidad-relación).

#### Tablas que referencia

Ninguna.

#### Tablas que la referencian

- [HorarioSede](#horariosede).`diaDeLaSemana` → `DiaSemana.id`

[↑ Volver al índice](#tablas)

---

## Estado

**Descripción:** Catálogo de los estados en los que puede encontrarse una cita durante su ciclo de vida: agendada, finalizada, cancelada por el cliente o por el barbero, con demora del cliente o del barbero, inasistencia del cliente, no pagada, o cancelada por cambios en la barbería o por veto.  
**Clasificación:** Catálogo.  
**Número de atributos:** 3.

### Atributos

#### Definición técnica

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Cantidad dígitos parte decimal (Precisión) | ¿Es autoincremento? | ¿Es obligatorio? | ¿Es llave primeria o es parte de ella? |
|---|---|---|---|---|---|---|---|
| `id` | UUID | 36 | — | — | NO | SI | SI |
| `nombre` | VARCHAR | 50 | — | — | NO | SI | NO |
| `descripcion` | VARCHAR | 300 | — | — | NO | SI | NO |

#### Llave foránea, restricciones y alias

| Nombre | ¿Es llave foránea? | Entidad | Columna(s) | ¿Posee restricción de unicidad o es parte de ella? | Nombre restricción unicidad a la que pertenece | ¿Posee restricción de chequeo o es parte de ella? | Nombre restricción chequeo a la que pertenece | ¿Posee restricción de índice o es parte de ella? | Tipo | Nombre restricción índice a la que pertenece | Alias |
|---|---|---|---|---|---|---|---|---|---|---|---|
| `id` | NO | — | — | SI | PK_estado | NO | — | NO | — | — | — |
| `nombre` | NO | — | — | SI | UQ_estado_nombre | NO | — | NO | — | — | — |
| `descripcion` | NO | — | — | NO | — | NO | — | NO | — | — | — |

#### Descripción del campo

| Nombre | Descripción del campo |
|---|---|
| `id` | Identificador único del registro que es generado por la aplicación. |
| `nombre` | Nombre del estado en el que se encuentra una cita. Debe ser único en el sistema. |
| `descripcion` | Descripción del significado que tiene ese estado para la cita. |

### Clave primaria

- Atributo `id` (UUID, longitud 36). Restricción: `PK_estado`. ¿Es autoincremento?: NO.

### Claves foráneas

No tiene claves foráneas.

### Restricciones

#### Restricciones de unicidad

- `PK_estado` (clave primaria): `id`.
- `UQ_estado_nombre`: `nombre`.

#### Restricciones de chequeo

No tiene restricciones de chequeo.

#### Restricciones de índice

No tiene restricciones de índice.

#### Obligatoriedad

- Obligatorios: `id`, `nombre`, `descripcion`.
- Opcionales: ninguno.

### Relaciones

Se listan las relaciones que establecen las claves foráneas. Ver también [Relaciones del modelo entidad-relación](#relaciones-del-modelo-entidad-relación).

#### Tablas que referencia

Ninguna.

#### Tablas que la referencian

- [Cita](#cita).`estado` → `Estado.id`

[↑ Volver al índice](#tablas)

---

## Servicio

**Descripción:** Entidad que almacena los servicios de corte y arreglo que ofrece cada sede de una barbería; el administrador los define para todas las sedes o para una sede, y cada barbero decide cuáles sabe hacer.  
**Clasificación:** Entidad.  
**Número de atributos:** 6.

### Atributos

#### Definición técnica

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Cantidad dígitos parte decimal (Precisión) | ¿Es autoincremento? | ¿Es obligatorio? | ¿Es llave primeria o es parte de ella? |
|---|---|---|---|---|---|---|---|
| `id` | UUID | 36 | — | — | NO | SI | SI |
| `sede` | UUID | 36 | — | — | NO | SI | NO |
| `nombre` | VARCHAR | 50 | — | — | NO | SI | NO |
| `descripcion` | VARCHAR | 200 | — | — | NO | NO | NO |
| `precio` | INT | — | 7 | — | NO | SI | NO |
| `disponible` | BOOLEAN | — | — | — | NO | SI | NO |

#### Llave foránea, restricciones y alias

| Nombre | ¿Es llave foránea? | Entidad | Columna(s) | ¿Posee restricción de unicidad o es parte de ella? | Nombre restricción unicidad a la que pertenece | ¿Posee restricción de chequeo o es parte de ella? | Nombre restricción chequeo a la que pertenece | ¿Posee restricción de índice o es parte de ella? | Tipo | Nombre restricción índice a la que pertenece | Alias |
|---|---|---|---|---|---|---|---|---|---|---|---|
| `id` | NO | — | — | SI | PK_servicio | NO | — | NO | — | — | — |
| `sede` | SI | [Sede](#sede) | id | SI | UQ_servicio_sede_nombre | NO | — | NO | — | — | — |
| `nombre` | NO | — | — | SI | UQ_servicio_sede_nombre | NO | — | NO | — | — | — |
| `descripcion` | NO | — | — | NO | — | NO | — | NO | — | — | — |
| `precio` | NO | — | — | NO | — | SI | CHK_servicio_precio | NO | — | — | — |
| `disponible` | NO | — | — | NO | — | NO | — | NO | — | — | — |

#### Descripción del campo

| Nombre | Descripción del campo |
|---|---|
| `id` | Identificador único del registro que es generado por la aplicación. |
| `sede` | Referencia a la sede de la barbería a la que pertenece el servicio. Única en combinación con nombre. |
| `nombre` | Nombre del servicio que ofrece la sede. No puede repetirse dentro de una misma sede (único en combinación con sede). |
| `descripcion` | Descripción de lo que incluye el servicio. Campo opcional. |
| `precio` | Valor del servicio en pesos colombianos en esa sede. Debe estar entre 0 y 2.000.000. |
| `disponible` | Indica si el servicio sigue disponible en la sede. |

### Clave primaria

- Atributo `id` (UUID, longitud 36). Restricción: `PK_servicio`. ¿Es autoincremento?: NO.

### Claves foráneas

| Atributo | Tabla referenciada | Columna(s) referenciada(s) | ¿Es obligatorio? | Restricción de unicidad en la que participa |
|---|---|---|---|---|
| `sede` | [Sede](#sede) | `id` | SI | `UQ_servicio_sede_nombre` |

### Restricciones

#### Restricciones de unicidad

- `PK_servicio` (clave primaria): `id`.
- `UQ_servicio_sede_nombre`: `sede`, `nombre`.

#### Restricciones de chequeo

- `CHK_servicio_precio` sobre `precio`. Condición tal como aparece en la descripción del campo: «Valor del servicio en pesos colombianos en esa sede. Debe estar entre 0 y 2.000.000.»

#### Restricciones de índice

No tiene restricciones de índice.

#### Obligatoriedad

- Obligatorios: `id`, `sede`, `nombre`, `precio`, `disponible`.
- Opcionales: `descripcion`.

### Relaciones

Se listan las relaciones que establecen las claves foráneas. Ver también [Relaciones del modelo entidad-relación](#relaciones-del-modelo-entidad-relación).

#### Tablas que referencia

- `Servicio.sede` → [Sede](#sede).`id`

#### Tablas que la referencian

- [BarberoServicio](#barberoservicio).`servicio` → `Servicio.id`

[↑ Volver al índice](#tablas)

---

## PrefijoCelular

**Descripción:** Catálogo de prefijos telefónicos de país disponibles para el número de celular de barberos y clientes.  
**Clasificación:** Catálogo.  
**Número de atributos:** 2.

### Atributos

#### Definición técnica

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Cantidad dígitos parte decimal (Precisión) | ¿Es autoincremento? | ¿Es obligatorio? | ¿Es llave primeria o es parte de ella? |
|---|---|---|---|---|---|---|---|
| `id` | UUID | 36 | — | — | NO | SI | SI |
| `prefijo` | VARCHAR | 6 | — | — | NO | SI | NO |

#### Llave foránea, restricciones y alias

| Nombre | ¿Es llave foránea? | Entidad | Columna(s) | ¿Posee restricción de unicidad o es parte de ella? | Nombre restricción unicidad a la que pertenece | ¿Posee restricción de chequeo o es parte de ella? | Nombre restricción chequeo a la que pertenece | ¿Posee restricción de índice o es parte de ella? | Tipo | Nombre restricción índice a la que pertenece | Alias |
|---|---|---|---|---|---|---|---|---|---|---|---|
| `id` | NO | — | — | SI | PK_prefijoCelular | NO | — | NO | — | — | — |
| `prefijo` | NO | — | — | SI | UQ_prefijoCelular_prefijo | NO | — | NO | — | — | — |

#### Descripción del campo

| Nombre | Descripción del campo |
|---|---|
| `id` | Identificador único del registro que es generado por la aplicación. |
| `prefijo` | Prefijo telefónico del país, formado por el símbolo + seguido de números. Debe ser único en el sistema. |

### Clave primaria

- Atributo `id` (UUID, longitud 36). Restricción: `PK_prefijoCelular`. ¿Es autoincremento?: NO.

### Claves foráneas

No tiene claves foráneas.

### Restricciones

#### Restricciones de unicidad

- `PK_prefijoCelular` (clave primaria): `id`.
- `UQ_prefijoCelular_prefijo`: `prefijo`.

#### Restricciones de chequeo

No tiene restricciones de chequeo.

#### Restricciones de índice

No tiene restricciones de índice.

#### Obligatoriedad

- Obligatorios: `id`, `prefijo`.
- Opcionales: ninguno.

### Relaciones

Se listan las relaciones que establecen las claves foráneas. Ver también [Relaciones del modelo entidad-relación](#relaciones-del-modelo-entidad-relación).

#### Tablas que referencia

Ninguna.

#### Tablas que la referencian

- [Barbero](#barbero).`prefijo` → `PrefijoCelular.id`
- [Cliente](#cliente).`prefijoCelular` → `PrefijoCelular.id`

[↑ Volver al índice](#tablas)

---

## TipoMulta

**Descripción:** Catálogo de los tipos de multa que se le pueden imponer a un cliente: por tardanza, por inasistencia o por no pagar una cita en la que fue atendido.  
**Clasificación:** Catálogo.  
**Número de atributos:** 3.

### Atributos

#### Definición técnica

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Cantidad dígitos parte decimal (Precisión) | ¿Es autoincremento? | ¿Es obligatorio? | ¿Es llave primeria o es parte de ella? |
|---|---|---|---|---|---|---|---|
| `id` | UUID | 36 | — | — | NO | SI | SI |
| `nombre` | VARCHAR | 50 | — | — | NO | SI | NO |
| `descripcion` | VARCHAR | 300 | — | — | NO | SI | NO |

#### Llave foránea, restricciones y alias

| Nombre | ¿Es llave foránea? | Entidad | Columna(s) | ¿Posee restricción de unicidad o es parte de ella? | Nombre restricción unicidad a la que pertenece | ¿Posee restricción de chequeo o es parte de ella? | Nombre restricción chequeo a la que pertenece | ¿Posee restricción de índice o es parte de ella? | Tipo | Nombre restricción índice a la que pertenece | Alias |
|---|---|---|---|---|---|---|---|---|---|---|---|
| `id` | NO | — | — | SI | PK_tipoMulta | NO | — | NO | — | — | — |
| `nombre` | NO | — | — | SI | UQ_tipoMulta_nombre | NO | — | NO | — | — | — |
| `descripcion` | NO | — | — | NO | — | NO | — | NO | — | — | — |

#### Descripción del campo

| Nombre | Descripción del campo |
|---|---|
| `id` | Identificador único del registro que es generado por la aplicación. |
| `nombre` | Nombre del tipo de multa. Debe ser único en el sistema. |
| `descripcion` | Descripción de lo que representa cada tipo de multa. |

### Clave primaria

- Atributo `id` (UUID, longitud 36). Restricción: `PK_tipoMulta`. ¿Es autoincremento?: NO.

### Claves foráneas

No tiene claves foráneas.

### Restricciones

#### Restricciones de unicidad

- `PK_tipoMulta` (clave primaria): `id`.
- `UQ_tipoMulta_nombre`: `nombre`.

#### Restricciones de chequeo

No tiene restricciones de chequeo.

#### Restricciones de índice

No tiene restricciones de índice.

#### Obligatoriedad

- Obligatorios: `id`, `nombre`, `descripcion`.
- Opcionales: ninguno.

### Relaciones

Se listan las relaciones que establecen las claves foráneas. Ver también [Relaciones del modelo entidad-relación](#relaciones-del-modelo-entidad-relación).

#### Tablas que referencia

Ninguna.

#### Tablas que la referencian

- [Multa](#multa).`tipo` → `TipoMulta.id`

[↑ Volver al índice](#tablas)

---

## Barbero

**Descripción:** Entidad que almacena la información de los barberos, con su contacto, la sede en la que trabajan y su vigencia.  
**Clasificación:** Entidad.  
**Número de atributos:** 10.

### Atributos

#### Definición técnica

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Cantidad dígitos parte decimal (Precisión) | ¿Es autoincremento? | ¿Es obligatorio? | ¿Es llave primeria o es parte de ella? |
|---|---|---|---|---|---|---|---|
| `id` | UUID | 36 | — | — | NO | SI | SI |
| `primerNombre` | VARCHAR | 50 | — | — | NO | SI | NO |
| `segundoNombre` | VARCHAR | 50 | — | — | NO | NO | NO |
| `primerApellido` | VARCHAR | 50 | — | — | NO | SI | NO |
| `segundoApellido` | VARCHAR | 50 | — | — | NO | NO | NO |
| `prefijo` | UUID | 36 | — | — | NO | SI | NO |
| `celular` | VARCHAR | 15 | — | — | NO | SI | NO |
| `elNumeroCelularEsCorrecto` | BOOLEAN | — | — | — | NO | SI | NO |
| `vigente` | BOOLEAN | — | — | — | NO | SI | NO |
| `sedeDeTrabajo` | UUID | 36 | — | — | NO | SI | NO |

#### Llave foránea, restricciones y alias

| Nombre | ¿Es llave foránea? | Entidad | Columna(s) | ¿Posee restricción de unicidad o es parte de ella? | Nombre restricción unicidad a la que pertenece | ¿Posee restricción de chequeo o es parte de ella? | Nombre restricción chequeo a la que pertenece | ¿Posee restricción de índice o es parte de ella? | Tipo | Nombre restricción índice a la que pertenece | Alias |
|---|---|---|---|---|---|---|---|---|---|---|---|
| `id` | NO | — | — | SI | PK_barbero | NO | — | NO | — | — | — |
| `primerNombre` | NO | — | — | NO | — | NO | — | NO | — | — | — |
| `segundoNombre` | NO | — | — | NO | — | NO | — | NO | — | — | — |
| `primerApellido` | NO | — | — | NO | — | NO | — | NO | — | — | — |
| `segundoApellido` | NO | — | — | NO | — | NO | — | NO | — | — | — |
| `prefijo` | SI | [PrefijoCelular](#prefijocelular) | id | SI | UQ_barbero_prefijo_celular | NO | — | NO | — | — | — |
| `celular` | NO | — | — | SI | UQ_barbero_prefijo_celular | NO | — | NO | — | — | — |
| `elNumeroCelularEsCorrecto` | NO | — | — | NO | — | NO | — | NO | — | — | — |
| `vigente` | NO | — | — | NO | — | NO | — | NO | — | — | — |
| `sedeDeTrabajo` | SI | [Sede](#sede) | id | NO | — | NO | — | NO | — | — | — |

#### Descripción del campo

| Nombre | Descripción del campo |
|---|---|
| `id` | Identificador único del registro que es generado por la aplicación. |
| `primerNombre` | Primer nombre del barbero. |
| `segundoNombre` | Segundo nombre del barbero. Campo opcional. |
| `primerApellido` | Primer apellido del barbero. |
| `segundoApellido` | Segundo apellido del barbero. Campo opcional. |
| `prefijo` | Referencia al prefijo de país del número de celular del barbero. Único en combinación con celular. |
| `celular` | Número de celular del barbero, con el que lo contacta el cliente. Único en combinación con prefijo. |
| `elNumeroCelularEsCorrecto` | Indica si el número de celular registrado para el barbero es correcto. |
| `vigente` | Indica si el barbero sigue trabajando en la barbería. |
| `sedeDeTrabajo` | Referencia a la sede, y por medio de ella a la barbería, en la que trabaja el barbero. |

### Clave primaria

- Atributo `id` (UUID, longitud 36). Restricción: `PK_barbero`. ¿Es autoincremento?: NO.

### Claves foráneas

| Atributo | Tabla referenciada | Columna(s) referenciada(s) | ¿Es obligatorio? | Restricción de unicidad en la que participa |
|---|---|---|---|---|
| `prefijo` | [PrefijoCelular](#prefijocelular) | `id` | SI | `UQ_barbero_prefijo_celular` |
| `sedeDeTrabajo` | [Sede](#sede) | `id` | SI | Ninguna |

### Restricciones

#### Restricciones de unicidad

- `PK_barbero` (clave primaria): `id`.
- `UQ_barbero_prefijo_celular`: `prefijo`, `celular`.

#### Restricciones de chequeo

No tiene restricciones de chequeo.

#### Restricciones de índice

No tiene restricciones de índice.

#### Obligatoriedad

- Obligatorios: `id`, `primerNombre`, `primerApellido`, `prefijo`, `celular`, `elNumeroCelularEsCorrecto`, `vigente`, `sedeDeTrabajo`.
- Opcionales: `segundoNombre`, `segundoApellido`.

### Relaciones

Se listan las relaciones que establecen las claves foráneas. Ver también [Relaciones del modelo entidad-relación](#relaciones-del-modelo-entidad-relación).

#### Tablas que referencia

- `Barbero.prefijo` → [PrefijoCelular](#prefijocelular).`id`
- `Barbero.sedeDeTrabajo` → [Sede](#sede).`id`

#### Tablas que la referencian

- [Bloqueo](#bloqueo).`barbero` → `Barbero.id`
- [BarberoServicio](#barberoservicio).`barbero` → `Barbero.id`
- [HorarioBarbero](#horariobarbero).`barbero` → `Barbero.id`

[↑ Volver al índice](#tablas)

---

## Cliente

**Descripción:** Entidad que almacena la información de las personas que solicitan citas en las sedes de las barberías. Su estado de veto no se guarda como columna: se obtiene por medio de una vista a partir de sus multas sin pagar.  
**Clasificación:** Entidad.  
**Número de atributos:** 8.

### Atributos

#### Definición técnica

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Cantidad dígitos parte decimal (Precisión) | ¿Es autoincremento? | ¿Es obligatorio? | ¿Es llave primeria o es parte de ella? |
|---|---|---|---|---|---|---|---|
| `id` | UUID | 36 | — | — | NO | SI | SI |
| `primerNombre` | VARCHAR | 50 | — | — | NO | SI | NO |
| `segundoNombre` | VARCHAR | 50 | — | — | NO | NO | NO |
| `primerApellido` | VARCHAR | 50 | — | — | NO | SI | NO |
| `segundoApellido` | VARCHAR | 50 | — | — | NO | NO | NO |
| `prefijoCelular` | UUID | 36 | — | — | NO | SI | NO |
| `celular` | VARCHAR | 15 | — | — | NO | SI | NO |
| `elNumeroCelularEsCorrecto` | BOOLEAN | — | — | — | NO | SI | NO |

#### Llave foránea, restricciones y alias

| Nombre | ¿Es llave foránea? | Entidad | Columna(s) | ¿Posee restricción de unicidad o es parte de ella? | Nombre restricción unicidad a la que pertenece | ¿Posee restricción de chequeo o es parte de ella? | Nombre restricción chequeo a la que pertenece | ¿Posee restricción de índice o es parte de ella? | Tipo | Nombre restricción índice a la que pertenece | Alias |
|---|---|---|---|---|---|---|---|---|---|---|---|
| `id` | NO | — | — | SI | PK_cliente | NO | — | NO | — | — | — |
| `primerNombre` | NO | — | — | NO | — | NO | — | NO | — | — | — |
| `segundoNombre` | NO | — | — | NO | — | NO | — | NO | — | — | — |
| `primerApellido` | NO | — | — | NO | — | NO | — | NO | — | — | — |
| `segundoApellido` | NO | — | — | NO | — | NO | — | NO | — | — | — |
| `prefijoCelular` | SI | [PrefijoCelular](#prefijocelular) | id | SI | UQ_cliente_prefijoCelular_celular | NO | — | NO | — | — | — |
| `celular` | NO | — | — | SI | UQ_cliente_prefijoCelular_celular | NO | — | NO | — | — | — |
| `elNumeroCelularEsCorrecto` | NO | — | — | NO | — | NO | — | NO | — | — | — |

#### Descripción del campo

| Nombre | Descripción del campo |
|---|---|
| `id` | Identificador único del registro que es generado por la aplicación. |
| `primerNombre` | Primer nombre del cliente. |
| `segundoNombre` | Segundo nombre del cliente. Campo opcional. |
| `primerApellido` | Primer apellido del cliente. |
| `segundoApellido` | Segundo apellido del cliente. Campo opcional. |
| `prefijoCelular` | Referencia al prefijo de país del número de celular del cliente. Único en combinación con celular. |
| `celular` | Número de celular del cliente, con el que lo contacta el barbero. Único en combinación con prefijoCelular. |
| `elNumeroCelularEsCorrecto` | Indica si el número de celular que registró el cliente es correcto. |

### Clave primaria

- Atributo `id` (UUID, longitud 36). Restricción: `PK_cliente`. ¿Es autoincremento?: NO.

### Claves foráneas

| Atributo | Tabla referenciada | Columna(s) referenciada(s) | ¿Es obligatorio? | Restricción de unicidad en la que participa |
|---|---|---|---|---|
| `prefijoCelular` | [PrefijoCelular](#prefijocelular) | `id` | SI | `UQ_cliente_prefijoCelular_celular` |

### Restricciones

#### Restricciones de unicidad

- `PK_cliente` (clave primaria): `id`.
- `UQ_cliente_prefijoCelular_celular`: `prefijoCelular`, `celular`.

#### Restricciones de chequeo

No tiene restricciones de chequeo.

#### Restricciones de índice

No tiene restricciones de índice.

#### Obligatoriedad

- Obligatorios: `id`, `primerNombre`, `primerApellido`, `prefijoCelular`, `celular`, `elNumeroCelularEsCorrecto`.
- Opcionales: `segundoNombre`, `segundoApellido`.

### Relaciones

Se listan las relaciones que establecen las claves foráneas. Ver también [Relaciones del modelo entidad-relación](#relaciones-del-modelo-entidad-relación).

#### Tablas que referencia

- `Cliente.prefijoCelular` → [PrefijoCelular](#prefijocelular).`id`

#### Tablas que la referencian

- [Cita](#cita).`cliente` → `Cliente.id`

[↑ Volver al índice](#tablas)

---

## HorarioSede

**Descripción:** Entidad que registra los horarios de apertura y cierre de cada sede para cada día de la semana; una sede puede tener varios horarios el mismo día (jornada partida) si no se cruzan, y son el límite dentro del cual debe caber el horario de cualquier barbero de esa sede.  
**Clasificación:** Entidad.  
**Número de atributos:** 8.

### Atributos

#### Definición técnica

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Cantidad dígitos parte decimal (Precisión) | ¿Es autoincremento? | ¿Es obligatorio? | ¿Es llave primeria o es parte de ella? |
|---|---|---|---|---|---|---|---|
| `id` | UUID | 36 | — | — | NO | SI | SI |
| `sede` | UUID | 36 | — | — | NO | SI | NO |
| `diaDeLaSemana` | UUID | 36 | — | — | NO | SI | NO |
| `horaApertura` | TIME | — | — | — | NO | SI | NO |
| `horaCierre` | TIME | — | — | — | NO | SI | NO |
| `fechaCreacion` | DATE | — | — | — | NO | SI | NO |
| `fechaDesactivacion` | DATE | — | — | — | NO | NO | NO |
| `vigente` | BOOLEAN | — | — | — | NO | SI | NO |

#### Llave foránea, restricciones y alias

| Nombre | ¿Es llave foránea? | Entidad | Columna(s) | ¿Posee restricción de unicidad o es parte de ella? | Nombre restricción unicidad a la que pertenece | ¿Posee restricción de chequeo o es parte de ella? | Nombre restricción chequeo a la que pertenece | ¿Posee restricción de índice o es parte de ella? | Tipo | Nombre restricción índice a la que pertenece | Alias |
|---|---|---|---|---|---|---|---|---|---|---|---|
| `id` | NO | — | — | SI | PK_horarioSede | NO | — | NO | — | — | — |
| `sede` | SI | [Sede](#sede) | id | SI | UQ_horarioSede_horario | NO | — | NO | — | — | — |
| `diaDeLaSemana` | SI | [DiaSemana](#diasemana) | id | SI | UQ_horarioSede_horario | NO | — | NO | — | — | — |
| `horaApertura` | NO | — | — | SI | UQ_horarioSede_horario | NO | — | NO | — | — | — |
| `horaCierre` | NO | — | — | SI | UQ_horarioSede_horario | NO | — | NO | — | — | — |
| `fechaCreacion` | NO | — | — | SI | UQ_horarioSede_horario | NO | — | NO | — | — | — |
| `fechaDesactivacion` | NO | — | — | SI | UQ_horarioSede_horario | NO | — | NO | — | — | — |
| `vigente` | NO | — | — | NO | — | NO | — | NO | — | — | — |

#### Descripción del campo

| Nombre | Descripción del campo |
|---|---|
| `id` | Identificador único del registro que es generado por la aplicación. |
| `sede` | Referencia a la sede de la barbería a la que pertenece este horario de apertura y cierre. |
| `diaDeLaSemana` | Referencia al día de la semana en el que abre la sede. |
| `horaApertura` | Hora a la que abre la sede en este horario. |
| `horaCierre` | Hora a la que cierra la sede en este horario. Debe ser mayor que horaApertura. |
| `fechaCreacion` | Fecha en la que el administrador definió este horario de la sede. La toma el sistema en ese momento. |
| `fechaDesactivacion` | Fecha en la que este horario dejó de estar vigente. La toma el sistema en ese momento. |
| `vigente` | Indica si este horario sigue vigente en la sede. Una vez desactivado no se puede volver a activar. |

### Clave primaria

- Atributo `id` (UUID, longitud 36). Restricción: `PK_horarioSede`. ¿Es autoincremento?: NO.

### Claves foráneas

| Atributo | Tabla referenciada | Columna(s) referenciada(s) | ¿Es obligatorio? | Restricción de unicidad en la que participa |
|---|---|---|---|---|
| `sede` | [Sede](#sede) | `id` | SI | `UQ_horarioSede_horario` |
| `diaDeLaSemana` | [DiaSemana](#diasemana) | `id` | SI | `UQ_horarioSede_horario` |

### Restricciones

#### Restricciones de unicidad

- `PK_horarioSede` (clave primaria): `id`.
- `UQ_horarioSede_horario`: `sede`, `diaDeLaSemana`, `horaApertura`, `horaCierre`, `fechaCreacion`, `fechaDesactivacion`.

#### Restricciones de chequeo

No tiene restricciones de chequeo.

#### Restricciones de índice

No tiene restricciones de índice.

#### Obligatoriedad

- Obligatorios: `id`, `sede`, `diaDeLaSemana`, `horaApertura`, `horaCierre`, `fechaCreacion`, `vigente`.
- Opcionales: `fechaDesactivacion`.

### Relaciones

Se listan las relaciones que establecen las claves foráneas. Ver también [Relaciones del modelo entidad-relación](#relaciones-del-modelo-entidad-relación).

#### Tablas que referencia

- `HorarioSede.sede` → [Sede](#sede).`id`
- `HorarioSede.diaDeLaSemana` → [DiaSemana](#diasemana).`id`

#### Tablas que la referencian

- [HorarioBarbero](#horariobarbero).`horarioDeLaSede` → `HorarioSede.id`

[↑ Volver al índice](#tablas)

---

## Bloqueo

**Descripción:** Entidad que registra los rangos de fecha y hora en los que un barbero no está disponible para atender sus citas.  
**Clasificación:** Entidad.  
**Número de atributos:** 4.

### Atributos

#### Definición técnica

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Cantidad dígitos parte decimal (Precisión) | ¿Es autoincremento? | ¿Es obligatorio? | ¿Es llave primeria o es parte de ella? |
|---|---|---|---|---|---|---|---|
| `id` | UUID | 36 | — | — | NO | SI | SI |
| `barbero` | UUID | 36 | — | — | NO | SI | NO |
| `fechaHoraInicio` | DATETIME | — | — | — | NO | SI | NO |
| `fechaHoraFinal` | DATETIME | — | — | — | NO | SI | NO |

#### Llave foránea, restricciones y alias

| Nombre | ¿Es llave foránea? | Entidad | Columna(s) | ¿Posee restricción de unicidad o es parte de ella? | Nombre restricción unicidad a la que pertenece | ¿Posee restricción de chequeo o es parte de ella? | Nombre restricción chequeo a la que pertenece | ¿Posee restricción de índice o es parte de ella? | Tipo | Nombre restricción índice a la que pertenece | Alias |
|---|---|---|---|---|---|---|---|---|---|---|---|
| `id` | NO | — | — | SI | PK_bloqueo | NO | — | NO | — | — | — |
| `barbero` | SI | [Barbero](#barbero) | id | SI | UQ_bloqueo_barbero_fechaHoras | NO | — | NO | — | — | — |
| `fechaHoraInicio` | NO | — | — | SI | UQ_bloqueo_barbero_fechaHoras | NO | — | NO | — | — | — |
| `fechaHoraFinal` | NO | — | — | SI | UQ_bloqueo_barbero_fechaHoras | NO | — | NO | — | — | — |

#### Descripción del campo

| Nombre | Descripción del campo |
|---|---|
| `id` | Identificador único del registro que es generado por la aplicación. |
| `barbero` | Referencia al barbero al que le pertenece este bloqueo. |
| `fechaHoraInicio` | Fecha y hora en la que el barbero deja de estar disponible para atender citas. |
| `fechaHoraFinal` | Fecha y hora en la que el barbero vuelve a estar disponible. Debe ser posterior a fechaHoraInicio. |

### Clave primaria

- Atributo `id` (UUID, longitud 36). Restricción: `PK_bloqueo`. ¿Es autoincremento?: NO.

### Claves foráneas

| Atributo | Tabla referenciada | Columna(s) referenciada(s) | ¿Es obligatorio? | Restricción de unicidad en la que participa |
|---|---|---|---|---|
| `barbero` | [Barbero](#barbero) | `id` | SI | `UQ_bloqueo_barbero_fechaHoras` |

### Restricciones

#### Restricciones de unicidad

- `PK_bloqueo` (clave primaria): `id`.
- `UQ_bloqueo_barbero_fechaHoras`: `barbero`, `fechaHoraInicio`, `fechaHoraFinal`.

#### Restricciones de chequeo

No tiene restricciones de chequeo.

#### Restricciones de índice

No tiene restricciones de índice.

#### Obligatoriedad

- Obligatorios: `id`, `barbero`, `fechaHoraInicio`, `fechaHoraFinal`.
- Opcionales: ninguno.

### Relaciones

Se listan las relaciones que establecen las claves foráneas. Ver también [Relaciones del modelo entidad-relación](#relaciones-del-modelo-entidad-relación).

#### Tablas que referencia

- `Bloqueo.barbero` → [Barbero](#barbero).`id`

#### Tablas que la referencian

Ninguna.

[↑ Volver al índice](#tablas)

---

## BarberoServicio

**Descripción:** Entidad asociativa que registra qué servicios sabe hacer cada barbero, cuánto tarda en realizarlos y cuánto tiempo extra reserva para ellos.  
**Clasificación:** Entidad asociativa (tabla intermedia).  
**Número de atributos:** 7.

### Atributos

#### Definición técnica

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Cantidad dígitos parte decimal (Precisión) | ¿Es autoincremento? | ¿Es obligatorio? | ¿Es llave primeria o es parte de ella? |
|---|---|---|---|---|---|---|---|
| `id` | UUID | 36 | — | — | NO | SI | SI |
| `barbero` | UUID | 36 | — | — | NO | SI | NO |
| `servicio` | UUID | 36 | — | — | NO | SI | NO |
| `duracionEnHoras` | INT | — | 1 | — | NO | SI | NO |
| `duracionEnMinutos` | INT | — | 2 | — | NO | SI | NO |
| `tiempoExtra` | INT | — | 2 | — | NO | SI | NO |
| `vigente` | BOOLEAN | — | — | — | NO | SI | NO |

#### Llave foránea, restricciones y alias

| Nombre | ¿Es llave foránea? | Entidad | Columna(s) | ¿Posee restricción de unicidad o es parte de ella? | Nombre restricción unicidad a la que pertenece | ¿Posee restricción de chequeo o es parte de ella? | Nombre restricción chequeo a la que pertenece | ¿Posee restricción de índice o es parte de ella? | Tipo | Nombre restricción índice a la que pertenece | Alias |
|---|---|---|---|---|---|---|---|---|---|---|---|
| `id` | NO | — | — | SI | PK_barberoServicio | NO | — | NO | — | — | — |
| `barbero` | SI | [Barbero](#barbero) | id | SI | UQ_barberoServicio_barbero_servicio | NO | — | NO | — | — | — |
| `servicio` | SI | [Servicio](#servicio) | id | SI | UQ_barberoServicio_barbero_servicio | NO | — | NO | — | — | — |
| `duracionEnHoras` | NO | — | — | NO | — | SI | CHK_barberoServicio_duracionEnHoras | NO | — | — | — |
| `duracionEnMinutos` | NO | — | — | NO | — | SI | CHK_barberoServicio_duracionEnMinutos | NO | — | — | — |
| `tiempoExtra` | NO | — | — | NO | — | SI | CHK_barberoServicio_tiempoExtra | NO | — | — | — |
| `vigente` | NO | — | — | NO | — | NO | — | NO | — | — | — |

#### Descripción del campo

| Nombre | Descripción del campo |
|---|---|
| `id` | Identificador único del registro que es generado por la aplicación. |
| `barbero` | Referencia al barbero que ofrece el servicio. Único en combinación con servicio. |
| `servicio` | Referencia al servicio del catálogo que el barbero sabe realizar. Único en combinación con barbero. |
| `duracionEnHoras` | Cantidad de horas que tarda el barbero en realizar el servicio. Debe estar entre 0 y 3. |
| `duracionEnMinutos` | Cantidad de minutos que tarda el barbero en realizar el servicio. Debe estar entre 0 y 59. |
| `tiempoExtra` | Minutos de colchón que el barbero reserva para este servicio. Debe estar entre 0 y 59. |
| `vigente` | Indica si el barbero sigue prestando este servicio en la barbería. |

### Clave primaria

- Atributo `id` (UUID, longitud 36). Restricción: `PK_barberoServicio`. ¿Es autoincremento?: NO.

### Claves foráneas

| Atributo | Tabla referenciada | Columna(s) referenciada(s) | ¿Es obligatorio? | Restricción de unicidad en la que participa |
|---|---|---|---|---|
| `barbero` | [Barbero](#barbero) | `id` | SI | `UQ_barberoServicio_barbero_servicio` |
| `servicio` | [Servicio](#servicio) | `id` | SI | `UQ_barberoServicio_barbero_servicio` |

### Restricciones

#### Restricciones de unicidad

- `PK_barberoServicio` (clave primaria): `id`.
- `UQ_barberoServicio_barbero_servicio`: `barbero`, `servicio`.

#### Restricciones de chequeo

- `CHK_barberoServicio_duracionEnHoras` sobre `duracionEnHoras`. Condición tal como aparece en la descripción del campo: «Cantidad de horas que tarda el barbero en realizar el servicio. Debe estar entre 0 y 3.»
- `CHK_barberoServicio_duracionEnMinutos` sobre `duracionEnMinutos`. Condición tal como aparece en la descripción del campo: «Cantidad de minutos que tarda el barbero en realizar el servicio. Debe estar entre 0 y 59.»
- `CHK_barberoServicio_tiempoExtra` sobre `tiempoExtra`. Condición tal como aparece en la descripción del campo: «Minutos de colchón que el barbero reserva para este servicio. Debe estar entre 0 y 59.»

#### Restricciones de índice

No tiene restricciones de índice.

#### Obligatoriedad

- Obligatorios: `id`, `barbero`, `servicio`, `duracionEnHoras`, `duracionEnMinutos`, `tiempoExtra`, `vigente`.
- Opcionales: ninguno.

### Relaciones

Se listan las relaciones que establecen las claves foráneas. Ver también [Relaciones del modelo entidad-relación](#relaciones-del-modelo-entidad-relación).

#### Tablas que referencia

- `BarberoServicio.barbero` → [Barbero](#barbero).`id`
- `BarberoServicio.servicio` → [Servicio](#servicio).`id`

#### Tablas que la referencian

- [CitaServicio](#citaservicio).`barberoServicio` → `BarberoServicio.id`

[↑ Volver al índice](#tablas)

---

## HorarioBarbero

**Descripción:** Entidad que registra la jornada de trabajo de un barbero dentro de un horario de su sede, con la hora en la que empieza, la hora en la que termina y su vigencia.  
**Clasificación:** Entidad.  
**Número de atributos:** 8.

### Atributos

#### Definición técnica

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Cantidad dígitos parte decimal (Precisión) | ¿Es autoincremento? | ¿Es obligatorio? | ¿Es llave primeria o es parte de ella? |
|---|---|---|---|---|---|---|---|
| `id` | UUID | 36 | — | — | NO | SI | SI |
| `barbero` | UUID | 36 | — | — | NO | SI | NO |
| `horarioDeLaSede` | UUID | 36 | — | — | NO | SI | NO |
| `horaInicio` | TIME | — | — | — | NO | SI | NO |
| `horaFinal` | TIME | — | — | — | NO | SI | NO |
| `fechaCreacion` | DATE | — | — | — | NO | SI | NO |
| `fechaDesactivacion` | DATE | — | — | — | NO | NO | NO |
| `vigente` | BOOLEAN | — | — | — | NO | SI | NO |

#### Llave foránea, restricciones y alias

| Nombre | ¿Es llave foránea? | Entidad | Columna(s) | ¿Posee restricción de unicidad o es parte de ella? | Nombre restricción unicidad a la que pertenece | ¿Posee restricción de chequeo o es parte de ella? | Nombre restricción chequeo a la que pertenece | ¿Posee restricción de índice o es parte de ella? | Tipo | Nombre restricción índice a la que pertenece | Alias |
|---|---|---|---|---|---|---|---|---|---|---|---|
| `id` | NO | — | — | SI | PK_horarioBarbero | NO | — | NO | — | — | — |
| `barbero` | SI | [Barbero](#barbero) | id | SI | UQ_horarioBarbero_barbero_horario | NO | — | NO | — | — | — |
| `horarioDeLaSede` | SI | [HorarioSede](#horariosede) | id | SI | UQ_horarioBarbero_barbero_horario | NO | — | NO | — | — | — |
| `horaInicio` | NO | — | — | SI | UQ_horarioBarbero_barbero_horario | NO | — | NO | — | — | — |
| `horaFinal` | NO | — | — | SI | UQ_horarioBarbero_barbero_horario | NO | — | NO | — | — | — |
| `fechaCreacion` | NO | — | — | SI | UQ_horarioBarbero_barbero_horario | NO | — | NO | — | — | — |
| `fechaDesactivacion` | NO | — | — | SI | UQ_horarioBarbero_barbero_horario | NO | — | NO | — | — | — |
| `vigente` | NO | — | — | NO | — | NO | — | NO | — | — | — |

#### Descripción del campo

| Nombre | Descripción del campo |
|---|---|
| `id` | Identificador único del registro que es generado por la aplicación. |
| `barbero` | Referencia al barbero dueño de este horario de trabajo. |
| `horarioDeLaSede` | Referencia al horario de la sede dentro del cual debe caber esta jornada del barbero. |
| `horaInicio` | Hora en la que el barbero empieza a estar disponible ese día. |
| `horaFinal` | Hora en la que el barbero deja de estar disponible ese día. Debe ser mayor que horaInicio. |
| `fechaCreacion` | Fecha en la que el barbero creó este horario de trabajo. |
| `fechaDesactivacion` | Fecha en la que este horario dejó de estar vigente. |
| `vigente` | Indica si el barbero sigue usando este horario de trabajo. |

### Clave primaria

- Atributo `id` (UUID, longitud 36). Restricción: `PK_horarioBarbero`. ¿Es autoincremento?: NO.

### Claves foráneas

| Atributo | Tabla referenciada | Columna(s) referenciada(s) | ¿Es obligatorio? | Restricción de unicidad en la que participa |
|---|---|---|---|---|
| `barbero` | [Barbero](#barbero) | `id` | SI | `UQ_horarioBarbero_barbero_horario` |
| `horarioDeLaSede` | [HorarioSede](#horariosede) | `id` | SI | `UQ_horarioBarbero_barbero_horario` |

### Restricciones

#### Restricciones de unicidad

- `PK_horarioBarbero` (clave primaria): `id`.
- `UQ_horarioBarbero_barbero_horario`: `barbero`, `horarioDeLaSede`, `horaInicio`, `horaFinal`, `fechaCreacion`, `fechaDesactivacion`.

#### Restricciones de chequeo

No tiene restricciones de chequeo.

#### Restricciones de índice

No tiene restricciones de índice.

#### Obligatoriedad

- Obligatorios: `id`, `barbero`, `horarioDeLaSede`, `horaInicio`, `horaFinal`, `fechaCreacion`, `vigente`.
- Opcionales: `fechaDesactivacion`.

### Relaciones

Se listan las relaciones que establecen las claves foráneas. Ver también [Relaciones del modelo entidad-relación](#relaciones-del-modelo-entidad-relación).

#### Tablas que referencia

- `HorarioBarbero.barbero` → [Barbero](#barbero).`id`
- `HorarioBarbero.horarioDeLaSede` → [HorarioSede](#horariosede).`id`

#### Tablas que la referencian

- [Agenda](#agenda).`horarioDelBarbero` → `HorarioBarbero.id`

[↑ Volver al índice](#tablas)

---

## Agenda

**Descripción:** Entidad que representa el día concreto de trabajo de un barbero, según su horario, en el que se agrupan todas las citas de ese día.  
**Clasificación:** Entidad.  
**Número de atributos:** 3.

### Atributos

#### Definición técnica

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Cantidad dígitos parte decimal (Precisión) | ¿Es autoincremento? | ¿Es obligatorio? | ¿Es llave primeria o es parte de ella? |
|---|---|---|---|---|---|---|---|
| `id` | UUID | 36 | — | — | NO | SI | SI |
| `horarioDelBarbero` | UUID | 36 | — | — | NO | SI | NO |
| `fecha` | DATE | — | — | — | NO | SI | NO |

#### Llave foránea, restricciones y alias

| Nombre | ¿Es llave foránea? | Entidad | Columna(s) | ¿Posee restricción de unicidad o es parte de ella? | Nombre restricción unicidad a la que pertenece | ¿Posee restricción de chequeo o es parte de ella? | Nombre restricción chequeo a la que pertenece | ¿Posee restricción de índice o es parte de ella? | Tipo | Nombre restricción índice a la que pertenece | Alias |
|---|---|---|---|---|---|---|---|---|---|---|---|
| `id` | NO | — | — | SI | PK_agenda | NO | — | NO | — | — | — |
| `horarioDelBarbero` | SI | [HorarioBarbero](#horariobarbero) | id | SI | UQ_agenda_horarioDelBarbero_fecha | NO | — | NO | — | — | — |
| `fecha` | NO | — | — | SI | UQ_agenda_horarioDelBarbero_fecha | NO | — | NO | — | — | — |

#### Descripción del campo

| Nombre | Descripción del campo |
|---|---|
| `id` | Identificador único del registro que es generado por la aplicación. |
| `horarioDelBarbero` | Referencia al horario de trabajo del barbero al que pertenece esta agenda. Único en combinación con fecha. |
| `fecha` | Fecha concreta para la que esta agenda recibe las citas del barbero. Única en combinación con horarioDelBarbero. |

### Clave primaria

- Atributo `id` (UUID, longitud 36). Restricción: `PK_agenda`. ¿Es autoincremento?: NO.

### Claves foráneas

| Atributo | Tabla referenciada | Columna(s) referenciada(s) | ¿Es obligatorio? | Restricción de unicidad en la que participa |
|---|---|---|---|---|
| `horarioDelBarbero` | [HorarioBarbero](#horariobarbero) | `id` | SI | `UQ_agenda_horarioDelBarbero_fecha` |

### Restricciones

#### Restricciones de unicidad

- `PK_agenda` (clave primaria): `id`.
- `UQ_agenda_horarioDelBarbero_fecha`: `horarioDelBarbero`, `fecha`.

#### Restricciones de chequeo

No tiene restricciones de chequeo.

#### Restricciones de índice

No tiene restricciones de índice.

#### Obligatoriedad

- Obligatorios: `id`, `horarioDelBarbero`, `fecha`.
- Opcionales: ninguno.

### Relaciones

Se listan las relaciones que establecen las claves foráneas. Ver también [Relaciones del modelo entidad-relación](#relaciones-del-modelo-entidad-relación).

#### Tablas que referencia

- `Agenda.horarioDelBarbero` → [HorarioBarbero](#horariobarbero).`id`

#### Tablas que la referencian

- [Cita](#cita).`agenda` → `Agenda.id`

[↑ Volver al índice](#tablas)

---

## Cita

**Descripción:** Entidad que registra la reserva de un cliente con un barbero para una fecha y hora concretas, con su estado y las condiciones de tolerancia, multa y descuento que quedan congeladas al agendar. La hora estimada de finalización y el precio total se obtienen por medio de vistas.  
**Clasificación:** Entidad.  
**Número de atributos:** 8.

### Atributos

#### Definición técnica

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Cantidad dígitos parte decimal (Precisión) | ¿Es autoincremento? | ¿Es obligatorio? | ¿Es llave primeria o es parte de ella? |
|---|---|---|---|---|---|---|---|
| `id` | UUID | 36 | — | — | NO | SI | SI |
| `cliente` | UUID | 36 | — | — | NO | SI | NO |
| `agenda` | UUID | 36 | — | — | NO | SI | NO |
| `estado` | UUID | 36 | — | — | NO | SI | NO |
| `horaInicio` | TIME | — | — | — | NO | SI | NO |
| `porcentajeDescuento` | INT | — | 3 | — | NO | SI | NO |
| `multa` | INT | — | 6 | — | NO | SI | NO |
| `tiempoEspera` | INT | — | 2 | — | NO | SI | NO |

#### Llave foránea, restricciones y alias

| Nombre | ¿Es llave foránea? | Entidad | Columna(s) | ¿Posee restricción de unicidad o es parte de ella? | Nombre restricción unicidad a la que pertenece | ¿Posee restricción de chequeo o es parte de ella? | Nombre restricción chequeo a la que pertenece | ¿Posee restricción de índice o es parte de ella? | Tipo | Nombre restricción índice a la que pertenece | Alias |
|---|---|---|---|---|---|---|---|---|---|---|---|
| `id` | NO | — | — | SI | PK_cita | NO | — | NO | — | — | — |
| `cliente` | SI | [Cliente](#cliente) | id | NO | — | NO | — | NO | — | — | — |
| `agenda` | SI | [Agenda](#agenda) | id | SI | UQ_cita_agenda_horaInicio | NO | — | NO | — | — | — |
| `estado` | SI | [Estado](#estado) | id | NO | — | NO | — | NO | — | — | — |
| `horaInicio` | NO | — | — | SI | UQ_cita_agenda_horaInicio | NO | — | NO | — | — | — |
| `porcentajeDescuento` | NO | — | — | NO | — | SI | CHK_cita_porcentajeDescuento | NO | — | — | — |
| `multa` | NO | — | — | NO | — | SI | CHK_cita_multa | NO | — | — | — |
| `tiempoEspera` | NO | — | — | NO | — | SI | CHK_cita_tiempoEspera | NO | — | — | — |

#### Descripción del campo

| Nombre | Descripción del campo |
|---|---|
| `id` | Identificador único del registro que es generado por la aplicación. |
| `cliente` | Referencia al cliente al que le pertenece esta cita. |
| `agenda` | Referencia a la agenda del barbero en la que queda esta cita. Única en combinación con horaInicio. |
| `estado` | Referencia al estado en el que se encuentra esta cita. |
| `horaInicio` | Hora en la que se le va a realizar la cita al cliente. Única en combinación con agenda. |
| `porcentajeDescuento` | Porcentaje de descuento que el barbero deja congelado en la cita por si se demora en atenderla. Debe estar entre 0 y 100. |
| `multa` | Valor de la sanción que se le cobra al cliente si su tardanza supera el tiempoEspera de esta cita. Debe estar entre 0 y 100.000. |
| `tiempoEspera` | Minutos de tolerancia que aplican por igual al cliente y al barbero en esta cita. Debe estar entre 0 y 60. |

### Clave primaria

- Atributo `id` (UUID, longitud 36). Restricción: `PK_cita`. ¿Es autoincremento?: NO.

### Claves foráneas

| Atributo | Tabla referenciada | Columna(s) referenciada(s) | ¿Es obligatorio? | Restricción de unicidad en la que participa |
|---|---|---|---|---|
| `cliente` | [Cliente](#cliente) | `id` | SI | Ninguna |
| `agenda` | [Agenda](#agenda) | `id` | SI | `UQ_cita_agenda_horaInicio` |
| `estado` | [Estado](#estado) | `id` | SI | Ninguna |

### Restricciones

#### Restricciones de unicidad

- `PK_cita` (clave primaria): `id`.
- `UQ_cita_agenda_horaInicio`: `agenda`, `horaInicio`.

#### Restricciones de chequeo

- `CHK_cita_porcentajeDescuento` sobre `porcentajeDescuento`. Condición tal como aparece en la descripción del campo: «Porcentaje de descuento que el barbero deja congelado en la cita por si se demora en atenderla. Debe estar entre 0 y 100.»
- `CHK_cita_multa` sobre `multa`. Condición tal como aparece en la descripción del campo: «Valor de la sanción que se le cobra al cliente si su tardanza supera el tiempoEspera de esta cita. Debe estar entre 0 y 100.000.»
- `CHK_cita_tiempoEspera` sobre `tiempoEspera`. Condición tal como aparece en la descripción del campo: «Minutos de tolerancia que aplican por igual al cliente y al barbero en esta cita. Debe estar entre 0 y 60.»

#### Restricciones de índice

No tiene restricciones de índice.

#### Obligatoriedad

- Obligatorios: `id`, `cliente`, `agenda`, `estado`, `horaInicio`, `porcentajeDescuento`, `multa`, `tiempoEspera`.
- Opcionales: ninguno.

### Relaciones

Se listan las relaciones que establecen las claves foráneas. Ver también [Relaciones del modelo entidad-relación](#relaciones-del-modelo-entidad-relación).

#### Tablas que referencia

- `Cita.cliente` → [Cliente](#cliente).`id`
- `Cita.agenda` → [Agenda](#agenda).`id`
- `Cita.estado` → [Estado](#estado).`id`

#### Tablas que la referencian

- [CitaServicio](#citaservicio).`cita` → `Cita.id`
- [Multa](#multa).`cita` → `Cita.id`

### Vistas

Datos calculados de esta tabla que no se guardan como columnas, sino que se obtienen por medio de vistas.

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Tabla(s) de origen | Cálculo | Descripción del campo |
|---|---|---|---|---|---|---|
| `horaFinEstimada` | TIME | — | — | Cita, CitaServicio | Cita.horaInicio + suma, en minutos, de (duracionEnHorasElServicio × 60 + duracionEnMinutosElServicio) de todos los CitaServicio de la cita. | Hora en la que se espera que termine la cita. Debe quedar dentro del horario de trabajo del barbero. |
| `precioTotal` | INT | — | 7 | Cita, CitaServicio, Estado | Suma de CitaServicio.precioServicio de la cita. Si el estado de la cita es "El barbero se demoro", se aplica el descuento: suma × (100 − porcentajeDescuento) / 100; en cualquier otro estado se cobra la suma completa. | Valor que debe pagar el cliente por los servicios de la cita. Debe estar entre 0 y 3.000.000. |

[↑ Volver al índice](#tablas)

---

## CitaServicio

**Descripción:** Entidad asociativa que registra cada servicio incluido dentro de una cita, congelando el precio y la duración que tenía ese servicio para ese barbero en el momento de agendarla.  
**Clasificación:** Entidad asociativa (tabla intermedia).  
**Número de atributos:** 7.

### Atributos

#### Definición técnica

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Cantidad dígitos parte decimal (Precisión) | ¿Es autoincremento? | ¿Es obligatorio? | ¿Es llave primeria o es parte de ella? |
|---|---|---|---|---|---|---|---|
| `id` | UUID | 36 | — | — | NO | SI | SI |
| `cita` | UUID | 36 | — | — | NO | SI | NO |
| `barberoServicio` | UUID | 36 | — | — | NO | SI | NO |
| `precioServicio` | INT | — | 7 | — | NO | SI | NO |
| `duracionEnHorasElServicio` | INT | — | 1 | — | NO | SI | NO |
| `duracionEnMinutosElServicio` | INT | — | 2 | — | NO | SI | NO |
| `tiempoExtra` | INT | — | 2 | — | NO | SI | NO |

#### Llave foránea, restricciones y alias

| Nombre | ¿Es llave foránea? | Entidad | Columna(s) | ¿Posee restricción de unicidad o es parte de ella? | Nombre restricción unicidad a la que pertenece | ¿Posee restricción de chequeo o es parte de ella? | Nombre restricción chequeo a la que pertenece | ¿Posee restricción de índice o es parte de ella? | Tipo | Nombre restricción índice a la que pertenece | Alias |
|---|---|---|---|---|---|---|---|---|---|---|---|
| `id` | NO | — | — | SI | PK_citaServicio | NO | — | NO | — | — | — |
| `cita` | SI | [Cita](#cita) | id | SI | UQ_citaServicio_cita_barberoServicio | NO | — | NO | — | — | — |
| `barberoServicio` | SI | [BarberoServicio](#barberoservicio) | id | SI | UQ_citaServicio_cita_barberoServicio | NO | — | NO | — | — | — |
| `precioServicio` | NO | — | — | NO | — | SI | CHK_citaServicio_precioServicio | NO | — | — | — |
| `duracionEnHorasElServicio` | NO | — | — | NO | — | SI | CHK_citaServicio_duracionEnHorasElServicio | NO | — | — | — |
| `duracionEnMinutosElServicio` | NO | — | — | NO | — | SI | CHK_citaServicio_duracionEnMinutosElServicio | NO | — | — | — |
| `tiempoExtra` | NO | — | — | NO | — | SI | CHK_citaServicio_tiempoExtra | NO | — | — | — |

#### Descripción del campo

| Nombre | Descripción del campo |
|---|---|
| `id` | Identificador único del registro que es generado por la aplicación. |
| `cita` | Referencia a la cita a la que pertenece este servicio pedido. Única en combinación con barberoServicio. |
| `barberoServicio` | Referencia al servicio del barbero que se pidió en esta cita. Única en combinación con cita. |
| `precioServicio` | Precio que tenía el servicio en el momento en que se agendó la cita. Debe estar entre 0 y 2.000.000. |
| `duracionEnHorasElServicio` | Duración en horas que tenía el servicio para ese barbero en el momento de agendar la cita. Debe estar entre 0 y 3. |
| `duracionEnMinutosElServicio` | Duración en minutos que tenía el servicio para ese barbero en el momento de agendar la cita. Debe estar entre 0 y 59. |
| `tiempoExtra` | Tiempo extra en minutos que el barbero tenía configurado para este servicio al agendar la cita. Debe estar entre 0 y 59. |

### Clave primaria

- Atributo `id` (UUID, longitud 36). Restricción: `PK_citaServicio`. ¿Es autoincremento?: NO.

### Claves foráneas

| Atributo | Tabla referenciada | Columna(s) referenciada(s) | ¿Es obligatorio? | Restricción de unicidad en la que participa |
|---|---|---|---|---|
| `cita` | [Cita](#cita) | `id` | SI | `UQ_citaServicio_cita_barberoServicio` |
| `barberoServicio` | [BarberoServicio](#barberoservicio) | `id` | SI | `UQ_citaServicio_cita_barberoServicio` |

### Restricciones

#### Restricciones de unicidad

- `PK_citaServicio` (clave primaria): `id`.
- `UQ_citaServicio_cita_barberoServicio`: `cita`, `barberoServicio`.

#### Restricciones de chequeo

- `CHK_citaServicio_precioServicio` sobre `precioServicio`. Condición tal como aparece en la descripción del campo: «Precio que tenía el servicio en el momento en que se agendó la cita. Debe estar entre 0 y 2.000.000.»
- `CHK_citaServicio_duracionEnHorasElServicio` sobre `duracionEnHorasElServicio`. Condición tal como aparece en la descripción del campo: «Duración en horas que tenía el servicio para ese barbero en el momento de agendar la cita. Debe estar entre 0 y 3.»
- `CHK_citaServicio_duracionEnMinutosElServicio` sobre `duracionEnMinutosElServicio`. Condición tal como aparece en la descripción del campo: «Duración en minutos que tenía el servicio para ese barbero en el momento de agendar la cita. Debe estar entre 0 y 59.»
- `CHK_citaServicio_tiempoExtra` sobre `tiempoExtra`. Condición tal como aparece en la descripción del campo: «Tiempo extra en minutos que el barbero tenía configurado para este servicio al agendar la cita. Debe estar entre 0 y 59.»

#### Restricciones de índice

No tiene restricciones de índice.

#### Obligatoriedad

- Obligatorios: `id`, `cita`, `barberoServicio`, `precioServicio`, `duracionEnHorasElServicio`, `duracionEnMinutosElServicio`, `tiempoExtra`.
- Opcionales: ninguno.

### Relaciones

Se listan las relaciones que establecen las claves foráneas. Ver también [Relaciones del modelo entidad-relación](#relaciones-del-modelo-entidad-relación).

#### Tablas que referencia

- `CitaServicio.cita` → [Cita](#cita).`id`
- `CitaServicio.barberoServicio` → [BarberoServicio](#barberoservicio).`id`

#### Tablas que la referencian

Ninguna.

[↑ Volver al índice](#tablas)

---

## Multa

**Descripción:** Entidad que registra la sanción económica impuesta a un cliente por incumplir una cita, ya sea por tardanza, por inasistencia o por no pagarla, con su monto y su estado de pago.  
**Clasificación:** Entidad.  
**Número de atributos:** 7.

### Atributos

#### Definición técnica

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Cantidad dígitos parte decimal (Precisión) | ¿Es autoincremento? | ¿Es obligatorio? | ¿Es llave primeria o es parte de ella? |
|---|---|---|---|---|---|---|---|
| `id` | UUID | 36 | — | — | NO | SI | SI |
| `cita` | UUID | 36 | — | — | NO | SI | NO |
| `tipo` | UUID | 36 | — | — | NO | SI | NO |
| `monto` | INT | — | 7 | — | NO | SI | NO |
| `horaGeneracion` | TIME | — | — | — | NO | SI | NO |
| `fechaHoraPago` | DATETIME | — | — | — | NO | NO | NO |
| `pagada` | BOOLEAN | — | — | — | NO | SI | NO |

#### Llave foránea, restricciones y alias

| Nombre | ¿Es llave foránea? | Entidad | Columna(s) | ¿Posee restricción de unicidad o es parte de ella? | Nombre restricción unicidad a la que pertenece | ¿Posee restricción de chequeo o es parte de ella? | Nombre restricción chequeo a la que pertenece | ¿Posee restricción de índice o es parte de ella? | Tipo | Nombre restricción índice a la que pertenece | Alias |
|---|---|---|---|---|---|---|---|---|---|---|---|
| `id` | NO | — | — | SI | PK_multa | NO | — | NO | — | — | — |
| `cita` | SI | [Cita](#cita) | id | SI | UQ_multa_cita | NO | — | NO | — | — | — |
| `tipo` | SI | [TipoMulta](#tipomulta) | id | NO | — | NO | — | NO | — | — | — |
| `monto` | NO | — | — | NO | — | SI | CHK_multa_monto | NO | — | — | — |
| `horaGeneracion` | NO | — | — | NO | — | NO | — | NO | — | — | — |
| `fechaHoraPago` | NO | — | — | NO | — | NO | — | NO | — | — | — |
| `pagada` | NO | — | — | NO | — | NO | — | NO | — | — | — |

#### Descripción del campo

| Nombre | Descripción del campo |
|---|---|
| `id` | Identificador único del registro que es generado por la aplicación. |
| `cita` | Referencia a la cita que el cliente incumplió y que originó la multa. Única por multa. |
| `tipo` | Referencia al tipo de multa que se le impuso al cliente: tardanza, inasistencia o no pagado. |
| `monto` | Valor en pesos colombianos que debe pagar el cliente por esta multa. Debe estar entre 0 y 1.000.000. |
| `horaGeneracion` | Hora en la que el sistema generó esta multa, dentro del día de la agenda de la cita que la originó. |
| `fechaHoraPago` | Fecha y hora en la que el cliente pagó esta multa. |
| `pagada` | Indica si el cliente ya pagó esta multa; es el dato con el que se decide si queda vetado. |

### Clave primaria

- Atributo `id` (UUID, longitud 36). Restricción: `PK_multa`. ¿Es autoincremento?: NO.

### Claves foráneas

| Atributo | Tabla referenciada | Columna(s) referenciada(s) | ¿Es obligatorio? | Restricción de unicidad en la que participa |
|---|---|---|---|---|
| `cita` | [Cita](#cita) | `id` | SI | `UQ_multa_cita` |
| `tipo` | [TipoMulta](#tipomulta) | `id` | SI | Ninguna |

### Restricciones

#### Restricciones de unicidad

- `PK_multa` (clave primaria): `id`.
- `UQ_multa_cita`: `cita`.

#### Restricciones de chequeo

- `CHK_multa_monto` sobre `monto`. Condición tal como aparece en la descripción del campo: «Valor en pesos colombianos que debe pagar el cliente por esta multa. Debe estar entre 0 y 1.000.000.»

#### Restricciones de índice

No tiene restricciones de índice.

#### Obligatoriedad

- Obligatorios: `id`, `cita`, `tipo`, `monto`, `horaGeneracion`, `pagada`.
- Opcionales: `fechaHoraPago`.

### Relaciones

Se listan las relaciones que establecen las claves foráneas. Ver también [Relaciones del modelo entidad-relación](#relaciones-del-modelo-entidad-relación).

#### Tablas que referencia

- `Multa.cita` → [Cita](#cita).`id`
- `Multa.tipo` → [TipoMulta](#tipomulta).`id`

#### Tablas que la referencian

Ninguna.

[↑ Volver al índice](#tablas)

---

## Departamento

**Descripción:** Catálogo de los departamentos del país en los que se ubican las ciudades donde una barbería puede tener sedes.  
**Clasificación:** Catálogo.  
**Número de atributos:** 2.

### Atributos

#### Definición técnica

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Cantidad dígitos parte decimal (Precisión) | ¿Es autoincremento? | ¿Es obligatorio? | ¿Es llave primeria o es parte de ella? |
|---|---|---|---|---|---|---|---|
| `id` | UUID | 36 | — | — | NO | SI | SI |
| `nombre` | VARCHAR | 60 | — | — | NO | SI | NO |

#### Llave foránea, restricciones y alias

| Nombre | ¿Es llave foránea? | Entidad | Columna(s) | ¿Posee restricción de unicidad o es parte de ella? | Nombre restricción unicidad a la que pertenece | ¿Posee restricción de chequeo o es parte de ella? | Nombre restricción chequeo a la que pertenece | ¿Posee restricción de índice o es parte de ella? | Tipo | Nombre restricción índice a la que pertenece | Alias |
|---|---|---|---|---|---|---|---|---|---|---|---|
| `id` | NO | — | — | SI | PK_departamento | NO | — | NO | — | — | — |
| `nombre` | NO | — | — | SI | UQ_departamento_nombre | NO | — | NO | — | — | — |

#### Descripción del campo

| Nombre | Descripción del campo |
|---|---|
| `id` | Identificador único del registro que es generado por la aplicación. |
| `nombre` | Nombre del departamento en el que se ubican las ciudades donde una barbería puede tener sedes. Debe ser único en el sistema. |

### Clave primaria

- Atributo `id` (UUID, longitud 36). Restricción: `PK_departamento`. ¿Es autoincremento?: NO.

### Claves foráneas

No tiene claves foráneas.

### Restricciones

#### Restricciones de unicidad

- `PK_departamento` (clave primaria): `id`.
- `UQ_departamento_nombre`: `nombre`.

#### Restricciones de chequeo

No tiene restricciones de chequeo.

#### Restricciones de índice

No tiene restricciones de índice.

#### Obligatoriedad

- Obligatorios: `id`, `nombre`.
- Opcionales: ninguno.

### Relaciones

Se listan las relaciones que establecen las claves foráneas. Ver también [Relaciones del modelo entidad-relación](#relaciones-del-modelo-entidad-relación).

#### Tablas que referencia

Ninguna.

#### Tablas que la referencian

- [Ciudad](#ciudad).`departamento` → `Departamento.id`

[↑ Volver al índice](#tablas)

---

## Ciudad

**Descripción:** Entidad que almacena las ciudades, cada una perteneciente a un departamento, en las que puede estar ubicada una sede.  
**Clasificación:** Entidad.  
**Número de atributos:** 3.

### Atributos

#### Definición técnica

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Cantidad dígitos parte decimal (Precisión) | ¿Es autoincremento? | ¿Es obligatorio? | ¿Es llave primeria o es parte de ella? |
|---|---|---|---|---|---|---|---|
| `id` | UUID | 36 | — | — | NO | SI | SI |
| `nombre` | VARCHAR | 30 | — | — | NO | SI | NO |
| `departamento` | UUID | 36 | — | — | NO | SI | NO |

#### Llave foránea, restricciones y alias

| Nombre | ¿Es llave foránea? | Entidad | Columna(s) | ¿Posee restricción de unicidad o es parte de ella? | Nombre restricción unicidad a la que pertenece | ¿Posee restricción de chequeo o es parte de ella? | Nombre restricción chequeo a la que pertenece | ¿Posee restricción de índice o es parte de ella? | Tipo | Nombre restricción índice a la que pertenece | Alias |
|---|---|---|---|---|---|---|---|---|---|---|---|
| `id` | NO | — | — | SI | PK_ciudad | NO | — | NO | — | — | — |
| `nombre` | NO | — | — | SI | UQ_ciudad_nombre_departamento | NO | — | NO | — | — | — |
| `departamento` | SI | [Departamento](#departamento) | id | SI | UQ_ciudad_nombre_departamento | NO | — | NO | — | — | — |

#### Descripción del campo

| Nombre | Descripción del campo |
|---|---|
| `id` | Identificador único del registro que es generado por la aplicación. |
| `nombre` | Nombre de la ciudad en la que puede estar ubicada una sede. No puede repetirse dentro de un mismo departamento (único en combinación con departamento). |
| `departamento` | Referencia al departamento al que pertenece la ciudad. Único en combinación con nombre. |

### Clave primaria

- Atributo `id` (UUID, longitud 36). Restricción: `PK_ciudad`. ¿Es autoincremento?: NO.

### Claves foráneas

| Atributo | Tabla referenciada | Columna(s) referenciada(s) | ¿Es obligatorio? | Restricción de unicidad en la que participa |
|---|---|---|---|---|
| `departamento` | [Departamento](#departamento) | `id` | SI | `UQ_ciudad_nombre_departamento` |

### Restricciones

#### Restricciones de unicidad

- `PK_ciudad` (clave primaria): `id`.
- `UQ_ciudad_nombre_departamento`: `nombre`, `departamento`.

#### Restricciones de chequeo

No tiene restricciones de chequeo.

#### Restricciones de índice

No tiene restricciones de índice.

#### Obligatoriedad

- Obligatorios: `id`, `nombre`, `departamento`.
- Opcionales: ninguno.

### Relaciones

Se listan las relaciones que establecen las claves foráneas. Ver también [Relaciones del modelo entidad-relación](#relaciones-del-modelo-entidad-relación).

#### Tablas que referencia

- `Ciudad.departamento` → [Departamento](#departamento).`id`

#### Tablas que la referencian

- [Sede](#sede).`ciudad` → `Ciudad.id`

[↑ Volver al índice](#tablas)

---

## Barberia

**Descripción:** Entidad que almacena las barberías registradas en el sistema, es decir, la cadena o marca comercial dueña de una o varias sedes, con su nombre comercial, su razón social y su NIT.  
**Clasificación:** Entidad.  
**Número de atributos:** 4.

### Atributos

#### Definición técnica

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Cantidad dígitos parte decimal (Precisión) | ¿Es autoincremento? | ¿Es obligatorio? | ¿Es llave primeria o es parte de ella? |
|---|---|---|---|---|---|---|---|
| `id` | UUID | 36 | — | — | NO | SI | SI |
| `nombreBarberia` | VARCHAR | 50 | — | — | NO | SI | NO |
| `razonSocial` | VARCHAR | 50 | — | — | NO | SI | NO |
| `nit` | VARCHAR | 12 | — | — | NO | SI | NO |

#### Llave foránea, restricciones y alias

| Nombre | ¿Es llave foránea? | Entidad | Columna(s) | ¿Posee restricción de unicidad o es parte de ella? | Nombre restricción unicidad a la que pertenece | ¿Posee restricción de chequeo o es parte de ella? | Nombre restricción chequeo a la que pertenece | ¿Posee restricción de índice o es parte de ella? | Tipo | Nombre restricción índice a la que pertenece | Alias |
|---|---|---|---|---|---|---|---|---|---|---|---|
| `id` | NO | — | — | SI | PK_barberia | NO | — | NO | — | — | — |
| `nombreBarberia` | NO | — | — | NO | — | NO | — | NO | — | — | — |
| `razonSocial` | NO | — | — | SI | UQ_barberia_razonSocial | NO | — | NO | — | — | — |
| `nit` | NO | — | — | SI | UQ_barberia_nit | NO | — | NO | — | — | — |

#### Descripción del campo

| Nombre | Descripción del campo |
|---|---|
| `id` | Identificador único del registro que es generado por la aplicación. |
| `nombreBarberia` | Nombre comercial de la barbería, con el que el cliente la ve para pedir sus citas. |
| `razonSocial` | Nombre legal de la empresa registrado en la cámara de comercio. Debe ser único en el sistema. |
| `nit` | Número de identificación tributaria que identifica legalmente a la barbería como empresa. Debe ser único en el sistema. |

### Clave primaria

- Atributo `id` (UUID, longitud 36). Restricción: `PK_barberia`. ¿Es autoincremento?: NO.

### Claves foráneas

No tiene claves foráneas.

### Restricciones

#### Restricciones de unicidad

- `PK_barberia` (clave primaria): `id`.
- `UQ_barberia_razonSocial`: `razonSocial`.
- `UQ_barberia_nit`: `nit`.

#### Restricciones de chequeo

No tiene restricciones de chequeo.

#### Restricciones de índice

No tiene restricciones de índice.

#### Obligatoriedad

- Obligatorios: `id`, `nombreBarberia`, `razonSocial`, `nit`.
- Opcionales: ninguno.

### Relaciones

Se listan las relaciones que establecen las claves foráneas. Ver también [Relaciones del modelo entidad-relación](#relaciones-del-modelo-entidad-relación).

#### Tablas que referencia

Ninguna.

#### Tablas que la referencian

- [Sede](#sede).`barberia` → `Barberia.id`

[↑ Volver al índice](#tablas)

---

## Sede

**Descripción:** Entidad que almacena las sucursales físicas de cada barbería, ubicadas en una ciudad, donde se ofrecen los servicios y trabajan los barberos.  
**Clasificación:** Entidad.  
**Número de atributos:** 5.

### Atributos

#### Definición técnica

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Cantidad dígitos parte decimal (Precisión) | ¿Es autoincremento? | ¿Es obligatorio? | ¿Es llave primeria o es parte de ella? |
|---|---|---|---|---|---|---|---|
| `id` | UUID | 36 | — | — | NO | SI | SI |
| `ciudad` | UUID | 36 | — | — | NO | SI | NO |
| `barberia` | UUID | 36 | — | — | NO | SI | NO |
| `nombre` | VARCHAR | 50 | — | — | NO | SI | NO |
| `direccion` | VARCHAR | 100 | — | — | NO | SI | NO |

#### Llave foránea, restricciones y alias

| Nombre | ¿Es llave foránea? | Entidad | Columna(s) | ¿Posee restricción de unicidad o es parte de ella? | Nombre restricción unicidad a la que pertenece | ¿Posee restricción de chequeo o es parte de ella? | Nombre restricción chequeo a la que pertenece | ¿Posee restricción de índice o es parte de ella? | Tipo | Nombre restricción índice a la que pertenece | Alias |
|---|---|---|---|---|---|---|---|---|---|---|---|
| `id` | NO | — | — | SI | PK_sede | NO | — | NO | — | — | — |
| `ciudad` | SI | [Ciudad](#ciudad) | id | NO | — | NO | — | NO | — | — | — |
| `barberia` | SI | [Barberia](#barberia) | id | SI | UQ_sede_barberia_nombre | NO | — | NO | — | — | — |
| `nombre` | NO | — | — | SI | UQ_sede_barberia_nombre | NO | — | NO | — | — | — |
| `direccion` | NO | — | — | NO | — | NO | — | NO | — | — | — |

#### Descripción del campo

| Nombre | Descripción del campo |
|---|---|
| `id` | Identificador único del registro que es generado por la aplicación. |
| `ciudad` | Referencia a la ciudad en la que está ubicada la sede. |
| `barberia` | Referencia a la barbería a la que pertenece la sede. Única en combinación con nombre. |
| `nombre` | Nombre con el que se identifica la sede dentro de su barbería. No puede repetirse dentro de una misma barbería (único en combinación con barberia). |
| `direccion` | Dirección física en la que está ubicada la sede. |

### Clave primaria

- Atributo `id` (UUID, longitud 36). Restricción: `PK_sede`. ¿Es autoincremento?: NO.

### Claves foráneas

| Atributo | Tabla referenciada | Columna(s) referenciada(s) | ¿Es obligatorio? | Restricción de unicidad en la que participa |
|---|---|---|---|---|
| `ciudad` | [Ciudad](#ciudad) | `id` | SI | Ninguna |
| `barberia` | [Barberia](#barberia) | `id` | SI | `UQ_sede_barberia_nombre` |

### Restricciones

#### Restricciones de unicidad

- `PK_sede` (clave primaria): `id`.
- `UQ_sede_barberia_nombre`: `barberia`, `nombre`.

#### Restricciones de chequeo

No tiene restricciones de chequeo.

#### Restricciones de índice

No tiene restricciones de índice.

#### Obligatoriedad

- Obligatorios: `id`, `ciudad`, `barberia`, `nombre`, `direccion`.
- Opcionales: ninguno.

### Relaciones

Se listan las relaciones que establecen las claves foráneas. Ver también [Relaciones del modelo entidad-relación](#relaciones-del-modelo-entidad-relación).

#### Tablas que referencia

- `Sede.ciudad` → [Ciudad](#ciudad).`id`
- `Sede.barberia` → [Barberia](#barberia).`id`

#### Tablas que la referencian

- [Servicio](#servicio).`sede` → `Sede.id`
- [Barbero](#barbero).`sedeDeTrabajo` → `Sede.id`
- [HorarioSede](#horariosede).`sede` → `Sede.id`
- [PeriodoCierre](#periodocierre).`sede` → `Sede.id`
- [SedeFestivo](#sedefestivo).`sede` → `Sede.id`

[↑ Volver al índice](#tablas)

---

## PeriodoCierre

**Descripción:** Entidad que registra los intervalos de fecha y hora durante los cuales una sede permanece cerrada por decisión de la barbería (por ejemplo vacaciones, mantenimiento o remodelación); mientras duran no se atiende a clientes ni se agendan citas.  
**Clasificación:** Entidad.  
**Número de atributos:** 4.

### Atributos

#### Definición técnica

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Cantidad dígitos parte decimal (Precisión) | ¿Es autoincremento? | ¿Es obligatorio? | ¿Es llave primeria o es parte de ella? |
|---|---|---|---|---|---|---|---|
| `id` | UUID | 36 | — | — | NO | SI | SI |
| `sede` | UUID | 36 | — | — | NO | SI | NO |
| `fechaHoraInicio` | DATETIME | — | — | — | NO | SI | NO |
| `fechaHoraFinal` | DATETIME | — | — | — | NO | SI | NO |

#### Llave foránea, restricciones y alias

| Nombre | ¿Es llave foránea? | Entidad | Columna(s) | ¿Posee restricción de unicidad o es parte de ella? | Nombre restricción unicidad a la que pertenece | ¿Posee restricción de chequeo o es parte de ella? | Nombre restricción chequeo a la que pertenece | ¿Posee restricción de índice o es parte de ella? | Tipo | Nombre restricción índice a la que pertenece | Alias |
|---|---|---|---|---|---|---|---|---|---|---|---|
| `id` | NO | — | — | SI | PK_periodoCierre | NO | — | NO | — | — | — |
| `sede` | SI | [Sede](#sede) | id | SI | UQ_periodoCierre_sede_fechaHoras | NO | — | NO | — | — | — |
| `fechaHoraInicio` | NO | — | — | SI | UQ_periodoCierre_sede_fechaHoras | NO | — | NO | — | — | — |
| `fechaHoraFinal` | NO | — | — | SI | UQ_periodoCierre_sede_fechaHoras | NO | — | NO | — | — | — |

#### Descripción del campo

| Nombre | Descripción del campo |
|---|---|
| `id` | Identificador único del registro que es generado por la aplicación. |
| `sede` | Referencia a la sede que permanece cerrada durante este periodo; por medio de ella se conoce la barbería. |
| `fechaHoraInicio` | Fecha y hora en la que la sede empieza a estar cerrada; desde ese momento no se atiende a clientes ni se agendan citas. |
| `fechaHoraFinal` | Fecha y hora en la que la sede vuelve a abrir. Debe ser posterior a fechaHoraInicio; una cita puede empezar justo en este momento. |

### Clave primaria

- Atributo `id` (UUID, longitud 36). Restricción: `PK_periodoCierre`. ¿Es autoincremento?: NO.

### Claves foráneas

| Atributo | Tabla referenciada | Columna(s) referenciada(s) | ¿Es obligatorio? | Restricción de unicidad en la que participa |
|---|---|---|---|---|
| `sede` | [Sede](#sede) | `id` | SI | `UQ_periodoCierre_sede_fechaHoras` |

### Restricciones

#### Restricciones de unicidad

- `PK_periodoCierre` (clave primaria): `id`.
- `UQ_periodoCierre_sede_fechaHoras`: `sede`, `fechaHoraInicio`, `fechaHoraFinal`.

#### Restricciones de chequeo

No tiene restricciones de chequeo.

#### Restricciones de índice

No tiene restricciones de índice.

#### Obligatoriedad

- Obligatorios: `id`, `sede`, `fechaHoraInicio`, `fechaHoraFinal`.
- Opcionales: ninguno.

### Relaciones

Se listan las relaciones que establecen las claves foráneas. Ver también [Relaciones del modelo entidad-relación](#relaciones-del-modelo-entidad-relación).

#### Tablas que referencia

- `PeriodoCierre.sede` → [Sede](#sede).`id`

#### Tablas que la referencian

Ninguna.

[↑ Volver al índice](#tablas)

---

## Festivo

**Descripción:** Entidad que almacena las fechas festivas de Colombia en las que, por ley, es día de descanso; el sistema las genera cada año a partir del calendario oficial de festivos y, por defecto, ninguna sede atiende en ellas.  
**Clasificación:** Entidad.  
**Número de atributos:** 3.

### Atributos

#### Definición técnica

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Cantidad dígitos parte decimal (Precisión) | ¿Es autoincremento? | ¿Es obligatorio? | ¿Es llave primeria o es parte de ella? |
|---|---|---|---|---|---|---|---|
| `id` | UUID | 36 | — | — | NO | SI | SI |
| `fecha` | DATE | — | — | — | NO | SI | NO |
| `nombre` | VARCHAR | 100 | — | — | NO | SI | NO |

#### Llave foránea, restricciones y alias

| Nombre | ¿Es llave foránea? | Entidad | Columna(s) | ¿Posee restricción de unicidad o es parte de ella? | Nombre restricción unicidad a la que pertenece | ¿Posee restricción de chequeo o es parte de ella? | Nombre restricción chequeo a la que pertenece | ¿Posee restricción de índice o es parte de ella? | Tipo | Nombre restricción índice a la que pertenece | Alias |
|---|---|---|---|---|---|---|---|---|---|---|---|
| `id` | NO | — | — | SI | PK_festivo | NO | — | NO | — | — | — |
| `fecha` | NO | — | — | SI | UQ_festivo_fecha | NO | — | NO | — | — | — |
| `nombre` | NO | — | — | NO | — | NO | — | NO | — | — | — |

#### Descripción del campo

| Nombre | Descripción del campo |
|---|---|
| `id` | Identificador único del registro que es generado por la aplicación. |
| `fecha` | Fecha en la que se descansa por el festivo, ya trasladada al lunes cuando la ley lo indica. La genera el sistema a partir del calendario oficial y debe ser única en el sistema. |
| `nombre` | Nombre con el que se conoce el festivo (por ejemplo, Día de la Raza); si dos festivos caen en la misma fecha, reúne el nombre de ambos. |

### Clave primaria

- Atributo `id` (UUID, longitud 36). Restricción: `PK_festivo`. ¿Es autoincremento?: NO.

### Claves foráneas

No tiene claves foráneas.

### Restricciones

#### Restricciones de unicidad

- `PK_festivo` (clave primaria): `id`.
- `UQ_festivo_fecha`: `fecha`.

#### Restricciones de chequeo

No tiene restricciones de chequeo.

#### Restricciones de índice

No tiene restricciones de índice.

#### Obligatoriedad

- Obligatorios: `id`, `fecha`, `nombre`.
- Opcionales: ninguno.

### Relaciones

Se listan las relaciones que establecen las claves foráneas. Ver también [Relaciones del modelo entidad-relación](#relaciones-del-modelo-entidad-relación).

#### Tablas que referencia

Ninguna.

#### Tablas que la referencian

- [SedeFestivo](#sedefestivo).`festivo` → `Festivo.id`

[↑ Volver al índice](#tablas)

---

## SedeFestivo

**Descripción:** Entidad asociativa que registra en qué festivos abre cada sede; si una sede no tiene registrada la apertura de un festivo ese día no atiende, y si la tiene atiende con su horario habitual del día de la semana en que cae el festivo.  
**Clasificación:** Entidad asociativa (tabla intermedia).  
**Número de atributos:** 3.

### Atributos

#### Definición técnica

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Cantidad dígitos parte decimal (Precisión) | ¿Es autoincremento? | ¿Es obligatorio? | ¿Es llave primeria o es parte de ella? |
|---|---|---|---|---|---|---|---|
| `id` | UUID | 36 | — | — | NO | SI | SI |
| `sede` | UUID | 36 | — | — | NO | SI | NO |
| `festivo` | UUID | 36 | — | — | NO | SI | NO |

#### Llave foránea, restricciones y alias

| Nombre | ¿Es llave foránea? | Entidad | Columna(s) | ¿Posee restricción de unicidad o es parte de ella? | Nombre restricción unicidad a la que pertenece | ¿Posee restricción de chequeo o es parte de ella? | Nombre restricción chequeo a la que pertenece | ¿Posee restricción de índice o es parte de ella? | Tipo | Nombre restricción índice a la que pertenece | Alias |
|---|---|---|---|---|---|---|---|---|---|---|---|
| `id` | NO | — | — | SI | PK_sedeFestivo | NO | — | NO | — | — | — |
| `sede` | SI | [Sede](#sede) | id | SI | UQ_sedeFestivo_sede_festivo | NO | — | NO | — | — | — |
| `festivo` | SI | [Festivo](#festivo) | id | SI | UQ_sedeFestivo_sede_festivo | NO | — | NO | — | — | — |

#### Descripción del campo

| Nombre | Descripción del campo |
|---|---|
| `id` | Identificador único del registro que es generado por la aplicación. |
| `sede` | Referencia a la sede de la barbería que abre en el festivo; por medio de ella se conoce la barbería. Única en combinación con festivo. |
| `festivo` | Referencia al festivo en el que abre la sede; ese día atiende con su horario habitual del día de la semana en que cae. Único en combinación con sede. |

### Clave primaria

- Atributo `id` (UUID, longitud 36). Restricción: `PK_sedeFestivo`. ¿Es autoincremento?: NO.

### Claves foráneas

| Atributo | Tabla referenciada | Columna(s) referenciada(s) | ¿Es obligatorio? | Restricción de unicidad en la que participa |
|---|---|---|---|---|
| `sede` | [Sede](#sede) | `id` | SI | `UQ_sedeFestivo_sede_festivo` |
| `festivo` | [Festivo](#festivo) | `id` | SI | `UQ_sedeFestivo_sede_festivo` |

### Restricciones

#### Restricciones de unicidad

- `PK_sedeFestivo` (clave primaria): `id`.
- `UQ_sedeFestivo_sede_festivo`: `sede`, `festivo`.

#### Restricciones de chequeo

No tiene restricciones de chequeo.

#### Restricciones de índice

No tiene restricciones de índice.

#### Obligatoriedad

- Obligatorios: `id`, `sede`, `festivo`.
- Opcionales: ninguno.

### Relaciones

Se listan las relaciones que establecen las claves foráneas. Ver también [Relaciones del modelo entidad-relación](#relaciones-del-modelo-entidad-relación).

#### Tablas que referencia

- `SedeFestivo.sede` → [Sede](#sede).`id`
- `SedeFestivo.festivo` → [Festivo](#festivo).`id`

#### Tablas que la referencian

Ninguna.

[↑ Volver al índice](#tablas)

---

## Relaciones del modelo entidad-relación


Esta sección reúne todas las relaciones que establecen las claves foráneas del modelo. Cada relación aparece también en la sección **Relaciones** de las dos tablas que participan.

> **Cardinalidades:** el modelo no especifica cardinalidades ni multiplicidades. Las columnas «¿Es obligatorio?» y «Restricción de unicidad» son las que condicionan cómo se puede usar cada referencia.

### Claves foráneas (25)

| # | Tabla de origen | Atributo FK | Tabla referenciada | Columna referenciada | ¿Es obligatorio? | Restricción de unicidad en la que participa | En ERDPlus |
|---|---|---|---|---|---|---|---|
| 1 | [Servicio](#servicio) | `sede` | [Sede](#sede) | `id` | SI | `UQ_servicio_sede_nombre` | Sí (`fk_Sede`) |
| 2 | [Barbero](#barbero) | `prefijo` | [PrefijoCelular](#prefijocelular) | `id` | SI | `UQ_barbero_prefijo_celular` | Sí (`fk_PrefijoCelular`) |
| 3 | [Barbero](#barbero) | `sedeDeTrabajo` | [Sede](#sede) | `id` | SI | Ninguna | Sí (`fk_Sede`) |
| 4 | [Cliente](#cliente) | `prefijoCelular` | [PrefijoCelular](#prefijocelular) | `id` | SI | `UQ_cliente_prefijoCelular_celular` | Sí (`fk_PrefijoCelular`) |
| 5 | [HorarioSede](#horariosede) | `sede` | [Sede](#sede) | `id` | SI | `UQ_horarioSede_horario` | Sí (`fk_Sede`) |
| 6 | [HorarioSede](#horariosede) | `diaDeLaSemana` | [DiaSemana](#diasemana) | `id` | SI | `UQ_horarioSede_horario` | Sí (`fk_DiaDeLaSemana`) |
| 7 | [Bloqueo](#bloqueo) | `barbero` | [Barbero](#barbero) | `id` | SI | `UQ_bloqueo_barbero_fechaHoras` | Sí (`fk_Barbero`) |
| 8 | [BarberoServicio](#barberoservicio) | `barbero` | [Barbero](#barbero) | `id` | SI | `UQ_barberoServicio_barbero_servicio` | Sí (`fk_Barbero`) |
| 9 | [BarberoServicio](#barberoservicio) | `servicio` | [Servicio](#servicio) | `id` | SI | `UQ_barberoServicio_barbero_servicio` | Sí (`fk_Servicio`) |
| 10 | [HorarioBarbero](#horariobarbero) | `barbero` | [Barbero](#barbero) | `id` | SI | `UQ_horarioBarbero_barbero_horario` | Sí (`fk_Barbero`) |
| 11 | [HorarioBarbero](#horariobarbero) | `horarioDeLaSede` | [HorarioSede](#horariosede) | `id` | SI | `UQ_horarioBarbero_barbero_horario` | Sí (`fk_HorarioBarberia`) |
| 12 | [Agenda](#agenda) | `horarioDelBarbero` | [HorarioBarbero](#horariobarbero) | `id` | SI | `UQ_agenda_horarioDelBarbero_fecha` | Sí (`fk_HorarioBarbero`) |
| 13 | [Cita](#cita) | `cliente` | [Cliente](#cliente) | `id` | SI | Ninguna | Sí (`fk_Cliente`) |
| 14 | [Cita](#cita) | `agenda` | [Agenda](#agenda) | `id` | SI | `UQ_cita_agenda_horaInicio` | Sí (`fk_Agenda`) |
| 15 | [Cita](#cita) | `estado` | [Estado](#estado) | `id` | SI | Ninguna | Sí (`fk_Estado`) |
| 16 | [CitaServicio](#citaservicio) | `cita` | [Cita](#cita) | `id` | SI | `UQ_citaServicio_cita_barberoServicio` | Sí (`fk_Cita`) |
| 17 | [CitaServicio](#citaservicio) | `barberoServicio` | [BarberoServicio](#barberoservicio) | `id` | SI | `UQ_citaServicio_cita_barberoServicio` | Sí (`fk_BarberoServicio`) |
| 18 | [Multa](#multa) | `cita` | [Cita](#cita) | `id` | SI | `UQ_multa_cita` | Sí (`fk_Cita`) |
| 19 | [Multa](#multa) | `tipo` | [TipoMulta](#tipomulta) | `id` | SI | Ninguna | Sí (`fk_TipoMulta`) |
| 20 | [Ciudad](#ciudad) | `departamento` | [Departamento](#departamento) | `id` | SI | `UQ_ciudad_nombre_departamento` | Sí (`fk_Departamento`) |
| 21 | [Sede](#sede) | `ciudad` | [Ciudad](#ciudad) | `id` | SI | Ninguna | Sí (`fk_Ciudad`) |
| 22 | [Sede](#sede) | `barberia` | [Barberia](#barberia) | `id` | SI | `UQ_sede_barberia_nombre` | Sí (`fk_Barberia`) |
| 23 | [PeriodoCierre](#periodocierre) | `sede` | [Sede](#sede) | `id` | SI | `UQ_periodoCierre_sede_fechaHoras` | Sí (`fk_Sede`) |
| 24 | [SedeFestivo](#sedefestivo) | `sede` | [Sede](#sede) | `id` | SI | `UQ_sedeFestivo_sede_festivo` | Sí (`fk_Sede`) |
| 25 | [SedeFestivo](#sedefestivo) | `festivo` | [Festivo](#festivo) | `id` | SI | `UQ_sedeFestivo_sede_festivo` | Sí (`fk_Festivo`) |

### Relaciones por tabla referenciada

Vista inversa: qué tablas dependen de cada tabla.

- [DiaSemana](#diasemana) es referenciada por: [HorarioSede](#horariosede).`diaDeLaSemana`.
- [Estado](#estado) es referenciada por: [Cita](#cita).`estado`.
- [Servicio](#servicio) es referenciada por: [BarberoServicio](#barberoservicio).`servicio`.
- [PrefijoCelular](#prefijocelular) es referenciada por: [Barbero](#barbero).`prefijo`, [Cliente](#cliente).`prefijoCelular`.
- [TipoMulta](#tipomulta) es referenciada por: [Multa](#multa).`tipo`.
- [Barbero](#barbero) es referenciada por: [Bloqueo](#bloqueo).`barbero`, [BarberoServicio](#barberoservicio).`barbero`, [HorarioBarbero](#horariobarbero).`barbero`.
- [Cliente](#cliente) es referenciada por: [Cita](#cita).`cliente`.
- [HorarioSede](#horariosede) es referenciada por: [HorarioBarbero](#horariobarbero).`horarioDeLaSede`.
- [BarberoServicio](#barberoservicio) es referenciada por: [CitaServicio](#citaservicio).`barberoServicio`.
- [HorarioBarbero](#horariobarbero) es referenciada por: [Agenda](#agenda).`horarioDelBarbero`.
- [Agenda](#agenda) es referenciada por: [Cita](#cita).`agenda`.
- [Cita](#cita) es referenciada por: [CitaServicio](#citaservicio).`cita`, [Multa](#multa).`cita`.
- [Departamento](#departamento) es referenciada por: [Ciudad](#ciudad).`departamento`.
- [Ciudad](#ciudad) es referenciada por: [Sede](#sede).`ciudad`.
- [Barberia](#barberia) es referenciada por: [Sede](#sede).`barberia`.
- [Sede](#sede) es referenciada por: [Servicio](#servicio).`sede`, [Barbero](#barbero).`sedeDeTrabajo`, [HorarioSede](#horariosede).`sede`, [PeriodoCierre](#periodocierre).`sede`, [SedeFestivo](#sedefestivo).`sede`.
- [Festivo](#festivo) es referenciada por: [SedeFestivo](#sedefestivo).`festivo`.

### Tablas intermedias

Las siguientes tablas son entidades asociativas: resuelven relaciones de muchos a muchos entre otras dos.

#### BarberoServicio

Entidad asociativa que registra qué servicios sabe hacer cada barbero, cuánto tarda en realizarlos y cuánto tiempo extra reserva para ellos.

- Une: [Barbero](#barbero) (por `barbero`) y [Servicio](#servicio) (por `servicio`).
- Restricción de unicidad sobre las referencias: `UQ_barberoServicio_barbero_servicio`.
- Atributos propios: `duracionEnHoras`, `duracionEnMinutos`, `tiempoExtra`, `vigente`.
- Detalle completo: [BarberoServicio](#barberoservicio).

#### CitaServicio

Entidad asociativa que registra cada servicio incluido dentro de una cita, congelando el precio y la duración que tenía ese servicio para ese barbero en el momento de agendarla.

- Une: [Cita](#cita) (por `cita`) y [BarberoServicio](#barberoservicio) (por `barberoServicio`).
- Restricción de unicidad sobre las referencias: `UQ_citaServicio_cita_barberoServicio`.
- Atributos propios: `precioServicio`, `duracionEnHorasElServicio`, `duracionEnMinutosElServicio`, `tiempoExtra`.
- Detalle completo: [CitaServicio](#citaservicio).

#### SedeFestivo

Entidad asociativa que registra en qué festivos abre cada sede; si una sede no tiene registrada la apertura de un festivo ese día no atiende, y si la tiene atiende con su horario habitual del día de la semana en que cae el festivo.

- Une: [Sede](#sede) (por `sede`) y [Festivo](#festivo) (por `festivo`).
- Restricción de unicidad sobre las referencias: `UQ_sedeFestivo_sede_festivo`.
- Atributos propios: ninguno.
- Detalle completo: [SedeFestivo](#sedefestivo).

### Cadenas de dependencia relevantes

Recorridos que se obtienen siguiendo las claves foráneas:

- **Ubicación:** `Sede.ciudad` → `Ciudad.departamento` → `Departamento`; `Sede.barberia` → `Barberia`.
- **Horarios y agenda:** `Agenda.horarioDelBarbero` → `HorarioBarbero.horarioDeLaSede` → `HorarioSede.sede` → `Sede`; `HorarioSede.diaDeLaSemana` → `DiaSemana`.
- **Cita y servicios:** `CitaServicio.cita` → `Cita`; `CitaServicio.barberoServicio` → `BarberoServicio.servicio` → `Servicio.sede` → `Sede`.
- **Sanciones:** `Multa.cita` → `Cita.cliente` → `Cliente`; `Multa.tipo` → `TipoMulta`.
- **Festivos:** `SedeFestivo.sede` → `Sede`; `SedeFestivo.festivo` → `Festivo`.

### Contraste con el modelo de ERDPlus

Las 25 claves foráneas coinciden con las 25 relaciones del archivo `Modelo MER.erdplus`. En ERDPlus las columnas de llave foránea usan el nombre técnico `fk_<Tabla>`; en este modelo se usa el nombre de dominio del atributo (por ejemplo, `sedeDeTrabajo` en lugar de `fk_Sede`). Además, algunos nombres difieren: `HorarioSede` se llama `HorarioBarberia` en ERDPlus, y los atributos `Estado.nombre`, `PrefijoCelular.prefijo`, `Barbero.elNumeroCelularEsCorrecto` y `PeriodoCierre.fechaHoraFinal` aparecen como `nombe`, `nombre`, `elNumeroDeCelularEsCorrecto` y `fechaHoraFin`.

[↑ Volver al índice](#tablas)

---

## Restricciones del modelo


Consolidado de todas las restricciones del modelo. El detalle de cada atributo está en la sección de su tabla.

### Claves primarias (22)

| Tabla | Restricción | Atributo(s) | Tipo de dato | ¿Es autoincremento? |
|---|---|---|---|---|
| [DiaSemana](#diasemana) | `PK_diaSemana` | `id` | UUID(36) | NO |
| [Estado](#estado) | `PK_estado` | `id` | UUID(36) | NO |
| [Servicio](#servicio) | `PK_servicio` | `id` | UUID(36) | NO |
| [PrefijoCelular](#prefijocelular) | `PK_prefijoCelular` | `id` | UUID(36) | NO |
| [TipoMulta](#tipomulta) | `PK_tipoMulta` | `id` | UUID(36) | NO |
| [Barbero](#barbero) | `PK_barbero` | `id` | UUID(36) | NO |
| [Cliente](#cliente) | `PK_cliente` | `id` | UUID(36) | NO |
| [HorarioSede](#horariosede) | `PK_horarioSede` | `id` | UUID(36) | NO |
| [Bloqueo](#bloqueo) | `PK_bloqueo` | `id` | UUID(36) | NO |
| [BarberoServicio](#barberoservicio) | `PK_barberoServicio` | `id` | UUID(36) | NO |
| [HorarioBarbero](#horariobarbero) | `PK_horarioBarbero` | `id` | UUID(36) | NO |
| [Agenda](#agenda) | `PK_agenda` | `id` | UUID(36) | NO |
| [Cita](#cita) | `PK_cita` | `id` | UUID(36) | NO |
| [CitaServicio](#citaservicio) | `PK_citaServicio` | `id` | UUID(36) | NO |
| [Multa](#multa) | `PK_multa` | `id` | UUID(36) | NO |
| [Departamento](#departamento) | `PK_departamento` | `id` | UUID(36) | NO |
| [Ciudad](#ciudad) | `PK_ciudad` | `id` | UUID(36) | NO |
| [Barberia](#barberia) | `PK_barberia` | `id` | UUID(36) | NO |
| [Sede](#sede) | `PK_sede` | `id` | UUID(36) | NO |
| [PeriodoCierre](#periodocierre) | `PK_periodoCierre` | `id` | UUID(36) | NO |
| [Festivo](#festivo) | `PK_festivo` | `id` | UUID(36) | NO |
| [SedeFestivo](#sedefestivo) | `PK_sedeFestivo` | `id` | UUID(36) | NO |

### Restricciones de unicidad (23)

| Tabla | Restricción | Atributos que la componen |
|---|---|---|
| [DiaSemana](#diasemana) | `UQ_diaSemana_nombre` | `nombre` |
| [Estado](#estado) | `UQ_estado_nombre` | `nombre` |
| [Servicio](#servicio) | `UQ_servicio_sede_nombre` | `sede`, `nombre` |
| [PrefijoCelular](#prefijocelular) | `UQ_prefijoCelular_prefijo` | `prefijo` |
| [TipoMulta](#tipomulta) | `UQ_tipoMulta_nombre` | `nombre` |
| [Barbero](#barbero) | `UQ_barbero_prefijo_celular` | `prefijo`, `celular` |
| [Cliente](#cliente) | `UQ_cliente_prefijoCelular_celular` | `prefijoCelular`, `celular` |
| [HorarioSede](#horariosede) | `UQ_horarioSede_horario` | `sede`, `diaDeLaSemana`, `horaApertura`, `horaCierre`, `fechaCreacion`, `fechaDesactivacion` |
| [Bloqueo](#bloqueo) | `UQ_bloqueo_barbero_fechaHoras` | `barbero`, `fechaHoraInicio`, `fechaHoraFinal` |
| [BarberoServicio](#barberoservicio) | `UQ_barberoServicio_barbero_servicio` | `barbero`, `servicio` |
| [HorarioBarbero](#horariobarbero) | `UQ_horarioBarbero_barbero_horario` | `barbero`, `horarioDeLaSede`, `horaInicio`, `horaFinal`, `fechaCreacion`, `fechaDesactivacion` |
| [Agenda](#agenda) | `UQ_agenda_horarioDelBarbero_fecha` | `horarioDelBarbero`, `fecha` |
| [Cita](#cita) | `UQ_cita_agenda_horaInicio` | `agenda`, `horaInicio` |
| [CitaServicio](#citaservicio) | `UQ_citaServicio_cita_barberoServicio` | `cita`, `barberoServicio` |
| [Multa](#multa) | `UQ_multa_cita` | `cita` |
| [Departamento](#departamento) | `UQ_departamento_nombre` | `nombre` |
| [Ciudad](#ciudad) | `UQ_ciudad_nombre_departamento` | `nombre`, `departamento` |
| [Barberia](#barberia) | `UQ_barberia_razonSocial` | `razonSocial` |
| [Barberia](#barberia) | `UQ_barberia_nit` | `nit` |
| [Sede](#sede) | `UQ_sede_barberia_nombre` | `barberia`, `nombre` |
| [PeriodoCierre](#periodocierre) | `UQ_periodoCierre_sede_fechaHoras` | `sede`, `fechaHoraInicio`, `fechaHoraFinal` |
| [Festivo](#festivo) | `UQ_festivo_fecha` | `fecha` |
| [SedeFestivo](#sedefestivo) | `UQ_sedeFestivo_sede_festivo` | `sede`, `festivo` |

### Restricciones de chequeo (12)

La condición de cada restricción de chequeo está escrita en la descripción del campo.

| Tabla | Restricción | Atributo | Tipo de dato | Dígitos parte entera | Condición (descripción del campo) |
|---|---|---|---|---|---|
| [Servicio](#servicio) | `CHK_servicio_precio` | `precio` | INT | 7 | Valor del servicio en pesos colombianos en esa sede. Debe estar entre 0 y 2.000.000. |
| [BarberoServicio](#barberoservicio) | `CHK_barberoServicio_duracionEnHoras` | `duracionEnHoras` | INT | 1 | Cantidad de horas que tarda el barbero en realizar el servicio. Debe estar entre 0 y 3. |
| [BarberoServicio](#barberoservicio) | `CHK_barberoServicio_duracionEnMinutos` | `duracionEnMinutos` | INT | 2 | Cantidad de minutos que tarda el barbero en realizar el servicio. Debe estar entre 0 y 59. |
| [BarberoServicio](#barberoservicio) | `CHK_barberoServicio_tiempoExtra` | `tiempoExtra` | INT | 2 | Minutos de colchón que el barbero reserva para este servicio. Debe estar entre 0 y 59. |
| [Cita](#cita) | `CHK_cita_porcentajeDescuento` | `porcentajeDescuento` | INT | 3 | Porcentaje de descuento que el barbero deja congelado en la cita por si se demora en atenderla. Debe estar entre 0 y 100. |
| [Cita](#cita) | `CHK_cita_multa` | `multa` | INT | 6 | Valor de la sanción que se le cobra al cliente si su tardanza supera el tiempoEspera de esta cita. Debe estar entre 0 y 100.000. |
| [Cita](#cita) | `CHK_cita_tiempoEspera` | `tiempoEspera` | INT | 2 | Minutos de tolerancia que aplican por igual al cliente y al barbero en esta cita. Debe estar entre 0 y 60. |
| [CitaServicio](#citaservicio) | `CHK_citaServicio_precioServicio` | `precioServicio` | INT | 7 | Precio que tenía el servicio en el momento en que se agendó la cita. Debe estar entre 0 y 2.000.000. |
| [CitaServicio](#citaservicio) | `CHK_citaServicio_duracionEnHorasElServicio` | `duracionEnHorasElServicio` | INT | 1 | Duración en horas que tenía el servicio para ese barbero en el momento de agendar la cita. Debe estar entre 0 y 3. |
| [CitaServicio](#citaservicio) | `CHK_citaServicio_duracionEnMinutosElServicio` | `duracionEnMinutosElServicio` | INT | 2 | Duración en minutos que tenía el servicio para ese barbero en el momento de agendar la cita. Debe estar entre 0 y 59. |
| [CitaServicio](#citaservicio) | `CHK_citaServicio_tiempoExtra` | `tiempoExtra` | INT | 2 | Tiempo extra en minutos que el barbero tenía configurado para este servicio al agendar la cita. Debe estar entre 0 y 59. |
| [Multa](#multa) | `CHK_multa_monto` | `monto` | INT | 7 | Valor en pesos colombianos que debe pagar el cliente por esta multa. Debe estar entre 0 y 1.000.000. |

### Restricciones de índice

Ningún atributo tiene restricción de índice.

### Atributos opcionales

Todos los atributos son obligatorios excepto los siguientes:

| Tabla | Atributo | Tipo de dato | Descripción |
|---|---|---|---|
| [Servicio](#servicio) | `descripcion` | VARCHAR | Descripción de lo que incluye el servicio. Campo opcional. |
| [Barbero](#barbero) | `segundoNombre` | VARCHAR | Segundo nombre del barbero. Campo opcional. |
| [Barbero](#barbero) | `segundoApellido` | VARCHAR | Segundo apellido del barbero. Campo opcional. |
| [Cliente](#cliente) | `segundoNombre` | VARCHAR | Segundo nombre del cliente. Campo opcional. |
| [Cliente](#cliente) | `segundoApellido` | VARCHAR | Segundo apellido del cliente. Campo opcional. |
| [HorarioSede](#horariosede) | `fechaDesactivacion` | DATE | Fecha en la que este horario dejó de estar vigente. La toma el sistema en ese momento. |
| [HorarioBarbero](#horariobarbero) | `fechaDesactivacion` | DATE | Fecha en la que este horario dejó de estar vigente. |
| [Multa](#multa) | `fechaHoraPago` | DATETIME | Fecha y hora en la que el cliente pagó esta multa. |

### Autoincremento

Ningún atributo es autoincremental. Los identificadores son UUID generados por la aplicación.

### Integridad referencial

Cada una de las 25 claves foráneas referencia la columna `id` de la tabla de destino. Ver [Relaciones del modelo entidad-relación](#relaciones-del-modelo-entidad-relación).

[↑ Volver al índice](#tablas)

---

## Vistas de datos calculados

Los datos calculados no se guardan como columnas: se obtienen por medio de vistas. El modelo define estas vistas:

- `horaFinEstimada` de [Cita](#cita) (TIME), calculada a partir de Cita, CitaServicio. Ver [Cita › Vistas](#vistas).
- `precioTotal` de [Cita](#cita) (INT), calculada a partir de Cita, CitaServicio, Estado. Ver [Cita › Vistas](#vistas).
- La descripción de [Cliente](#cliente) indica que su estado de veto tampoco se guarda como columna, sino que se obtiene por medio de una vista a partir de sus multas sin pagar (esa vista todavía no está detallada).
