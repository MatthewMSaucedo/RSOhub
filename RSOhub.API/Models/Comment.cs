namespace RSOhub.API.Models
{
    public class Comment
    {
        public int UserId { get; set; }
        public User User { get; set; }
        public int EventId { get; set; }
        public Event Event { get; set; }
        public string Text { get; set; }
        public int Rating { get; set; }
        public System.DateTime TimeStamp { get; set; }
    }
}