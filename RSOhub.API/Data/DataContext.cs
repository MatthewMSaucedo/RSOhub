using Microsoft.EntityFrameworkCore;
using RSOhub.API.Models;

namespace RSOhub.API.Data
{
    public class DataContext : DbContext
    {
        public DataContext(DbContextOptions<DataContext> options) : base (options) {}

        public DbSet<Value> Values { get; set; }
    }
}