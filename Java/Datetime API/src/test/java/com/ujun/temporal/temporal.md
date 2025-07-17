## Temporal
Di dalam package java.time, sebenarnya ada package java.time.temporal
Di dalam package java.time.temporal terdapat banyak sekali interface yang merupakan kontrak dari Java Date & Time API

## Temporal Interfaces
| Interface         | Keterangan                                                                  |
|-------------------|-----------------------------------------------------------------------------|
| Temporal          | Interface untuk temporal object, seperti date, time, dan lain-lain          |
| TemporalAmount    | Interface untuk jumlah waktu, seperti duration dan period                   |
| TemporalUnit      | Interface untuk unit satuan temporal, seperti jam, menit, hari              |
| TemporalField     | Interface untuk field dalam temporal data                                   |
| TemporalQuery     | Interface untuk query data dari TemporalAccessor (super interface Temporal) |
| TemporalAdjuster  | Strategi untuk menyesuaikan objek temporal.                                 |