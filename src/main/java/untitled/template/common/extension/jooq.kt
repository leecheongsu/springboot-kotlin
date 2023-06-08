package untitled.template.common.extension

import org.jooq.*
import org.jooq.impl.DSL
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.temporal.Temporal

typealias JavaTimeZone = java.util.TimeZone

inline fun <reified T : Temporal> Field<T>.atTimeZone(timeZone: String): Field<T> {
    return DSL.field("{0} at time zone '$timeZone'", T::class.java, this)
}

fun <E : Query> Collection<E>.batch(dsl: DSLContext) {
    dsl.batch(this).execute()
}

fun <T : Field<*>> Array<T>.excludes(vararg fields: Field<*>): List<T> = this.filter { fields.contains(it).not() }

fun <R : Record> Table<R>.fieldsExcludes(vararg fields: Field<*>): Array<Field<*>> = this.fields().excludes(*fields).toTypedArray()
