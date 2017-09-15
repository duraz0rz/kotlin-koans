package iii_conventions

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        if (this.year == other.year) {
            if (this.month == other.month)
                return this.dayOfMonth.compareTo(other.dayOfMonth)
            return this.month.compareTo(other.month)
        }

        return this.year.compareTo(other.year)
    }
}

data class RepeatingTimeInterval(val interval: TimeInterval, val number: Int)

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)
operator fun MyDate.plus(interval: TimeInterval) : MyDate = this.addTimeIntervals(interval, 1)
operator fun MyDate.plus(interval: RepeatingTimeInterval) : MyDate = this.addTimeIntervals(interval.interval, interval.number)

operator fun TimeInterval.times(number: Int) : RepeatingTimeInterval = RepeatingTimeInterval(this, number)

class DateRange(val start: MyDate, val endInclusive: MyDate) : Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> = object : Iterator<MyDate> {
        var current = start
        override fun hasNext(): Boolean {
            return current <= endInclusive
        }

        override fun next(): MyDate {
            val result = current
            current = current.nextDay()
            return result
        }
    }


    operator fun contains(date: MyDate): Boolean {
        return date >= start && date <= endInclusive
    }
}

