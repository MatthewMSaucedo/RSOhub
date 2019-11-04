using System.Collections.Generic;

namespace RSOhub.API.Models
{
    public class User
    {
        public int UserId { get; set; }
        public string Username { get; set; }
        public byte[] PasswordHash { get; set; }
        public byte[] PasswordSalt { get; set; }
        public List<Comment> Comments { get; set; }
        public University University { get; set; }
    }
}
