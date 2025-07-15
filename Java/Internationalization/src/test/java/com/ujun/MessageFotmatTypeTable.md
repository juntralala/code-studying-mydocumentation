| FormatType | FormatStyle    | Subformat Created    |
|---|---|---|
| (none)    | (none)    | null    |
| number    | (none)    | `NumberFormat.getInstance(getLocale())`    |
|    | integer    | `NumberFormat.getIntegerInstance(getLocale())`    |
|    | currency    | `NumberFormat.getCurrencyInstance(getLocale())`    |
|    | percent    | `NumberFormat.getPercentInstance(getLocale())`    |
|    | SubformatPattern  | `new DecimalFormat(subformatPattern, DecimalFormatSymbols.getInstance(getLocale()))` |
| date    | (none)    | `DateFormat.getDateTime(DateFormat.DEFAULT, getLocale())`    |
|    | short    | `DateFormat.getDateTime(DateFormat.SHORT, getLocale())`    |
|    | medium    | `DateFormat.getDateTime(DateFormat.DEFAULT, getLocale())`    |
|    | long    | `DateFormat.getDateTime(DateFormat.LONG, getLocale())`    |
|    | full    | `DateFormat.getDateTime(DateFormat.FULL, getLocale())`    |
|    | SubformatPattern  | `new SimpleDateFormat(subformatPattern, getLocale())`    |
| time    | (none)    | `DateFormat.getTimeInstance(DateFormat.DEFAULT, getLocale())`    |
|    | short    | `DateFormat.getTimeInstance(DateFormat.SHORT, getLocale())`    |
|    | medium    | `DateFormat.getTimeInstance(DateFormat.DEFAULT, getLocale())`    |
|    | long    | `DateFormat.getTimeInstance(DateFormat.LONG, getLocale())`    |
|    | full    | `DateFormat.getTimeInstance(DateFormat.FULL, getLocale())`    |
|    | SubformatPattern  | `new SimpleDateFormat(subformatPattern, getLocale())`    |
| choice    | SubformatPattern  | `new ChoiceFormat(subformatPattern)`    |