using System.Collections.Generic;

namespace RSOhub.API.Models
{
    public class Event
    {
        public int EventId { get; set; }
        public Location Location { get; set; }
        public string EventName { get; set; }
        public string Description { get; set; }
        public System.DateTime StartTime { get; set; }
        public List<Comment> Comments { get; set ;}
    }
}