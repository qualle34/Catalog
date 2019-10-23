C:
cd C:\Program Files\MySQL\MySQL Server 8.0\bin

chcp 65001

mysql -u root -p < D:\Projects\Senla\data\db\create.sql

mysql -u root -p catalog < D:\Projects\Senla\data\db\insert.sql