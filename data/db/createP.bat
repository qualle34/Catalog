C:
cd C:\Program Files\MySQL\MySQL Server 8.0\bin

chcp 65001

mysql -u qualle -p < D:\Projects\Senla\data\db\create.sql

mysql -u qualle -p catalog < D:\Projects\Senla\data\db\insert.sql